package homework.tema4.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeworkStrings {
    public static void main(String[] args) {
        //1. Write a method to reverse a given string in place.
        String stringForReverse = "abcdefg";
        System.out.println("Ex. 1 ===============");
        System.out.println("stringForReverse = " + reverseString(stringForReverse));

        //2. Write a method to print duplicate characters from a string.
        String stringWithDuplicates = "aaabbbcccdddsssght";
        System.out.println("Ex. 2 ===============");
        System.out.println("stringDuplicates = " + getStringDuplicates(stringWithDuplicates));

        //3. Write a method to check if two strings are anagrams of each other.
        String stringAnagramFirst = "SILENT2";
        String stringAnagramSecond = "LISTEN2";
        System.out.println("Ex. 3 ===============");
        System.out.println("stringsAreAnagram = " + isStringAnagram(stringAnagramFirst, stringAnagramSecond));


        //4. Write a method to find all the permutations of a string
        String stringWithPermutations = "ABC";
        System.out.println("Ex. 4 ===============");
        System.out.println("stringWithDigits = " + getStringPermutations(stringWithPermutations));

        //5. Write a method to check if a string contains only digits.
        String stringWithDigits = "1234567";
        System.out.println("Ex. 5 ===============");
        System.out.println("stringWithDigits = " + stringWithDigits(stringWithDigits));

        //6. Write a method to find duplicate characters in a given string.
        String stringWithDuplicatesTwo = "AAABBCCDDXXKLRKA";
        System.out.println("Ex. 6 ===============");
        System.out.println("stringWithDuplicates= " + findStringDuplicates(stringWithDuplicatesTwo));

        //7. Write a method to count a number of vowels and consonants in a given string.
        String vowelsString = "AMAIZING1111";
        System.out.println("Ex. 7 ===============");
        getVowelsAndConsonantsNumber(vowelsString);

        //8.Write a method to count the occurrence of a given character in a string.
        String doubleCharString = "anaxsolfssd";
        char character = 's';
        System.out.println("Ex. 8 ===============");
        System.out.println("char " + character + " appears " + getStringOccurences(doubleCharString, character) + " times");

        //9. Write a method to print the first non-repeated character from a string
        String stringWithDoubles = "liaassxxbbccklik@";
        System.out.println("Ex. 9 ===============");
        String resultFirstChar = getFirstNonRepeatedChar(stringWithDoubles);
        if (resultFirstChar.equals("")) {
            System.out.println("First no-repetead character was not found!");
        } else {
            System.out.println("First no-repetead character is :" + resultFirstChar);
        }

        //10. Write a method to convert a given String into int like the atoi().
        String stringForInt = "639788";
        System.out.println("Ex. 10 ===============");
        int intFromString = getIntFromString(stringForInt);
        System.out.println("Int from string : " + getIntFromString(stringForInt));

        //11. Write a method to reverse words in a given sentence without using any library method.
        String sentence = "Covidul umbla liber pe strazi in lumina stralucitoare a soarelui";
        System.out.println("Ex. 11 ===============");
        System.out.println("Backward sentence" + getBackwardSentence(sentence));
        //12. Write a method to check if two strings are a rotation of each other.
        String stringToRotate = "ABD1";
        String rotatedString = "D1AB";
        System.out.println("Ex. 12 ===============");
        System.out.println("String are rotated :" + validateRotatedString(stringToRotate, rotatedString));
        //13. Write a method to check if a given string is a palindrome.
        String stringPalindrome = "capac";
        System.out.println("Ex. 13 ===============");
        System.out.println("String is palindrome :" + isPalindrome(stringPalindrome));

        //14. Write a method to find the length of the longest substring without repeating characters.
        String longestSubstring = "abcdefgacd";
        System.out.println("Ex. 14 ===============");
        System.out.println("Largest substring :" + getLargestSubstring(longestSubstring));

        //15. Given string str, write a method to find the longest palindromic substring in str.
        String longestPalindromicSubstring = "abracadabra";
        System.out.println("Ex. 15 ===============");
        System.out.println("Largest substring palindrom:" + getLargestPalindromicSubstring(longestPalindromicSubstring));
        //16. Write a method to remove the duplicate character from String.
        String stringWithDuplicatesThree = "aabboccssk";
        System.out.println("Ex. 16 ===============");
        System.out.println("String without duplicates :" + getStringWithoutDuplicates(stringWithDuplicatesThree));
        //17. Write a method to remove a given character from String.
        char charToRemove = 'a';
        String stringForRemoval = "aabboccssk";
        System.out.println("Ex. 17 ===============");
        System.out.println("String after remove :" + removeCharFromString(stringForRemoval, charToRemove));

        //18. Given an array of strings, find the most frequent word in a given array, I mean, the string that appears the most in the array.
        //In the case of a tie, ​the string that is the smallest (lexicographically) ​is printed.
        String[] stringsArray = {"gad", "gad", "corona", "virus", "god", "god"};

        System.out.println("Ex. 18 ===============");
        System.out.println("The most frequent word is :" + getMostFrequentWord(stringsArray));
    }

    private static String getMostFrequentWord(String[] string) {
        int numberOfOccurences = 1;
        int numberOfOccurencesTem = 0;
        String word = "";
        String wordTem = "";

        for (int i = 0; i < string.length; i++) {
            for (int j = 0; j < string.length; j++) {
                if (i != j && string[i].equals(string[j])) {
                    wordTem = string[i];
                    numberOfOccurencesTem++;
                }
            }

            if (numberOfOccurences < numberOfOccurencesTem) {
                numberOfOccurences = numberOfOccurencesTem;
                word = wordTem;
            } else if (numberOfOccurences == numberOfOccurencesTem && !word.equals(wordTem)) {
                if (word.compareTo(wordTem) < 0) {
                    word = wordTem;
                }
            }

            numberOfOccurencesTem = 1;
        }

        return word;
    }

    private static String removeCharFromString(String string, char charForRemove) {
        String newString = "";

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != charForRemove) {
                newString += string.charAt(i);
            }
        }

        return newString;
    }

    private static String getStringWithoutDuplicates(String string) {

        String stringWithoutDuplicateChars = "";

        boolean charUnique = true;
        for (int i = 0; i < string.length(); i++) {


            for (int j = 0; j < string.length(); j++) {

                if (i != j && string.charAt(i) == string.charAt(j)) {
                    charUnique = false;
                    break;
                }
            }

            if (charUnique) {
                stringWithoutDuplicateChars += string.charAt(i);
            }
            charUnique = true;
        }

        return stringWithoutDuplicateChars;
    }

    public static String getLargestPalindromicSubstring(String longestPalindromicSubstring) {
        String substringPalindrome = "";
        String temp = "";

        int plaindromMaxLength = 0;
        int currentLength = 0;

        for (int i = 0; i < longestPalindromicSubstring.length(); i++) {

            temp = getPalindromSubstring(longestPalindromicSubstring, i, i);
            currentLength = temp.length();

            if (currentLength > plaindromMaxLength) {
                plaindromMaxLength = currentLength;
                substringPalindrome = temp;
            }

            temp = getPalindromSubstring(longestPalindromicSubstring, i, i + 1);
            currentLength = temp.length();

            if (currentLength > plaindromMaxLength) {
                plaindromMaxLength = currentLength;
                substringPalindrome = temp;
            }
        }

        return substringPalindrome;
    }

    private static String getPalindromSubstring(String string, int startIndex, int endIndex) {
        int stringSize = string.length();

        while (startIndex >= 0 && endIndex < stringSize && (string.charAt(startIndex) == string.charAt(endIndex))) {
            startIndex--;
            endIndex++;
        }

        return string.substring(startIndex + 1, endIndex);
    }

    public static int getLargestSubstring(String longestSubstring) {

        if (longestSubstring == null) {
            return 0;
        }

        String substring = "";

        for (int i = 0; i < longestSubstring.length(); i++) {
            List<String> substringArray = new ArrayList<String>();
            substringArray.add(longestSubstring.charAt(i) + "");

            int substringLimit = i + 1;
            for (; substringLimit < longestSubstring.length(); substringLimit++) {
                if (substringArray.contains(longestSubstring.charAt(substringLimit) + "")) {
                    break;
                } else {
                    substringArray.add(longestSubstring.charAt(substringLimit) + "");
                }
            }
            substringArray.clear();

            if (substring.length() < substringLimit - i) {
                substring = longestSubstring.substring(i, substringLimit);
            }

        }
        return substring.length();
    }

    public static Boolean isPalindrome(String stringPalindrome) {
        if (stringPalindrome == null || stringPalindrome.equals("")) {
            return false;
        }

        for (int i = 0; i < stringPalindrome.length(); i++) {
            if (stringPalindrome.charAt(i) != stringPalindrome.charAt(stringPalindrome.length() - 1 - i) || stringPalindrome.charAt(i) == ' ') {
                return false;
            }
        }
        return true;
    }

    public static Boolean validateRotatedString(String stringToRotate, String rotatedString) {
        if (stringToRotate == null || rotatedString == null) {
            return false;
        }

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

    public static String getBackwardSentence(String sentence) {
        if (sentence == null) {
            return null;
        }

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
            sentenceList.add(word);
        }

        String backwardString = "";
        for (int j = sentenceList.size() - 1; j >= 0; j--) {
            backwardString += sentenceList.get(j);
        }

        return backwardString;
    }

    public static int getIntFromString(String string) {

        if (string == null) {
            return 0;
        }


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

    public static String getFirstNonRepeatedChar(String string) {

        if (string == null) {
            return null;
        }

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

    public static int getStringOccurences(String string, char character) {
        int occurences = 0;

        if (string == null) {
            return 0;
        }


        char[] stringToArray = string.toCharArray();

        for (char arrayChar : stringToArray) {
            if (arrayChar == character) {
                occurences++;
            }
        }

        return occurences;
    }

    public static void getVowelsAndConsonantsNumber(String vowelsString) {
        int vowels = 0;
        int consonants = 0;

        if (vowelsString == null) {
            System.out.println("Consonants numbers is:" + consonants);
            System.out.println("Vowel numbers is:" + vowels);
            return;
        }

        String vowelsStringLower = vowelsString.toLowerCase();
        char[] ch = vowelsStringLower.toCharArray();

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

    public static String findStringDuplicates(String string) {

        if (string == null) {
            return null;
        }

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

    public static String getStringPermutations(String string) {
        //recursivitare -- not done
        return "not implemented yet!";
    }

    public static Boolean isStringAnagram(String stringAnagramFirst, String stringAnagramSecond) {
        if (
                stringAnagramFirst == null ||
                        stringAnagramSecond == null ||
                        stringAnagramSecond.equals("") ||
                        stringAnagramFirst.equals("")) {
            return false;
        }

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


    public static Boolean stringWithDigits(String string) {

        char[] ch = string.toCharArray();

        if (string.equals("") || string == null) {
            return false;
        }

        for (int i = 0; i < string.length(); i++) {

            if (ch[i] < '0' || ch[i] > '9') {
                return false;
            }
        }

        return true;
    }

    public static String reverseString(String string) {

        if (string == null) {
            return null;
        }

        String resultString = "";
        for (int i = (string.length() - 1); i >= 0; i--) {
            resultString += string.charAt(i);
        }
        return resultString;
    }

    public static String getStringDuplicates(String string) {
        if (string == null) {
            return null;
        }

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
