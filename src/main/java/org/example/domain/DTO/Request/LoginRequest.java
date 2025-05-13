package org.example.domain.DTO.Request;

import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;
import jakarta.validation.constraints.NotBlank;
import org.example.constant.ErrorMessage;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginRequest {

    @NotBlank(message = ErrorMessage.NOT_BLANK_FIELD)
    String username;
    @NotBlank(message = ErrorMessage.NOT_BLANK_FIELD)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=\\\\S+$).{8,}$", message = ErrorMessage.INVALID_FORMAT_PASSWORD)
    String password;

}
