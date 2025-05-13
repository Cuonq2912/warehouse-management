package org.example.domain.DTO.Request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.constant.ErrorMessage;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequest {

    @NotBlank(message = ErrorMessage.NOT_BLANK_FIELD)
    String name;
    @DecimalMin(value = "0.0", inclusive = false, message = ErrorMessage.Product.INVALID_PRICE_GREATER_THAN_ZERO)
    Double price;
    @DecimalMin(value = "0", message = ErrorMessage.Product.INVALID_REMAINING_QUANTITY_GREATER_THAN_ZERO)
    Long remainingQuantity;
    @DecimalMin(value = "0", message = ErrorMessage.Product.INVALID_SOLD_OUT_QUANTITY_GREATER_THAN_ZERO)
    Long soldQuantity;
}
