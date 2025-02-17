package org.example.domain.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "import_details")
public class ImportDetailModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String productName;

    @Column(nullable = false)
    Long quantity;

    @Column(nullable = false)
    double totalPrice;

    @Column(nullable = false)
    LocalDateTime importDate;

    @ManyToOne
    @JoinColumn(name = "import_product_id", nullable = true)
    ImportProductModel importProductModel;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable =true)
    ProductModel productModel;
}
