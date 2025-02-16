package org.example.domain.model;
import org.example.domain.model.ImportDetailModel;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "import_details")
public class ImportDetailModel {

    public static ImportDetailModel.Builder builder() {
        return new ImportDetailModel.Builder();
    }
    
    
//
//    public static void addRow(Object[] object) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

//    public static Object builder() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   String id;
public static class Builder {
    private String date;
    private String id;
    private ImportDetailModel importDetailModel;
    
    public Builder(){
        importDetailModel = new ImportDetailModel();
    }
    
    public Builder id(String id){
        importDetailModel.id = id;
        return this;
    }
    public Builder quantity(String quantity){
        importDetailModel.quantity = quantity;
        return this;
    }
    
    public Builder name(String name){
        importDetailModel.productName = name;
        return this;
               
    }
    
    public Builder price(Double price){
        importDetailModel.totalPrice = price;
        return this;
    }
    
    public Builder date(String date){
        importDetailModel.importDate = date;
        return this;
    }

    public ImportDetailModel build(){
        return importDetailModel;
    }

    }


    @Column(nullable = false)
    String productName;

    @Column(nullable = false)
    String quantity;

    @Column(nullable = false)
    double totalPrice;

    @Column(nullable = false)
    String importDate;
    
      @ManyToOne
    @JoinColumn(name = "import_product_id", nullable = false)
    ImportProductModel importProductModel;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    ProductModel productModel;
}
