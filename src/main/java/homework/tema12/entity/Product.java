package homework.tema12.entity;

import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Product {
    private String productCode;

    private String productName;
    private String productLine;
    private String productScale;
    private String productVendor;
    private String productDescription;
    private int quantityInStock;
    private double buyPrice;
    private double MSRP;
}


