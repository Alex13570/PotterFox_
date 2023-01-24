package ru.loonolud.potterfox_.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.loonolud.potterfox_.api.UserApi;
import ru.loonolud.potterfox_.dto.request.AuthRequest;
import ru.loonolud.potterfox_.dto.request.RefreshTokenRequest;
import ru.loonolud.potterfox_.dto.request.SignUpRequest;
import ru.loonolud.potterfox_.dto.response.AuthResponse;
import ru.loonolud.potterfox_.service.MyUserDetailsService;

@RequiredArgsConstructor
public class UserController implements UserApi {
    private final MyUserDetailsService authService;

    @Override
    @ResponseStatus(HttpStatus.OK)
    public AuthResponse signIn(AuthRequest authRequestDto) {
        return authService.signIn(authRequestDto);
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    public AuthResponse refreshToken(RefreshTokenRequest tokenRequest) {
        return authService.updateAccessTokenWithRefreshToken(tokenRequest);
    }

    @Override
    @ResponseStatus(HttpStatus.CREATED)
    public AuthResponse signUp(SignUpRequest request) {
        return authService.signUp(request);
    }
}
