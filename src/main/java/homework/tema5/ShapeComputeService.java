package homework.tema5;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShapeComputeService {

    private static List<GeometricShapeInterface> shapesList = new ArrayList<>();
    private static boolean beginMenuListing = false;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Alegeti actiunea dorita:");
        System.out.println("Keyboard 1: Calculate shapes perimeter sum \n Keyboard 2: Calculate shapes area sum \n Keyboard 3: Exit");
        int optionOperation = scanner.nextInt();
        int optionShape = 0;

        while (optionOperation > 0 && optionOperation < 3) {

            if (beginMenuListing == true) {
                System.out.println("Alegeti actiunea dorita:");
                System.out.println("Keyboard 1: Calculate shapes perimeter sum \n Keyboard 2: Calculate shapes area sum \n Keyboard 3: Exit");
                optionOperation = scanner.nextInt();
            }

            switch (optionOperation) {
                case 1:

                    System.out.println("Select shape type for the perimeter sum:");
                    System.out.println("Keyboard 1: Circle \n Keyboard 2: Triangle \n Keyboard 3: Rectangle \n Keyboard 4: Square \n Keyboard 5: Calculate \n Keyboard 6: Cancel");
                    optionShape = scanner.nextInt();
                    optionOperation = getPerimeterSumOption(scanner, optionShape);

                    break;
                case 2:

                    System.out.println("Select shape type for the area sum:");
                    System.out.println("Keyboard 1: Circle \n Keyboard 2: Triangle \n Keyboard 3: Rectangle \n Keyboard 4: Square \n  Keyboard 5: Calculate \n Keyboard 6: Cancel");
                    optionShape = scanner.nextInt();
                    optionOperation = getAreaSumOption(scanner, optionShape);

                    break;
                case 3:
                    System.out.println("Exit");
                    break;
            }
        }
    }

    private static int getAreaSumOption(Scanner scanner, int optionShape) {
        int optionOperation = 0;
        String inputString = "";
        boolean addAction;
        BigDecimal totalSum = new BigDecimal(0);
        String width = "";
        String length = "";

        while (optionShape > 0 && optionShape < 7) {

            switch (optionShape) {
                case 1:

                    System.out.println("Input circle radius:");
                    inputString = scanner.next();
                    Double circleRadius = Double.parseDouble(inputString);

                    Circle circle = new Circle(circleRadius);

                    addAction = addShapeToOperation(circle);
                    if (!addAction) {
                        System.out.println("You can not add a shape with same dimensions twice! Please add another shape!");
                        optionShape = 0;
                        optionOperation = 1;
                        beginMenuListing = false;
                        break;
                    }

                    System.out.println("Select next option:");
                    System.out.println("Keyboard 1: Add another shape \n Keyboard 2: Calculate sum \n Keyboard 3: Cancel perimeter sum action");
                    optionOperation = scanner.nextInt();

                    if (optionOperation == 1) {
                        optionShape = 0;
                        optionOperation = 2;
                        beginMenuListing = false;

                    } else if (optionOperation == 2) {
                        optionShape = 0;
                        optionOperation = 2;
                        beginMenuListing = true;

                        totalSum = getAreaSum();
                        System.out.println("Total shape of perimeters sum is :" + totalSum);
                        System.out.println("===============END OF OPERATION===================\n");

                        shapesList.clear();
                    } else {
                        optionShape = 7;
                        beginMenuListing = true;
                        shapesList.clear();
                    }

                    break;

                case 2:

                    System.out.println("Input triangle side length:");
                    inputString = scanner.next();
                    Double triangleSideLength = Double.parseDouble(inputString);

                    Triangle triangle = new Triangle(triangleSideLength);

                    addAction = addShapeToOperation(triangle);
                    if (!addAction) {
                        System.out.println("You can not add a shape with same dimensions twice! Please add another shape!");
                        optionShape = 0;
                        optionOperation = 2;
                        beginMenuListing = false;
                        break;
                    }

                    System.out.println("Select next option:");
                    System.out.println("Keyboard 1: Add another shape \n Keyboard 2: Calculate sum \n Keyboard 3: Cancel perimeter sum action");
                    optionOperation = scanner.nextInt();

                    if (optionOperation == 1) {
                        optionShape = 0;
                        optionOperation = 2;
                        beginMenuListing = false;

                    } else if (optionOperation == 2) {
                        optionShape = 0;
                        optionOperation = 2;
                        beginMenuListing = true;

                        totalSum = getAreaSum();
                        System.out.println("Total shape of perimeters sum is :" + totalSum);
                        System.out.println("===============END OF OPERATION===================\n");

                        shapesList.clear();
                    } else {
                        optionShape = 7;
                        beginMenuListing = true;
                        shapesList.clear();
                    }

                    break;
                case 3:

                    System.out.println("Input rectangle length:");
                    length = scanner.next();

                    System.out.println("Input rectangle width:");
                    width = scanner.next();

                    Double rectangleLength = Double.parseDouble(length);
                    Double rectangleWidth = Double.parseDouble(width);

                    Rectangle rectangle = new Rectangle(rectangleLength, rectangleWidth);

                    addAction = addShapeToOperation(rectangle);
                    if (!addAction) {
                        System.out.println("You can not add a shape with same dimensions twice! Please add another shape!");
                        optionShape = 0;
                        optionOperation = 2;
                        beginMenuListing = false;
                        break;
                    }

                    System.out.println("Select next option:");
                    System.out.println("Keyboard 1: Add another shape \n Keyboard 2: Calculate sum \n Keyboard 3: Cancel perimeter sum action");
                    optionOperation = scanner.nextInt();

                    if (optionOperation == 1) {
                        optionShape = 0;
                        optionOperation = 2;
                        beginMenuListing = false;

                    } else if (optionOperation == 2) {
                        optionShape = 0;
                        optionOperation = 2;
                        beginMenuListing = true;

                        totalSum = getPerimeterSum();
                        System.out.println("Total shape of perimeters sum is :" + totalSum);
                        System.out.println("===============END OF OPERATION===================\n");

                        shapesList.clear();
                    } else {
                        optionShape = 7;
                        beginMenuListing = true;
                        shapesList.clear();
                    }

                    break;

                case 4:

                    System.out.println("Input square length:");
                    length = scanner.next();

                    Double squareLength = Double.parseDouble(length);

                    Square square = new Square(squareLength);

                    addAction = addShapeToOperation(square);
                    if (!addAction) {
                        System.out.println("You can not add a shape with same dimensions twice! Please add another shape!");
                        optionShape = 0;
                        optionOperation = 2;
                        beginMenuListing = false;
                        break;
                    }

                    System.out.println("Select next option:");
                    System.out.println("Keyboard 1: Add another shape \n Keyboard 2: Calculate sum \n Keyboard 3: Cancel perimeter sum action");
                    optionOperation = scanner.nextInt();

                    if (optionOperation == 1) {
                        optionShape = 0;
                        optionOperation = 2;
                        beginMenuListing = false;

                    } else if (optionOperation == 2) {
                        optionShape = 0;
                        optionOperation = 2;
                        beginMenuListing = true;

                        totalSum = getAreaSum();
                        System.out.println("Total shape of perimeters sum is :" + totalSum);
                        System.out.println("===============END OF OPERATION===================\n");

                        shapesList.clear();
                    } else {
                        optionShape = 7;
                        beginMenuListing = true;
                        shapesList.clear();
                    }

                    break;

                case 5:
                    optionShape = 0;
                    optionOperation = 2;
                    beginMenuListing = true;

                    totalSum = getAreaSum();
                    System.out.println("Total shape of perimeters sum is :" + totalSum);
                    System.out.println("===============END OF OPERATION===================\n");

                    shapesList.clear();

                    break;

                case 6:
                    optionShape = 0;
                    break;
            }
        }

        return optionOperation;
    }

    private static int getPerimeterSumOption(Scanner scanner, int optionShape) {
        int optionOperation = 0;
        String inputString = "";
        boolean addAction;
        BigDecimal totalSum = new BigDecimal(0);
        String width = "";
        String length = "";

        while (optionShape > 0 && optionShape < 7) {

            switch (optionShape) {
                case 1:
                    System.out.println("Input circle radius:");
                    inputString = scanner.next();
                    Double circleRadius = Double.parseDouble(inputString);
                    Circle circle = new Circle(circleRadius);

                    addAction = addShapeToOperation(circle);
                    if (!addAction) {
                        System.out.println("You can not add a shape with same dimensions twice! Please add another shape!");
                        optionShape = 0;
                        optionOperation = 1;
                        beginMenuListing = false;
                        break;
                    }

                    System.out.println("Select next option:");
                    System.out.println("Keyboard 1: Add another shape \n Keyboard 2: Calculate sum \n Keyboard 3: Cancel perimeter sum action");
                    optionOperation = scanner.nextInt();

                    if (optionOperation == 1) {
                        optionShape = 0;
                        optionOperation = 1;
                        beginMenuListing = false;

                    } else if (optionOperation == 2) {
                        optionShape = 0;
                        optionOperation = 1;
                        beginMenuListing = true;

                        totalSum = getPerimeterSum();
                        System.out.println("Total shape of perimeters sum is :" + totalSum);
                        System.out.println("===============END OF OPERATION===================\n");

                        shapesList.clear();
                    } else {
                        optionShape = 7;
                        beginMenuListing = true;
                        shapesList.clear();
                    }
                    break;

                case 2:

                    System.out.println("Input triangle side length:");
                    inputString = scanner.next();
                    Double triangleSideLength = Double.parseDouble(inputString);

                    Triangle triangle = new Triangle(triangleSideLength);

                    addAction = addShapeToOperation(triangle);
                    if (!addAction) {
                        System.out.println("You can not add a shape with same dimensions twice! Please add another shape!");
                        optionShape = 0;
                        optionOperation = 1;
                        beginMenuListing = false;
                        break;
                    }

                    System.out.println("Select next option:");
                    System.out.println("Keyboard 1: Add another shape \n Keyboard 2: Calculate sum \n Keyboard 3: Cancel perimeter sum action");
                    optionOperation = scanner.nextInt();

                    if (optionOperation == 1) {
                        optionShape = 0;
                        optionOperation = 1;
                        beginMenuListing = false;

                    } else if (optionOperation == 2) {
                        optionShape = 0;
                        optionOperation = 1;
                        beginMenuListing = true;

                        totalSum = getPerimeterSum();
                        System.out.println("Total shape of perimeters sum is :" + totalSum);
                        System.out.println("===============END OF OPERATION===================\n");

                        shapesList.clear();
                    } else {
                        optionShape = 7;
                        beginMenuListing = true;
                        shapesList.clear();
                    }
                    break;
                case 3:

                    System.out.println("Input rectangle length:");
                    length = scanner.next();

                    System.out.println("Input rectangle width:");
                    width = scanner.next();

                    Double rectangleLength = Double.parseDouble(length);
                    Double rectangleWidth = Double.parseDouble(width);

                    Rectangle rectangle = new Rectangle(rectangleLength, rectangleWidth);

                    addAction = addShapeToOperation(rectangle);
                    if (!addAction) {
                        System.out.println("You can not add a shape with same dimensions twice! Please add another shape!");
                        optionShape = 0;
                        optionOperation = 1;
                        beginMenuListing = false;
                        break;
                    }

                    System.out.println("Select next option:");
                    System.out.println("Keyboard 1: Add another shape \n Keyboard 2: Calculate sum \n Keyboard 3: Cancel perimeter sum action");
                    optionOperation = scanner.nextInt();

                    if (optionOperation == 1) {
                        optionShape = 0;
                        optionOperation = 1;
                        beginMenuListing = false;

                    } else if (optionOperation == 2) {
                        optionShape = 0;
                        optionOperation = 1;
                        beginMenuListing = true;

                        totalSum = getPerimeterSum();
                        System.out.println("Total shape of perimeters sum is :" + totalSum);
                        System.out.println("===============END OF OPERATION===================\n");

                        shapesList.clear();
                    } else {
                        optionShape = 7;
                        beginMenuListing = true;
                        shapesList.clear();
                    }

                    break;

                case 4:

                    System.out.println("Input square length:");
                    length = scanner.next();

                    Double squareLength = Double.parseDouble(length);

                    Square square = new Square(squareLength);

                    addAction = addShapeToOperation(square);
                    if (!addAction) {
                        System.out.println("You can not add a shape with same dimensions twice! Please add another shape!");
                        optionShape = 0;
                        optionOperation = 1;
                        beginMenuListing = false;
                        break;
                    }

                    System.out.println("Select next option:");
                    System.out.println("Keyboard 1: Add another shape \n Keyboard 2: Calculate sum \n Keyboard 3: Cancel perimeter sum action");
                    optionOperation = scanner.nextInt();

                    if (optionOperation == 1) {
                        optionShape = 0;
                        optionOperation = 1;
                        beginMenuListing = false;

                    } else if (optionOperation == 2) {
                        optionShape = 0;
                        optionOperation = 1;
                        beginMenuListing = true;

                        totalSum = getPerimeterSum();
                        System.out.println("Total shape of perimeters sum is :" + totalSum);
                        System.out.println("===============END OF OPERATION===================\n");

                        shapesList.clear();
                    } else {
                        optionShape = 7;
                        beginMenuListing = true;
                        shapesList.clear();
                    }

                    break;

                case 5:

                    optionShape = 0;
                    optionOperation = 1;
                    beginMenuListing = true;

                    totalSum = getPerimeterSum();
                    System.out.println("Total shape of perimeters sum is :" + totalSum);
                    System.out.println("===============END OF OPERATION===================\n");

                    shapesList.clear();

                    break;

                case 6:
                    optionShape = 0;
                    break;
            }
        }

        return optionOperation;
    }

    public static boolean addShapeToOperation(GeometricShapeInterface shape) {

        if (shapesList == null) {
            shapesList.add(shape);
            return true;
        } else if (shapesList != null && !shapesList.contains(shape)) {
            shapesList.add(shape);
            return true;
        }

        return false;
    }

    public static BigDecimal getAreaSum() {
        BigDecimal totalSum = new BigDecimal(0);

        for (GeometricShapeInterface shape : shapesList) {
            totalSum = totalSum.add(shape.getShapeAreaValue());
        }

        return totalSum;
    }

    public static BigDecimal getPerimeterSum() {
        BigDecimal totalSum = new BigDecimal(0);

        for (GeometricShapeInterface shape : shapesList) {
            totalSum = totalSum.add(shape.getShapePerimeterValue());
        }

        return totalSum;
    }
}
