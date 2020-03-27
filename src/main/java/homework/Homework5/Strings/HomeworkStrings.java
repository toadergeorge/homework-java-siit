package homework.Homework5.Strings;

import java.util.Arrays;

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
        String stringWithDuplicatesTwo= "AAABBCCDDXXKLRKA";
        System.out.println("Ex. 6 ===============");
        System.out.println("stringWithDuplicates= " + findStringDuplicates(stringWithDuplicatesTwo));

        //7. Write a method to count a number of vowels and consonants in a given string.
        String vowelsString = "AMAIZING1111";
        System.out.println("Ex. 7 ===============");
        getVowelsAndConsonantsNumber(vowelsString);

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
