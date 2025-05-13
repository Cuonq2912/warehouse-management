package org.example.domain.DTO.Response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SupplierResponse {

    Long id;
    String name;
    String address;
    String phoneNumber;
    String email;
}
