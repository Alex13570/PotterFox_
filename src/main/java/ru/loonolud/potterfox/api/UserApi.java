package ru.loonolud.potterfox.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.loonolud.potterfox.dto.request.AuthRequest;
import ru.loonolud.potterfox.dto.request.RefreshTokenRequest;
import ru.loonolud.potterfox.dto.request.SignUpRequest;
import ru.loonolud.potterfox.dto.response.AuthResponse;

@RequestMapping("/api/auth")
@CrossOrigin(origins = {"${settings.cors_origin}"})
public interface UserApi {

    @PostMapping(path = "/sign-in")
    @ResponseStatus(HttpStatus.OK)
    AuthResponse signIn(@RequestBody AuthRequest authRequestDto);

    @PostMapping(path ="/refresh-token")
    @ResponseStatus(HttpStatus.OK)
    AuthResponse refreshToken(@RequestBody RefreshTokenRequest tokenRequest);

    @PostMapping(path = "/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    AuthResponse signUp(@RequestBody SignUpRequest request);

}
