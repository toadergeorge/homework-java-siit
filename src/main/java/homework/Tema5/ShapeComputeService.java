package homework.Tema5;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShapeComputeService {

    private static List<GeometricShapeInterface> shapesList =  new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Alegeti actiunea dorita:");
        System.out.println("Keyboard 1: Calculate shapes perimeter sum \n Keyboard 2: Calculate shapes area sum \n Keyboard 3: Exit");
        int optionOperation = scanner.nextInt();
        int optionShape = 0;
        String inputString = "";

        boolean begin = false;

        while (optionOperation > 0 && optionOperation < 3) {
            int optionGeometricShape = 0;

            if (begin == true) {
                System.out.println("Alegeti actiunea dorita:");
                System.out.println("Keyboard 1: Calculate shapes perimeter sum \n Keyboard 2: Calculate shapes area sum \n Keyboard 3: Exit");
                optionOperation = scanner.nextInt();
            }


            switch (optionOperation) {
                case 1:

                    System.out.println("Select shape type for the perimeter sum:");
                    System.out.println("Keyboard 1: Circle \n Keyboard 2: Triangle \n Keyboard 3: Rectangle \n Keyboard 4: Square \n Keyboard 5: Calculate \n Keyboard 6: Cancel");
                    optionShape = scanner.nextInt();


                    while (optionShape > 0 && optionShape < 7) {

                        switch (optionShape) {
                            case 1:
                                System.out.println("Input circle radius:");
                                inputString = scanner.next();
                                Double circleRadius = Double.parseDouble(inputString);

                                Circle circle = new Circle(circleRadius);

                                if (shapesList == null) {
                                    shapesList.add(circle);
                                } else if (shapesList != null && !shapesList.contains(circle)) {
                                    shapesList.add(circle);
                                } else {
                                    System.out.println("You can not add a shape with same dimensions twice! Please add another shape!");
                                    optionShape = 0;
                                    optionOperation = 1;
                                    begin = true;
                                    break;
                                }

                                System.out.println("Select next option:");
                                System.out.println("Keyboard 1: Add another shape \n Keyboard 2: Calculate sum \n Keyboard 3: Cancel perimeter sum action");
                                optionOperation = scanner.nextInt();

                                if (optionOperation == 1) {
                                    optionShape = 0;
                                    optionOperation = 1;
                                    begin = false;

                                } else if (optionOperation == 2) {
                                    optionShape = 0;
                                    optionOperation = 1;
                                    begin = true;
                                    BigDecimal totalSum = new BigDecimal(0);

                                    for (GeometricShapeInterface shape : shapesList) {
                                        totalSum = totalSum.add(shape.getShapePerimeterValue());
                                    }

                                    System.out.println("Total shape of perimeters sum is :" + totalSum);

                                    shapesList.clear();
                                } else {
                                    optionShape = 7;
                                    begin = true;
                                    shapesList.clear();
                                }
                                break;

                            case 2:

                                System.out.println("Input traingle side lenght:");
                                inputString = scanner.next();
                                Double triangleSideLength = Double.parseDouble(inputString);

                                Triangle triangle = new Triangle(triangleSideLength);

                                if (shapesList == null) {
                                    shapesList.add(triangle);
                                } else if (shapesList != null && !shapesList.contains(triangle)) {
                                    shapesList.add(triangle);
                                } else {
                                    System.out.println("You can not add a shape with same dimensions twice! Please add another shape!");
                                    optionShape = 0;
                                    optionOperation = 1;
                                    begin = true;
                                    break;
                                }

                                System.out.println("Select next option:");
                                System.out.println("Keyboard 1: Add another shape \n Keyboard 2: Calculate sum \n Keyboard 3: Cancel perimeter sum action");
                                optionOperation = scanner.nextInt();

                                if (optionOperation == 1) {
                                    optionShape = 0;
                                    optionOperation = 1;
                                    begin = false;

                                } else if (optionOperation == 2) {
                                    optionShape = 0;
                                    optionOperation = 1;
                                    begin = true;
                                    BigDecimal totalSum = new BigDecimal(0);

                                    for (GeometricShapeInterface shape : shapesList) {
                                        totalSum = totalSum.add(shape.getShapePerimeterValue());
                                    }

                                    System.out.println("Total shape of perimeters sum is :" + totalSum);

                                    shapesList.clear();
                                } else {
                                    optionShape = 7;
                                    begin = true;
                                    shapesList.clear();
                                }
                                break;
                            case 3:

                                break;

                            case 4:

                                break;

                            case 5:

                                break;

                            case 6:
                                optionShape = 0;
                                break;
                        }
                    }


                    break;
                case 2:

                    System.out.println("Select shape type for the area sum:");
                    System.out.println("Keyboard 1: Circle \n Keyboard 2: Triangle \n Keyboard 3: Rectangle \n Keyboard 4: Square \n  Keyboard 5: Calculate \n Keyboard 6: Cancel");
                    optionGeometricShape = scanner.nextInt();


                    while (optionGeometricShape > 0 && optionGeometricShape < 7) {

                        switch (optionShape) {
                            case 1:

                                break;

                            case 2:

                                break;
                            case 3:

                                break;

                            case 4:

                                break;

                            case 5:

                                break;

                            case 6:

                                break;
                        }
                    }


                    break;
                case 3:
                    System.out.println("Exit");
                    break;
            }
        }


    }

//1
}
