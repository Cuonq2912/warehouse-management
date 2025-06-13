package org.example.domain.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


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
    Long quantity;

    @ManyToOne
    @JoinColumn
    ExportProductModel exportProductModel;

    @ManyToOne
    @JoinColumn
    ProductModel productModel;
}