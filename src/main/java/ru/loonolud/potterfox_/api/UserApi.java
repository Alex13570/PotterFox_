package ru.loonolud.potterfox_.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.loonolud.potterfox_.dto.request.AuthRequest;
import ru.loonolud.potterfox_.dto.request.RefreshTokenRequest;
import ru.loonolud.potterfox_.dto.request.SignUpRequest;
import ru.loonolud.potterfox_.dto.response.AuthResponse;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = {"${settings.cors_origin}"})
public interface UserApi {

    @PostMapping(path = "/sign-in")
    AuthResponse signIn(@RequestBody AuthRequest authRequestDto);

    @PostMapping(path ="/refresh-token")
    AuthResponse refreshToken(@RequestBody RefreshTokenRequest tokenRequest);

    @PostMapping(path = "/sign-up")
    AuthResponse signUp(@RequestBody SignUpRequest request);

}
