package ru.loonolud.potterfox_.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.loonolud.potterfox_.model.RefreshToken;

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
