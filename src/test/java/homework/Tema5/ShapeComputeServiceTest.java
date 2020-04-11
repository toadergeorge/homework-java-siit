package homework.Tema5;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ShapeComputeServiceTest {

    private ShapeComputeService sut;

    @Before
    public void setup() {
        this.sut = new ShapeComputeService();
    }

    @Test
    public void given_one_shape__circle_input_when_compute_area_sum_then_result_is_returned() {
        //Given
        Double input = 2D;

        //When
        Circle circle = new Circle(input);
        ShapeComputeService.addShapeToOperation(circle);
        BigDecimal returnedAreaSum = ShapeComputeService.getAreaSum();

        //Then
        BigDecimal expectedResult = new BigDecimal("12.57");
        assertThat(returnedAreaSum.setScale(2, BigDecimal.ROUND_HALF_UP)).isEqualTo(expectedResult);
    }

    @Test
    public void given_one_shape_triangle_input_when_compute_area_sum_then_result_is_returned() {
        //Given
        Double input = 2D;

        //When
        Triangle triangle = new Triangle(input);
        ShapeComputeService.addShapeToOperation(triangle);
        BigDecimal returnedAreaSum = ShapeComputeService.getAreaSum();

        //Then
        BigDecimal expectedResult = new BigDecimal("1.73");
        assertThat(returnedAreaSum.setScale(2, BigDecimal.ROUND_HALF_UP)).isEqualTo(expectedResult);
    }

    @Test
    public void given_one_shape_rectangle_input_when_compute_area_sum_then_result_is_returned() {
        //Given
        Double length = 2D;
        Double width = 3D;

        //When
        Rectangle rectangle = new Rectangle(length, width);
        ShapeComputeService.addShapeToOperation(rectangle);
        BigDecimal returnedAreaSum = ShapeComputeService.getAreaSum();

        //Then
        BigDecimal expectedResult = new BigDecimal("6.00");
        assertThat(returnedAreaSum.setScale(2, BigDecimal.ROUND_HALF_UP)).isEqualTo(expectedResult);
    }

    @Test
    public void given_one_shape_square_input_when_compute_area_sum_then_result_is_returned() {
        //Given
        Double input = 2D;

        //When
        Square square = new Square(input);
        ShapeComputeService.addShapeToOperation(square);
        BigDecimal returnedAreaSum = ShapeComputeService.getAreaSum();

        //Then
        BigDecimal expectedResult = new BigDecimal("4.00");
        assertThat(returnedAreaSum.setScale(2, BigDecimal.ROUND_HALF_UP)).isEqualTo(expectedResult);
    }

    @Test
    public void given_all_shapes_input_when_compute_area_sum_then_result_is_returned() {
        //Given
        Double input = 2D;
        Double width = 3D;

        //When
        Square square = new Square(input);
        ShapeComputeService.addShapeToOperation(square);

        Circle circle = new Circle(input);
        ShapeComputeService.addShapeToOperation(circle);

        Triangle triangle = new Triangle(input);
        ShapeComputeService.addShapeToOperation(triangle);

        Rectangle rectangle = new Rectangle(input, width);
        ShapeComputeService.addShapeToOperation(rectangle);


        BigDecimal returnedAreaSum = ShapeComputeService.getAreaSum();

        //Then
        BigDecimal expectedResult = new BigDecimal("24.30");
        assertThat(returnedAreaSum.setScale(2, BigDecimal.ROUND_HALF_UP)).isEqualTo(expectedResult);
    }

    @Test
    public void given_all_shapes_input_when_compute_perimeter_sum_then_result_is_returned() {
        //Given
        Double input = 2D;
        Double width = 3D;

        //When
        Square square = new Square(input);
        ShapeComputeService.addShapeToOperation(square);

        Circle circle = new Circle(input);
        ShapeComputeService.addShapeToOperation(circle);

        Triangle triangle = new Triangle(input);
        ShapeComputeService.addShapeToOperation(triangle);

        Rectangle rectangle = new Rectangle(input, width);
        ShapeComputeService.addShapeToOperation(rectangle);

        BigDecimal returnedAreaSum = ShapeComputeService.getPerimeterSum();

        //Then
        BigDecimal expectedResult = new BigDecimal("36.57");
        assertThat(returnedAreaSum.setScale(2, BigDecimal.ROUND_HALF_UP)).isEqualTo(expectedResult);
    }

    @Test
    public void given_one_shape__circle_input_when_compute_perimeter_sum_then_result_is_returned() {
        //Given
        Double input = 3D;

        //When
        Circle circle = new Circle(input);
        ShapeComputeService.addShapeToOperation(circle);
        BigDecimal returnedAreaSum = ShapeComputeService.getAreaSum();

        //Then
        BigDecimal expectedResult = new BigDecimal("28.27");
        assertThat(returnedAreaSum.setScale(2, BigDecimal.ROUND_HALF_UP)).isEqualTo(expectedResult);
    }

    @Test
    public void given_one_shape_triangle_input_when_compute_perimeter_sum_then_result_is_returned() {
        //Given
        Double input = 2D;

        //When
        Triangle triangle = new Triangle(input);
        ShapeComputeService.addShapeToOperation(triangle);
        BigDecimal returnedAreaSum = ShapeComputeService.getPerimeterSum();

        //Then
        BigDecimal expectedResult = new BigDecimal("6.00");
        assertThat(returnedAreaSum.setScale(2, BigDecimal.ROUND_HALF_UP)).isEqualTo(expectedResult);
    }

    @Test
    public void given_one_shape_rectangle_input_when_compute_perimeter_sum_then_result_is_returned() {
        //Given
        Double length = 2D;
        Double width = 3D;

        //When
        Rectangle rectangle = new Rectangle(length, width);
        ShapeComputeService.addShapeToOperation(rectangle);
        BigDecimal returnedAreaSum = ShapeComputeService.getPerimeterSum();

        //Then
        BigDecimal expectedResult = new BigDecimal("10.00");
        assertThat(returnedAreaSum.setScale(2, BigDecimal.ROUND_HALF_UP)).isEqualTo(expectedResult);
    }

    @Test
    public void given_one_shape_square_input_when_compute_perimeter_sum_then_result_is_returned() {
        //Given
        Double input = 2D;

        //When
        Square square = new Square(input);
        ShapeComputeService.addShapeToOperation(square);
        BigDecimal returnedAreaSum = ShapeComputeService.getPerimeterSum();

        //Then
        BigDecimal expectedResult = new BigDecimal("8.00");
        assertThat(returnedAreaSum.setScale(2, BigDecimal.ROUND_HALF_UP)).isEqualTo(expectedResult);
    }
}
