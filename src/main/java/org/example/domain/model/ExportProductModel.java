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
@Table(name = "export")
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
    
//     @Column(nullable = false)
//    @Enumerated(EnumType.STRING)
//    Status status;

    @ManyToOne
    @JoinColumn(name = "export_detail_id", nullable = false)
    ExportDetailModel exportDetailModel;



}
