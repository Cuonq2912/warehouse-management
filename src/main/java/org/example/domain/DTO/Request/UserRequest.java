package org.example.domain.DTO.Request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.constant.ErrorMessage;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequest {

    @NotBlank(message = ErrorMessage.NOT_BLANK_FIELD)
    String username;
    @NotBlank(message = ErrorMessage.NOT_BLANK_FIELD)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{8,}$", message = ErrorMessage.INVALID_FORMAT_PASSWORD)
    String password;
    @NotBlank(message = ErrorMessage.NOT_BLANK_FIELD)
    String fullName;
    @NotNull(message = ErrorMessage.INVALID_SOME_THING_FIELD_IS_REQUIRED)
    @Email(message = ErrorMessage.INVALID_FORMAT_SOME_THING_FIELD)
    String email;
    @NotBlank(message = ErrorMessage.NOT_BLANK_FIELD)
    @Pattern(regexp = "^\\d{9,11}$", message = ErrorMessage.INVALID_SOME_THING_FIELD)
    String phoneNumber;
    @NotBlank(message = ErrorMessage.NOT_BLANK_FIELD)
    String address;
}
