package homework.Tema5;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@ToString
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !(o instanceof Rectangle)) {
            return false;
        }
        Rectangle rectangle = (Rectangle) o;
        return length == rectangle.getLength() && width == rectangle.getWidth();
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, width);
    }
}
