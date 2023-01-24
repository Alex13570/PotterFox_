package ru.loonolud.potterfox_.service;

import ru.loonolud.potterfox_.dto.request.AuthRequest;
import ru.loonolud.potterfox_.dto.request.RefreshTokenRequest;
import ru.loonolud.potterfox_.dto.request.SignUpRequest;
import ru.loonolud.potterfox_.dto.response.AuthResponse;

public interface MyUserDetailsService {
    AuthResponse signIn(AuthRequest authRequestDto);
    AuthResponse updateAccessTokenWithRefreshToken(RefreshTokenRequest tokenRequest);
    AuthResponse signUp(SignUpRequest request);
}
