package homework.Tema4.Strings;

import com.sun.javafx.image.impl.BaseByteToIntConverter;
import homework.Tema3.library.entity.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeworkStrings {
    public static void main(String[] args) {
//        //1. Write a method to reverse a given string in place.
//        String stringForReverse = "abcdefg";
//        System.out.println("Ex. 1 ===============");
//        System.out.println("stringForReverse = " + reverseString(stringForReverse));
//
//        //2. Write a method to print duplicate characters from a string.
//        String stringWithDuplicates = "aaabbbcccdddsssght";
//        System.out.println("Ex. 2 ===============");
//        System.out.println("stringDuplicates = " + getStringDuplicates(stringWithDuplicates));
//
//        //3. Write a method to check if two strings are anagrams of each other.
//        String stringAnagramFirst = "SILENT2";
//        String stringAnagramSecond = "LISTEN2";
//        System.out.println("Ex. 3 ===============");
//        System.out.println("stringsAreAnagram = " + isStringAnagram(stringAnagramFirst, stringAnagramSecond));
//
//
//        //4. Write a method to find all the permutations of a string
//        String stringWithPermutations = "ABC";
//        System.out.println("Ex. 4 ===============");
//        System.out.println("stringWithDigits = " + getStringPermutations(stringWithPermutations));
//
//        //5. Write a method to check if a string contains only digits.
//        String stringWithDigits = "1234567";
//        System.out.println("Ex. 5 ===============");
//        System.out.println("stringWithDigits = " + stringWithDigits(stringWithDigits));
//
//        //6. Write a method to find duplicate characters in a given string.
//        String stringWithDuplicatesTwo = "AAABBCCDDXXKLRKA";
//        System.out.println("Ex. 6 ===============");
//        System.out.println("stringWithDuplicates= " + findStringDuplicates(stringWithDuplicatesTwo));
//
//        //7. Write a method to count a number of vowels and consonants in a given string.
//        String vowelsString = "AMAIZING1111";
//        System.out.println("Ex. 7 ===============");
//        getVowelsAndConsonantsNumber(vowelsString);
//
//        //8.Write a method to count the occurrence of a given character in a string.
//        String doubleCharString = "anaxsolfssd";
//        char character = 's';
//        System.out.println("Ex. 8 ===============");
//        System.out.println("char " + character + " appears " + getStringOccurences(doubleCharString, character) + " times");
//
//        //9. Write a method to print the first non-repeated character from a string
//        String stringWithDoubles = "liaassxxbbccklik@";
//        System.out.println("Ex. 9 ===============");
//        String resultFirstChar = getFirstNonRepeteadChar(stringWithDoubles);
//        if (resultFirstChar.equals("")) {
//            System.out.println("First no-repetead character was not found!" + resultFirstChar);
//        } else {
//            System.out.println("First no-repetead character is :" + resultFirstChar);
//        }
//
//        //10. Write a method to convert a given String into int like the atoi().
//        String stringForInt = "639788";
//        System.out.println("Ex. 10 ===============");
//        int intFromString = getIntFromString(stringForInt);
//        System.out.println("Int from string : " + getIntFromString(stringForInt));
//
//        //11. Write a method to reverse words in a given sentence without using any library method.
//        String sentence = " Covidul umbla liber pe strazi in lumina stralucitoare a soarelui";
//        System.out.println("Ex. 11 ===============");
//        System.out.println("Backward sentence" + getBackwardSentence(sentence));
//        //12. Write a method to check if two strings are a rotation of each other.
//        String stringToRotate = "ABD1";
//        String rotatedString = "D1AB";
//        System.out.println("Ex. 12 ===============");
//        System.out.println("String are rotated :" + validateRotatedString(stringToRotate, rotatedString));
//        //13. Write a method to check if a given string is a palindrome.
//        String stringPalindrome = "capac";
//        System.out.println("Ex. 13 ===============");
//        System.out.println("String is palindrome :" + isPalindrome(stringPalindrome));


        //14. Write a method to find the length of the longest substring without repeating characters.
//        String stringPalindrome = "capac";
//        System.out.println("Ex. 13 ===============");
//        System.out.println("String is palindrome :" + isPalindrome(stringPalindrome));


    }

    private static Boolean isPalindrome(String stringPalindrome) {
        for (int i = 0; i < stringPalindrome.length(); i++) {
            if (stringPalindrome.charAt(i) != stringPalindrome.charAt(stringPalindrome.length() - 1 - i) || stringPalindrome.charAt(i) == ' ') {
                return false;
            }
        }
        return true;
    }

    private static Boolean validateRotatedString(String stringToRotate, String rotatedString) {
        if (stringToRotate.length() != rotatedString.length()) {
            return false;
        }

        int middleOfString = Math.abs(stringToRotate.length() / 2);
        int pivot = 0;
        if (stringToRotate.length() % 2 != 0) {
            pivot = 1;
        }
        int indexBackwardString = 0;

        for (int i = 0; i < stringToRotate.length(); i++) {

            if (i < middleOfString && stringToRotate.charAt(i) != rotatedString.charAt(middleOfString + pivot + i)) {
                return false;
            }

            if (i >= (middleOfString + pivot) && stringToRotate.charAt(i) != rotatedString.charAt(indexBackwardString)) {
                return false;
            }

            if (i >= (middleOfString + pivot)) {
                indexBackwardString++;
            }
        }

        return true;
    }

    private static String getBackwardSentence(String sentence) {
        String word = "";

        List<String> sentenceList = new ArrayList<String>();

        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ') {
                word = sentence.charAt(i) + word;
                sentenceList.add(word);
                word = "";
            } else {
                word += sentence.charAt(i);
            }
        }

        if (!word.equals("")) {
            word = " " + word;
            sentenceList.add(word);
        }

        String backwardString = "";
        for (int j = sentenceList.size() - 1; j >= 0; j--) {
            backwardString += sentenceList.get(j);
        }

        return backwardString;
    }

    private static int getIntFromString(String string) {
        int intFromString = 0;
        int signNegative = 1;

        char[] stringToArray = string.toCharArray();

        for (int i = 0; i < stringToArray.length; i++) {

            if (i == 0 && string.charAt(i) == '-') {
                signNegative = -1;
                continue;
            }

            if (i == 0 && string.charAt(i) == '+') {
                signNegative = 1;
                continue;
            }

            if (string.charAt(i) >= '0' && string.charAt(i) <= '9') {
                intFromString = intFromString * 10 + (string.charAt(i) - '0');
            } else {
                return -1;
            }
        }

        intFromString = intFromString * signNegative;

        if (intFromString > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (intFromString < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return intFromString;
    }

    private static String getFirstNonRepeteadChar(String string) {
        String charater = "";

        char[] arrayOfChars = string.toCharArray();

        boolean unique = true;
        for (int i = 0; i < arrayOfChars.length; i++) {


            for (int j = 0; j < arrayOfChars.length; j++) {

                if (i != j && arrayOfChars[i] == arrayOfChars[j]) {
                    unique = false;
                }

            }


            if (unique) {
                charater += arrayOfChars[i];
                return charater;
            }

            unique = true;
        }
        return charater;
    }

    private static int getStringOccurences(String string, char character) {
        int occurences = 0;

        char[] stringToArray = string.toCharArray();

        for (char arrayChar : stringToArray) {
            if (arrayChar == character) {
                occurences++;
            }
        }

        return occurences;
    }

    private static void getVowelsAndConsonantsNumber(String vowelsString) {

        String vowelsStringLower = vowelsString.toLowerCase();
        char[] ch = vowelsStringLower.toCharArray();
        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < vowelsString.length(); i++) {
            if (ch[i] == 'a' || ch[i] == 'o' || ch[i] == 'u' || ch[i] == 'e' || ch[i] == 'i') {
                vowels++;
            } else if (ch[i] >= 'a' && ch[i] <= 'z') {
                consonants++;
            }
        }
        System.out.println("Consonants numbers is:" + consonants);
        System.out.println("Vowel numbers is:" + vowels);
    }

    private static String findStringDuplicates(String string) {
        String resultString = "";
        String uniqueString = "";

        char[] ch = string.toCharArray();

        for (int i = 0; i < string.length(); i++) {

            String stringCharacter = String.valueOf(ch[i]);

            if (uniqueString.matches("(.*)" + stringCharacter + "(.*)")) {
                resultString += ch[i];
                resultString += ch[i];
                uniqueString = uniqueString.replaceFirst(String.valueOf(ch[i]), "");
            } else if (!uniqueString.matches("(.*)" + stringCharacter + "(.*)") && !resultString.matches("(.*)" + stringCharacter + "(.*)")) {
                uniqueString += ch[i];
            } else if (resultString.matches("(.*)" + stringCharacter + "(.*)")) {
                resultString += ch[i];
            }
        }

        return resultString;
    }

    private static String getStringPermutations(String string) {
        //recursivitare -- not done
        return "not implemented yet!";
    }

    private static Boolean isStringAnagram(String stringAnagramFirst, String stringAnagramSecond) {
        if (stringAnagramFirst.length() != stringAnagramSecond.length()) {
            return false;
        }

        char[] stringFirstArray = stringAnagramFirst.toCharArray();
        char[] stringSecondArray = stringAnagramSecond.toCharArray();

        Arrays.sort(stringFirstArray);
        Arrays.sort(stringSecondArray);

        for (int i = 0; i <= (stringAnagramFirst.length() - 1); i++) {
            if (stringFirstArray[i] != stringSecondArray[i]) {
                return false;
            }
        }

        return true;
    }


    private static Boolean stringWithDigits(String string) {

        char[] ch = string.toCharArray();
        for (int i = 0; i < string.length(); i++) {

            if (ch[i] < '0' || ch[i] > '9') {
                return false;
            }
        }

        return true;
    }

    private static String reverseString(String string) {
        String resultString = "";
        for (int i = (string.length() - 1); i >= 0; i--) {
            resultString += string.charAt(i);
        }
        return resultString;
    }

    private static String getStringDuplicates(String string) {
        String resultString = "";
        String uniqueString = "";

        char[] ch = string.toCharArray();

        for (int i = 0; i < string.length(); i++) {

            String stringCharacter = String.valueOf(ch[i]);

            if (uniqueString.matches("(.*)" + stringCharacter + "(.*)") && !resultString.matches("(.*)" + stringCharacter + "(.*)")) {
                resultString += ch[i];
            } else if (!uniqueString.matches("(.*)" + stringCharacter + "(.*)")) {
                uniqueString += ch[i];
            }
        }

        return resultString;
    }
}