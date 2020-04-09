package homework.Tema5;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Square implements GeometricShapeInterface {

    private double length;

    public Square(double length) {
        this.length = length;
    }

    public BigDecimal getShapePerimeterValue() {
        return new BigDecimal(4 * this.length);
    }

    public BigDecimal getShapeAreaValue() {
        return new BigDecimal(Math.pow(this.length, 2));
    }
}
