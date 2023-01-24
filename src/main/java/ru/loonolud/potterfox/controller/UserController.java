package ru.loonolud.potterfox.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.loonolud.potterfox.api.UserApi;
import ru.loonolud.potterfox.dto.request.AuthRequest;
import ru.loonolud.potterfox.dto.request.RefreshTokenRequest;
import ru.loonolud.potterfox.dto.request.SignUpRequest;
import ru.loonolud.potterfox.dto.response.AuthResponse;
import ru.loonolud.potterfox.service.MyUserDetailsService;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final MyUserDetailsService authService;

    @Override
    public AuthResponse signIn(AuthRequest authRequestDto) {
        return authService.signIn(authRequestDto);
    }

    @Override
    public AuthResponse refreshToken(RefreshTokenRequest tokenRequest) {
        return authService.updateAccessTokenWithRefreshToken(tokenRequest);
    }

    @Override
    public AuthResponse signUp(SignUpRequest request) {
        return authService.signUp(request);
    }

}
