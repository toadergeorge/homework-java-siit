package homework.Tema5;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@ToString
public class Triangle implements GeometricShapeInterface {

    private double sideLength;

    public Triangle(double sideLength) {
        this.sideLength = sideLength;
    }

    public BigDecimal getShapePerimeterValue() {
        return new BigDecimal(3 * this.sideLength);
    }

    public BigDecimal getShapeAreaValue() {
        return new BigDecimal((Math.sqrt(3) / 4) * Math.pow(this.sideLength, 2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !(o instanceof Triangle)) {
            return false;
        }
        Triangle triangle = (Triangle) o;
        return sideLength == triangle.getSideLength();
    }

    @Override
    public int hashCode() {
        return Objects.hash(sideLength);
    }
}
