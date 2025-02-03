package org.example.domain.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "carts")
public class CartModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String userId;

    @OneToOne
    @JoinColumn(name = "customer_id")
    CustomerModel customerModel;

    @OneToMany(mappedBy = "cartModel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<OrderModel> orderModels;
}
