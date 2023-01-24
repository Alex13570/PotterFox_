package ru.loonolud.potterfox.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {

    private String email;

    private String role;

    private String refreshToken;

    private String accessToken;

    private String firstName;

    private String lastName;

}
