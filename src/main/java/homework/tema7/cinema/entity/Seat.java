package homework.tema7.cinema.entity;

import lombok.*;

import java.math.BigDecimal;

@Getter
@ToString
@Builder
@Data
@EqualsAndHashCode
public class Seat {
    private String seatNumber;
    private boolean reserved;
    private BigDecimal price;
}
