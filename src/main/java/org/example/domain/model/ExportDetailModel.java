package org.example.domain.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "export_details")
public class ExportDetailModel {
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
    LocalDateTime exportDate;

    @ManyToOne
    @JoinColumn(name = "export_product_id", nullable = true, referencedColumnName = "id", updatable = false)
    ExportProductModel exportProductModel;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = true, referencedColumnName = "id", updatable = false)
    ProductModel productModel;
}