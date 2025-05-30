package org.example.domain.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Table(name = "users")
public class    UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, unique = true)
    String username;

    @Column(nullable = false)
    String password;

    @Column()
    String fullName;

    @Column(nullable = false, unique = true)
    String email;

    @Column(unique = true)
    String phoneNumber;

    @Column()
    String address;

    @Column()
    @Enumerated(EnumType.STRING)
    Role role;

    @Column()
    @Enumerated(EnumType.STRING)
    Status status;

    @Column(name = "create_at", updatable = false)
    @CreationTimestamp
    LocalDate createdAt;

    @Column(name = "update_at", updatable = false)
    @UpdateTimestamp
    LocalDate updatedAt;

    @OneToMany(mappedBy = "userModel", cascade = CascadeType.ALL)
    List<ImportProductModel> importProductModels = new ArrayList<>();

    @OneToMany(mappedBy = "userModel", cascade = CascadeType.ALL)
    List<ExportProductModel> exportProductModels = new ArrayList<>();

    @OneToMany(mappedBy = "userModel", cascade = CascadeType.ALL)
    List<OrderModel> orderModels = new ArrayList<>();
}