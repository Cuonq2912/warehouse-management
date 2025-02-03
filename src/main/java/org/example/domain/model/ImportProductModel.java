package org.example.domain.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "import")
public class ImportProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String productName;

    @Column(nullable = false)
    Long quantity;

    @Column(nullable = false)
    double totalPrice;

    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false)
    SupplierModel supplierModel;

    @ManyToOne
    @JoinColumn(name = "import_detail_id", nullable = false)
    ImportDetailModel importDetailModel;
}
