package homework.Tema5;

import java.math.BigDecimal;

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
}
