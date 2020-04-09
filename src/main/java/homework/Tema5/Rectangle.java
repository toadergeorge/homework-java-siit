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
public class Rectangle implements GeometricShapeInterface {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public BigDecimal getShapePerimeterValue() {
        return new BigDecimal(2 * (this.length + this.width));
    }

    public BigDecimal getShapeAreaValue() {
        return new BigDecimal(this.length * this.width);
    }
}
