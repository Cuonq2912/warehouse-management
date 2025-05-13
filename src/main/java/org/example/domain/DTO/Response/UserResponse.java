package org.example.domain.DTO.Response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {

    Long id;
    String username;
    String password;
    String fullName;
    String email;
    String phoneNumber;
    String address;
}
