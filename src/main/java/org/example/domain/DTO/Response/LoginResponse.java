package org.example.domain.DTO.Response;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.domain.model.UserModel;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginResponse {

    String username;
    String role;
    UserModel user;

    public LoginResponse(String username, String role) {
        this.username = username;
        this.role = role;
    }

}