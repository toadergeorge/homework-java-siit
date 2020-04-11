package homework.Tema5;

import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@ToString
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !(o instanceof Circle)) {
            return false;
        }
        Circle circle = (Circle) o;
        return radius == circle.getRadius();
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }
}
