package homework.Tema1;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.Scanner;

public class HomeworkOne {

    public static void main(String... args) {

        Scanner scanner = new Scanner(System.in);

        //tema 1

        System.out.println("Exercitiul 9 - Write a Java program to remove the duplicate elements of a given array and return the new length of the array.");
        System.out.println("Introduceti numerele din array cu 1 spatiu intre ele: ");
        String numbersArray = scanner.nextLine();
        displayUniqueArray(numbersArray);
        System.out.println("=================================================");
        System.out.println("Exercitiul 1 - Calculate the sum of the first 100 prime numbers.");
        System.out.println("suma = " + getPrimeNumbersSum(100));
        System.out.println("=================================================");
        System.out.println("Exercitiul 2 - Display the smallest number from an array of number read from keyboard (2 versions: with normal for and with foreac");
        System.out.println("Introduceti numerele cu spatiu intre ele:");

        String numbers = scanner.nextLine();
        System.out.println("VERSIUNEA 1 - Cel mai mic nr este  :" + getSmallestNumberFromStringV1(numbers));
        System.out.println("VERSIUNEA 2 - Cel mai mic nr este  :" + getSmallestNumberFromStringV2(numbers));
        System.out.println("=================================================");
        System.out.println("Exercitiul 3 - Display the max digit from a number.");
        System.out.println("introduceti numarul: ");
        int number = scanner.nextInt();
        System.out.println("maxDigit = " + getMaxNumberDigit(number));
        System.out.println("=================================================");
        System.out.println("Exercitiul 4 - Check if a number is palindrom ( e.g palindrom 1221, 34143) ");
        System.out.println("introduceti numarul: ");
        int numberPalindrome = scanner.nextInt();

        if (numberIsPalindrome(numberPalindrome)) {
            System.out.println("Numarul " + numberPalindrome + " este palindrom");
        } else {
            System.out.println("Numarul " + numberPalindrome + " nu este palindrom");
        }
        System.out.println("=================================================");
        System.out.println("Exercitiul 5 - Display all the prime numbers lower than a given number");
        System.out.println("introduceti numarul: ");
        int limitNumber = scanner.nextInt();
        displayPrimeNumbers(limitNumber);
        System.out.println("=================================================");
        System.out.println("Exercitiul 6 - Change the implementation of the calculator from the previous meeting to use only if-else instead of switch.");
        System.out.println("Introduceti numerele: ");
        int operandOne = scanner.nextInt();
        int operandTwo = scanner.nextInt();
        System.out.println("Introduceti operatia: ");
        String operation = scanner.next();
        getOperationResult(operation, operandOne, operandTwo);
        System.out.println("=================================================");
        System.out.println("Exercitiul 7 - Change the implementation of the calculator from the previous meeting to not stop after one calculation. (Hint: put switch inside a while loop)");
        getOperationResultV2();
        System.out.println("=================================================");
        System.out.println("Exercitiul 8 - Calculate and display the factorial of a given number n. (ex: 4! = 1*2*3*4");
        System.out.println("Introduceti numarul factorial: ");
        int factorialNumber = scanner.nextInt();
        displayFactorialValue(factorialNumber);
        System.out.println("=================================================");
        System.out.println("Exercitiul 10 - Write a method that checks if the array is square (i.e. every row has the same length as a itself).");

        int[][] matrix1 = {
                {4, 4, 3},
                {5, 7, 4},
                {7, 8, 9}
        };

        int[][] matrix2 = {
                {4},
                {5, 7, 4},
                {7, 8}
        };

        if (isSquare(matrix1)) {
            System.out.println("Matricea este patrata !");
        } else {
            System.out.println("Matricea nu este patrata !");
        }

        System.out.println("=================================================");
        System.out.println("Exercitiul 11 - Print the number of days specific to each month in year.");
        String monthNumber = scanner.next();


        switch (monthNumber) {
            case "1":
            case "3":
            case "5":
            case "7":
            case "8":
            case "10":
            case "12":
                System.out.println("31");
                break;
            case "2":
                System.out.println("29");
                break;
            case "4":
            case "6":
            case "9":
            case "11":
                System.out.println("30");
                break;

            default:
                System.out.println("Bad month number!!!");
        }
    }

    public static boolean isSquare(int[][] array) {
        int rowNumber = array.length;

        for (int i = 0; i < array.length; i++) {

            if (rowNumber != array[i].length) {
                return false;
            }

        }
        return true;
    }

    private static void displayUniqueArray(String arrayString) {
        String[] arrayNumbers = arrayString.split("  *");
        String[] uniqueArrayValues = new String[arrayNumbers.length];

        boolean isCopy;
        int i = 0;
        int j;
        int k = 0;
        for (; i <= arrayNumbers.length - 1; i++) {
            isCopy = false;
            j = 0;
            for (; j <= arrayNumbers.length - 1; j++) {
                if (i != j && arrayNumbers[i].equals(arrayNumbers[j])) {
                    isCopy = true;
                    if (i < j) {
                        boolean addUniqueNumber = true;
                        for (int l = 0; l < k; l++) {
                            if (uniqueArrayValues[l].equals(arrayNumbers[j])) {
                                addUniqueNumber = false;
                            }
                        }
                        if (addUniqueNumber) {
                            uniqueArrayValues[k] = arrayNumbers[i];
                            k++;
                        }
                    }
                }
            }

            if (!isCopy) {
                uniqueArrayValues[k] = arrayNumbers[i];
                k++;
            }
        }

        String[] uniqueArray = new String[k];
        int index = 0;

        for (String value : uniqueArrayValues) {
            if (value != null) {
                uniqueArray[index] = value;
                index++;
            }
        }

        System.out.println("array" + java.util.Arrays.toString(uniqueArray));
    }

