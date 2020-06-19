package homework.tema12.entity;

import java.time.LocalDate;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Builder
@Getter
@ToString
public class Order {
    private int orderNumber;
    private LocalDate orderDate;
    private LocalDate requireDate;
    private LocalDate shippedDate;
    private OrderStatus status;
    private String comments;
    private int customerNumber;
}
