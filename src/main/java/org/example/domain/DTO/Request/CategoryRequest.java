package org.example.domain.DTO.Request;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;
import org.example.constant.ErrorMessage;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryRequest {

    @NotBlank(message = ErrorMessage.NOT_BLANK_FIELD)
    String name;
}
