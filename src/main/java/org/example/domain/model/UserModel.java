package org.example.domain.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;


@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Table(name = "users")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, unique = true)
    String username;

    @Column(nullable = false)
    String password;

    @Column(nullable = false)
    String fullname;

    @Column(nullable = false, unique = true)
    String email;

    @Column(nullable = false)
    String phoneNumber;

    @Column(nullable = false)
    String address;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    Role role;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    Status status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
        updatedAt = new Date();
    }

    @OneToMany(mappedBy = "userModel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<ImportProductModel> importProductModels;

    @OneToMany(mappedBy = "userModel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<ExportProductModel> exportProductModels;
}