package homework.Tema5;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Circle implements GeometricShapeInterface {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public BigDecimal getShapePerimeterValue() {
        return new BigDecimal(2 * Math.PI * this.radius);
    }

    public BigDecimal getShapeAreaValue() {
        return new BigDecimal(Math.PI * Math.pow(this.radius, 2));
    }
}
