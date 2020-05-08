package homework.tema5;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@ToString
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !(o instanceof Square)) {
            return false;
        }
        Square square = (Square) o;
        return length == square.getLength();
    }

    @Override
    public int hashCode() {
        return Objects.hash(length);
    }
}
