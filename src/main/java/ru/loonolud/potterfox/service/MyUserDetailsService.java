package ru.loonolud.potterfox.service;

import ru.loonolud.potterfox.dto.request.AuthRequest;
import ru.loonolud.potterfox.dto.request.RefreshTokenRequest;
import ru.loonolud.potterfox.dto.request.SignUpRequest;
import ru.loonolud.potterfox.dto.response.AuthResponse;

public interface MyUserDetailsService {

    AuthResponse signIn(AuthRequest authRequestDto);

    AuthResponse updateAccessTokenWithRefreshToken(RefreshTokenRequest tokenRequest);

    AuthResponse signUp(SignUpRequest request);

}
