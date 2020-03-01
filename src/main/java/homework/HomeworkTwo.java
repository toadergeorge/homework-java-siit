package homework;

import java.util.Arrays;

public class HomeworkTwo {
    public static void main(String[] args) {
        System.out.println("Exercitiul 1: Write a Java method to print the first 25 terms of the Fibonacci series (without recursion)");
        displayFibonacciNumbers(25);
        System.out.println("=================================================");
        System.out.println("Exercitiul 2: Write a Java method to find the duplicate characters in a string. (Hint use str.toCharArray() to split the string into an array of characters)");
        String duplicateString = "kaaassssbbbkjllllhppppppj";
        getStringDuplicates(duplicateString);
        System.out.println("=================================================");

        System.out.println("Exercitiul 3:  Write a Java method to do Matrix multiplication (for simplicity, the input is known as a 3x3 matrix)");
        int[][] firstMatrix = {
                {2, 2, 2},
                {1, 3, 2},
                {3, 1, 2}
        };

        int[][] secondMatrix = {
                {2, 1, 2},
                {3, 1, 3},
                {5, 2, 3}
        };
        calculateMatrixSum(firstMatrix, secondMatrix);
        System.out.println("=================================================");
        System.out.println("Exercitiul 4:  Write a Java method to find all pairs of elements in an array whose sum is equal to a given number)");
        int[] numbersArray = {1, 2, 3, 4, 6, 3, 5, 4, 2, 8, 1, 7};
        int sumNumber = 9;
        getPairNumbersBySum(numbersArray, sumNumber);
        System.out.println("=================================================");
    }

    /**
     * @param numbers
     * @param sumNumber
     */
    private static void getPairNumbersBySum(int[] numbers, int sumNumber) {

        Arrays.sort(numbers);
        int arrayLength = numbers.length;
        int pairSum = 0;
        String pairs = "";
        for (int i = 0; i <= (arrayLength - 1); i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            for (int k = 0; k <= (arrayLength - 1); k++) {
                if (i != k) {
                    pairSum = numbers[i] + numbers[k];
                    if (pairSum == sumNumber && i < k) {
                        pairs += "[" + numbers[i] + "," + numbers[k] + "]";
                    }
                }
            }
        }
        System.out.println("pairs for sum " + sumNumber + " from array " + java.util.Arrays.toString(numbers) + " are = " + pairs);
    }

    /**
     * @param matrix1
     * @param matrix2
     */
    private static void calculateMatrixSum(int[][] matrix1, int[][] matrix2) {

        int matrix1Size = matrix1.length;
        int matrix2Size = matrix2.length;

        int[][] matrixSum = new int[matrix1Size][matrix2Size];
        int sum = 0;

        for (int lines = 0; lines <= (matrix1Size - 1); lines++) {
            for (int row = 0; row <= (matrix1Size - 1); row++) {


                for (int j = 0; j <= (matrix2Size - 1); j++) {
                    sum += (matrix1[lines][j] * matrix2[j][row]);
                }
                matrixSum[lines][row] = sum;
                sum = 0;
            }
        }

        for (int[] linesArr : matrixSum) {
            System.out.println("array" + java.util.Arrays.toString(linesArr));
        }
    }

    /**
     * @param stringText
     */
    public static void getStringDuplicates(String stringText) {
        char[] stringArray = stringText.toCharArray();

        int arrayLength = stringArray.length;
        String duplicateString = "";
        char duplicateElement = '0';

        Arrays.sort(stringArray);
        for (int i = 0; i <= (arrayLength - 1); i++) {
            if (i == 0) {
                continue;
            }

            if (stringArray[i] == stringArray[i - 1] && !(duplicateElement == stringArray[i])) {

                if ((duplicateElement == '0')) {
                    duplicateElement = stringArray[i];
                }

                duplicateElement = stringArray[i];

                if (i == arrayLength - 1) {
                    duplicateString += stringArray[i];
                } else {
                    duplicateString += stringArray[i] + " ";
                }
            }
        }

        System.out.println("duplicate chars for string " + stringText + " are : " + duplicateString);
    }

    /**
     * @param numbersLimit
     */
    public static void displayFibonacciNumbers(int numbersLimit) {
        if (numbersLimit < 2) {
            System.out.println("Introduceti un numar mai mare decat 1!");
            return;
        }
        int[] numbers = new int[numbersLimit];
        numbers[0] = 0;
        numbers[1] = 1;

        StringBuilder fibonacciNumbers = new StringBuilder();

        for (int i = 0; i <= (numbersLimit - 1); i++) {
            if (i > 1) {
                numbers[i] = numbers[i - 1] + numbers[i - 2];
            }
            if (i == 24) {
                fibonacciNumbers.append(numbers[i]);
            } else {
                fibonacciNumbers.append(numbers[i]).append(' ');
            }
        }
        System.out.println("First " + numbersLimit + " fibonacci numbers are  " + fibonacciNumbers);
    }
}
