package ru.loonolud.potterfox_.security;

import org.springframework.security.core.Authentication;
import ru.loonolud.potterfox_.model.RefreshToken;
import ru.loonolud.potterfox_.model.UserDetailsEntity;

import javax.servlet.http.HttpServletRequest;

public interface TokenProvider {
    String generateAccessToken(String email, String role);
    RefreshToken generateRefreshToken(UserDetailsEntity userAccount);
    boolean isValidAccessToken(String token);
    Authentication getAuthenticationFromAccessToken(String token);
    String getUsernameFromAccessToken(String token);
    String getAccessTokenFromHeader(HttpServletRequest request);
}
