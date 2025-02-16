package org.example.domain.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "import")
public class ImportProductModel {
    
    /**
     *
     * @return
     */
    public static ImportProductModel.Builder builder() {
        return new ImportProductModel.Builder();
    }
    
  
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;
    public static class Builder {
//    private String date;
    private String id;
    private ImportProductModel importProductModel;
    
    public Builder(){
        importProductModel = new ImportProductModel();
    }
    
    public Builder id(String id){
        importProductModel.id = id;
        return this;
    }
    public Builder quantity(String quantity){
        importProductModel.quantity = quantity;
        return this;
    }
    
    public Builder name(String name){
        importProductModel.productName = name;
        return this;
               
    }
    
    public Builder price(Double price){
        importProductModel.totalPrice = price;
        return this;
    }
    
//    public Builder date(String date){
//        importDetailModel.importDate = date;
//        return this;
//    }

    public ImportProductModel build(){
        return importProductModel;
    }

    }
    

    @Column(nullable = false)
    String productName;

    @Column(nullable = false)
    String quantity;

    @Column(nullable = false)
    double totalPrice;

    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false)
    SupplierModel supplierModel;

    @ManyToOne
    @JoinColumn(name = "import_detail_id", nullable = false)
    ImportDetailModel importDetailModel;
}
