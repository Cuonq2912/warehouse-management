//package org.example.domain.model;
//
//import jakarta.persistence.*;
//import lombok.*;
//import lombok.experimental.FieldDefaults;
//
//import java.util.List;
//
//@Entity
//@Getter
//@Setter
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE)
//@Table(name = "export_products")
//public class ExportProductModel {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    Long id;
//
//    @Column(nullable = false)
//    String productName;
//
//    @Column(nullable = false)
//    Long quantity;
//
//    @Column(nullable = false)
//    double totalPrice;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id", updatable = true)
//    UserModel userModel;
//
//    @ManyToOne
//    @JoinColumn(name = "customer_id", nullable = false, referencedColumnName = "id" ,updatable = true)
//    CustomerModel customerModel;
//
//    @OneToMany(mappedBy = "exportProductModel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    List<ExportDetailModel> exportDetailModel;
//
//}

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
@Table(name = "export_products")
public class ExportProductModel {
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
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id", updatable = false)
    UserModel userModel;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false, referencedColumnName = "id", updatable = false)
    CustomerModel customerModel;

    @OneToMany(mappedBy = "exportProductModel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<ExportDetailModel> exportDetailModel;

}