package org.example.domain.DTO.Response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerResponse {

    Long id;
    String name;
    String email;
    String address;
    String phoneNumber;
    
}
