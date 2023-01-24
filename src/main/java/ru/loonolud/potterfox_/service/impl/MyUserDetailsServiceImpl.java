package ru.loonolud.potterfox_.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.util.ArrayUtils;
import ru.loonolud.potterfox_.api.Role;
import ru.loonolud.potterfox_.dto.request.AuthRequest;
import ru.loonolud.potterfox_.dto.request.RefreshTokenRequest;
import ru.loonolud.potterfox_.dto.request.SignUpRequest;
import ru.loonolud.potterfox_.dto.response.AuthResponse;
import ru.loonolud.potterfox_.exceptions.token.InvalidTokenException;
import ru.loonolud.potterfox_.exceptions.user.UserEmailAlreadyTakenException;
import ru.loonolud.potterfox_.exceptions.user.UserNotFoundException;
import ru.loonolud.potterfox_.exceptions.user.UserUnauthorizedException;
import ru.loonolud.potterfox_.model.RefreshToken;
import ru.loonolud.potterfox_.model.UserDetailsEntity;
import ru.loonolud.potterfox_.model.UserInfoEntity;
import ru.loonolud.potterfox_.repositiry.RefreshTokenRepository;
import ru.loonolud.potterfox_.repositiry.UserInfoRepository;
import ru.loonolud.potterfox_.repositiry.UserRepository;
import ru.loonolud.potterfox_.security.TokenProvider;
import ru.loonolud.potterfox_.service.MyUserDetailsService;

import java.time.Instant;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MyUserDetailsServiceImpl implements MyUserDetailsService {

    private final TokenProvider tokenProvider;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final UserInfoRepository userInfoRepository;
    private final RefreshTokenRepository refreshTokenRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse signIn(AuthRequest authRequestDto) {
        try{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequestDto.getEmail(), authRequestDto.getPassword()));
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String accessToken = tokenProvider.generateAccessToken(userDetails.getUsername(),
                    userDetails.getAuthorities().stream()
                            .map(GrantedAuthority::getAuthority).collect(Collectors.joining(",")));
            UserDetailsEntity user = userRepository.findByEmail(authRequestDto.getEmail())
                    .orElseThrow(UserNotFoundException::new);
            RefreshToken refreshToken = tokenProvider.generateRefreshToken(user);
            user = saveRefreshTokenInUserAccount(user, refreshToken);
            return AuthResponse.builder()
                    .refreshToken(user.getRefreshToken().toString())
                    .accessToken(accessToken)
                    .role(user.getRole().toString())
                    .email(user.getEmail())
                    .firstName(user.getUserInfo().getFirstName())
                    .lastName(user.getUserInfo().getLastName())
                    .build();

        }catch (AuthenticationException e){
            throw new UserUnauthorizedException(e.getMessage());
        }
    }

    @Override
    public AuthResponse updateAccessTokenWithRefreshToken(RefreshTokenRequest tokenRequest) {
        RefreshToken refreshToken = refreshTokenRepository.findById(tokenRequest.getRefreshToken())
                .orElseThrow(InvalidTokenException::new);

        if(!refreshToken.getExpiredTime().isAfter(Instant.now())) throw new InvalidTokenException();

        UserDetailsEntity userAccount = userRepository.findByRefreshToken(refreshToken)
                .orElseThrow(UserNotFoundException::new);
        String accessToken = tokenProvider.generateAccessToken(userAccount.getEmail(), userAccount.getRole().toString());
        refreshToken = tokenProvider.generateRefreshToken(userAccount);
        userAccount = saveRefreshTokenInUserAccount(userAccount, refreshToken);
        return AuthResponse.builder()
                .refreshToken(userAccount.getRefreshToken().getId().toString())
                .accessToken(accessToken)
                .email(userAccount.getEmail())
                .role(userAccount.getRole().toString())
                .firstName(userAccount.getUserInfo().getFirstName())
                .lastName(userAccount.getUserInfo().getLastName())
                .build();
    }

    @Override
    public AuthResponse signUp(SignUpRequest request) {
        if(userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new UserEmailAlreadyTakenException();
        }

        userRepository.save(UserDetailsEntity.builder()
                .id(UUID.randomUUID())
                .email(request.getEmail())
                .role(Role.USER)
                .password(passwordEncoder.encode(request
                        .getPassword())
                        .chars()
                        .mapToObj(c -> (char)c)
                        .toArray(Character[]::new))
                .userInfo(userInfoRepository.save(UserInfoEntity.builder()
                        .firstName(request.getFirstName())
                        .lastName(request.getLastName())
                        .build()))
                .build());

        return signIn(AuthRequest.builder().email(request.getEmail()).password(request.getPassword()
                .chars()
                .mapToObj(c -> (char)c)
                .toArray(Character[]::new)).build());

    }

    private UserDetailsEntity saveRefreshTokenInUserAccount(UserDetailsEntity userAccount, RefreshToken refreshToken) {
        userAccount.setRefreshToken(refreshToken);
        return userRepository.save(userAccount);
    }
}