    private static void displayFactorialValue(int number) {
        int factorialNumber = Math.abs(number);


        if (factorialNumber == 0) {
            System.out.println("Nr trebuie sa fie mai mare ca 0!");
        } else {
            double valoareFactoriala = 1;
            for (int i = 1; i <= factorialNumber; i++) {

                valoareFactoriala *= i;

            }

            System.out.println("valoareFactoriala = " + valoareFactoriala);
        }
    }


    private static void getOperationResultV2() {
        Scanner scanner = new Scanner(System.in);

        //default value
        String operation = "+";

        while (!operation.equals("$")) {
            System.out.println("Introduceti numerele pentru calcul: ");
            int operandOne = scanner.nextInt();
            int operandTwo = scanner.nextInt();

            System.out.println("Pentru a opri calculatorul folositi operatia cu semnul $ ");
            System.out.println("Introduceti operatia: ");

            scanner = new Scanner(System.in);
            operation = scanner.next();

            switch (operation) {
                case "+":
                    System.out.println("a+b= " + (operandOne + operandTwo));
                    break;
                case "-":
                    System.out.println("a-b= " + (operandOne - operandTwo));
                    break;

                case "*":
                    System.out.println("a*b= " + operandOne * operandTwo);
                    break;

                case "/":
                    System.out.println("a/b= " + (operandOne / operandTwo));
                    break;

                case "$":
                    System.out.println("Calculator stop!");
                    break;

                default:
                    System.out.println("Bad operation!!!");
            }
        }
    }

    private static void getOperationResult(String operation, int operandOne, int operandTwo) {
        if (operation.equals("+")) {
            System.out.println("a+b= " + (operandOne + operandTwo));
        } else {
            if (operation.equals("*")) {
                System.out.println("a*b= " + operandOne * operandTwo);
                ;
            } else {
                if (operation.equals("-")) {
                    System.out.println("a-b= " + (operandOne - operandTwo));
                } else {
                    if (operation.equals("/")) {
                        System.out.println("a/b= " + (operandOne / operandTwo));
                        ;
                    } else {
                        System.out.println("Bad operation!!!");
                    }
                }
            }
        }
    }

    private static void displayPrimeNumbers(int maxNumber) {
        for (int i = 2; i <= maxNumber; i++) {

            boolean isPrime = true;

            for (int j = 1; j <= maxNumber; j++) {
                if (i % j == 0 && i != j && j != 1) {
                    isPrime = false;
                }
            }

            if (isPrime) {
                System.out.println("i = " + i);
            }
        }
    }

    private static boolean numberIsPalindrome(int number) {
        int numberPalindrome = Math.abs(number);
        int length = String.valueOf(numberPalindrome).length();
        int[] digits = new int[length];

        int i = 0;
        while (numberPalindrome != 0) {
            int digit = numberPalindrome % 10;
            digits[i] = digit;
            numberPalindrome /= 10;
            i++;
        }

        boolean isPalindrome = true;
        int j = 0;
        for (int digitValue : digits) {
            if (digitValue != digits[length - 1 - j]) {
                isPalindrome = false;
            }
            j++;
        }
        return isPalindrome;
    }

    private static int getMaxNumberDigit(int number) {
        number = Math.abs(number);

        int length = String.valueOf(number).length();
        int[] digits = new int[length];
        int maxDigit = 0;
        int i = 0;

        while (number != 0) {

            int digit = number % 10;
            digits[i] = digit;

            if (i > 0 && maxDigit < digits[i]) {
                maxDigit = digits[i];
            }

            if (i == 0) {
                maxDigit = digit;
            }

            number /= 10;
            i++;
        }
        return maxDigit;
    }

    private static int getSmallestNumberFromStringV2(String keyboardNumbers) {
        String[] arrayNumbers = keyboardNumbers.split("  *");

        int smallestNumber = Integer.parseInt(arrayNumbers[0]);

        for (String stringNumber : arrayNumbers) {
            if (smallestNumber > Integer.parseInt(stringNumber)) {
                smallestNumber = Integer.parseInt(stringNumber);
            }
        }

        return smallestNumber;
    }

    private static int getSmallestNumberFromStringV1(String keyboardNumbers) {
        String[] arrayNumbers = keyboardNumbers.split("  *");

        int smallestNumber = Integer.parseInt(arrayNumbers[0]);

        for (int i = 0; i <= arrayNumbers.length - 1; i++) {

            if (smallestNumber > Integer.parseInt(arrayNumbers[i])) {
                smallestNumber = Integer.parseInt(arrayNumbers[i]);
            }
        }

        return smallestNumber;
    }

    private static int getPrimeNumbersSum(int maxNumberLimit) {
        int sumPrimeNumbers = 0;

        for (int i = 2; i <= maxNumberLimit; i++) {

            boolean isPrime = true;

            for (int j = 1; j <= maxNumberLimit; j++) {
                if (i % j == 0 && i != j && j != 1) {
                    isPrime = false;
                }
            }

            if (isPrime) {
                sumPrimeNumbers = sumPrimeNumbers + i;
            }
        }

        return sumPrimeNumbers;
    }
}
