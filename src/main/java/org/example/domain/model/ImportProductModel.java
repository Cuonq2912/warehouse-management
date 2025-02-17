package org.example.domain.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "import_products")
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
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id", updatable = true)
    UserModel userModel;

    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false, referencedColumnName = "id", updatable = true)
    SupplierModel supplierModel;

    @OneToMany(mappedBy = "importProductModel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<ImportDetailModel> importDetails;
}