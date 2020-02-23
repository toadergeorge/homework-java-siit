package homework;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.Scanner;

public class HomeworkOne {

    public static void main(String... args) {

        Scanner scanner = new Scanner(System.in);


        //tema 1
        System.out.println("Exercitiul 1 - SUMA PRIMELOR 100 NUMERE PRIME");
        System.out.println("suma = " + getPrimeNumbersSum(100));
        System.out.println("=================================================");
        System.out.println("Exercitiul 2 - AFISAREA CELUI MAI MIC NR DIN ARRAY");
        System.out.println("Introduceti numerele cu spatiu intre ele:");

        String numbers = scanner.nextLine();
        System.out.println("VERSIUNEA 1 - Cel mai mic nr este  :" + getSmallestNumberFromStringV1(numbers));
        System.out.println("VERSIUNEA 2 - Cel mai mic nr este  :" + getSmallestNumberFromStringV2(numbers));
        System.out.println("=================================================");
        System.out.println("Exrcitiul 3 - AFISARE CEA MAI MARE CIFRA DINTR-UN NUMAR");
        System.out.println("introduceti numarul: ");
        int number = scanner.nextInt();
        System.out.println("maxDigit = " + getMaxNumberDigit(number));
        System.out.println("=================================================");


    }

    private static int getMaxNumberDigit(int number) {
        number = Math.abs(number);

        int length = String.valueOf(number).length();
        int[] digits = new int[length];
        int maxDigit = 0;
        int i = 0;

        for (int arrayEmptyItem : digits) {

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
                isPrime = false;
            }
        }

        return sumPrimeNumbers;
    }
}
