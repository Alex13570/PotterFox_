package ru.loonolud.potterfox.service;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import ru.loonolud.potterfox.dto.request.AuthRequest;
import ru.loonolud.potterfox.dto.request.RefreshTokenRequest;
import ru.loonolud.potterfox.dto.request.SignUpRequest;
import ru.loonolud.potterfox.dto.response.AuthResponse;
import ru.loonolud.potterfox.dto.response.FileInfoResponse;

public interface MyUserDetailsService {

    AuthResponse signIn(AuthRequest authRequestDto);

    AuthResponse updateAccessTokenWithRefreshToken(RefreshTokenRequest tokenRequest);

    AuthResponse signUp(SignUpRequest request);

    FileInfoResponse saveNewIcon(MultipartFile file);

    ResponseEntity<Resource> getFileContent(String id);

}
