package homework.Tema4.Strings;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

@RunWith(MockitoJUnitRunner.class)
public class HomeworkStringsTest {

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    private HomeworkStrings sut;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @Before
    public void setup() {
        this.sut = new HomeworkStrings();
    }

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void given_empty_input_when_compute_inverse_then_empty_is_returned() {
        //Given
        String input = "";

        //When
        String returnedString = sut.reverseString(input);

        //Then
        assertThat(returnedString).isEmpty();
    }

    @Test
    public void given_null_input_when_compute_inverse_then_null_is_returned() {
        //Given
        String input = null;

        //When
        String returnedString = sut.reverseString(input);

        //Then
        assertThat(returnedString).isNull();
    }

    @Test
    public void given_string_input_when_compute_inverse_then_inverse_is_returned() {
        //Given
        String input = "abcdefg";

        //When
        String returnedString = sut.reverseString(input);

        //Then
        assertThat(returnedString).isEqualTo("gfedcba");
    }

    @Test
    public void given_string_with_spaces_input_when_compute_inverse_then_inverse_is_returned() {
        //Given
        String input = "abc_   defg  ";

        //When
        String returnedString = sut.reverseString(input);

        //Then
        assertThat(returnedString).isEqualTo(new StringBuilder(input).reverse().toString());
    }

    @Test
    public void given_string_input_when_compute_is_string_anagram_then_boolean_is_returned() {
        //Given
        String input1 = "SILENT2";
        String input2 = "LISTEN2";

        //When
        Boolean isStringAnagram = sut.isStringAnagram(input1, input2);

        //Then
        assertThat(isStringAnagram).isEqualTo(true);
    }

    @Test
    public void given_empty_inputs_when_compute_is_string_anagram_then_boolean_is_returned() {
        //Given
        String input1 = "";
        String input2 = "";

        //When
        Boolean isStringAnagram = sut.isStringAnagram(input1, input2);

        //Then
        assertThat(isStringAnagram).isEqualTo(false);
    }

    @Test
    public void given_empty_first_input_when_compute_is_string_anagram_then_boolean_is_returned() {
        //Given
        String input1 = "";
        String input2 = "AAAAA";

        //When
        Boolean isStringAnagram = sut.isStringAnagram(input1, input2);

        //Then
        assertThat(isStringAnagram).isEqualTo(false);
    }

    @Test
    public void given_empty_second_input_when_compute_is_string_anagram_then_boolean_is_returned() {
        //Given
        String input1 = "ZZZZ";
        String input2 = "";

        //When
        Boolean isStringAnagram = sut.isStringAnagram(input1, input2);

        //Then
        assertThat(isStringAnagram).isEqualTo(false);
    }

    @Test
    public void given_null_inputs_when_compute_is_string_anagram_then_boolean_is_returned() {
        //Given
        String input1 = null;
        String input2 = null;

        //When
        Boolean isStringAnagram = sut.isStringAnagram(input1, input2);

        //Then
        assertThat(isStringAnagram).isEqualTo(false);
    }

    @Test
    public void given_null_first_input_when_compute_is_string_anagram_then_boolean_is_returned() {
        //Given
        String input1 = null;
        String input2 = "bbbbb";

        //When
        Boolean isStringAnagram = sut.isStringAnagram(input1, input2);

        //Then
        assertThat(isStringAnagram).isEqualTo(false);
    }

    @Test
    public void given_null_second_input_when_compute_is_string_anagram_then_boolean_is_returned() {
        //Given
        String input1 = "zzzz";
        String input2 = null;

        //When
        Boolean isStringAnagram = sut.isStringAnagram(input1, input2);

        //Then
        assertThat(isStringAnagram).isEqualTo(false);
    }

    @Test
    public void given_input_with_different_lengths_when_compute_is_string_anagram_then_boolean_is_returned() {
        //Given
        String input1 = "SILENT";
        String input2 = "LISTENA";

        //When
        Boolean isStringAnagram = sut.isStringAnagram(input1, input2);

        //Then
        assertThat(isStringAnagram).isEqualTo(false);
    }

    @Test
    public void given_inputs_with_spaces_when_compute_is_string_anagram_then_boolean_is_returned() {
        //Given
        String input1 = "SIL ENT";
        String input2 = "LIST EN";

        //When
        Boolean isStringAnagram = sut.isStringAnagram(input1, input2);

        //Then
        assertThat(isStringAnagram).isEqualTo(true);
    }

    @Test
    public void given_string_input_string_with_digits_when_compute_get_string_with_digits_then_boolean_is_returned() {
        //Given
        String input = "11111";

        //When
        Boolean returnedString = sut.stringWithDigits(input);

        //Then
        assertThat(returnedString).isEqualTo(true);
    }

    @Test
    public void given_string_input_string_without_digits_when_compute_get_string_with_digits_then_boolean_is_returned() {
        //Given
        String input = "ABBBBBB";

        //When
        Boolean returnedString = sut.stringWithDigits(input);

        //Then
        assertThat(returnedString).isEqualTo(false);
    }

    @Test
    public void given_string_input_string_with_digits_and_letters_when_compute_get_string_with_digits_then_boolean_is_returned() {
        //Given
        String input = "ABBBBBB4444";

        //When
        Boolean returnedString = sut.stringWithDigits(input);

        //Then
        assertThat(returnedString).isEqualTo(false);
    }

    @Test
    public void given_empty_input_when_compute_get_string_with_digits_then_boolean_is_returned() {
        //Given
        String input = "";

        //When
        Boolean returnedString = sut.stringWithDigits(input);

        //Then
        assertThat(returnedString).isEqualTo(false);
    }

    @Test
    public void given_null_input_when_compute_get_string_with_digits_then_boolean_is_returned() {
        //Given
        String input = "";

        //When
        Boolean returnedString = sut.stringWithDigits(input);

        //Then
        assertThat(returnedString).isEqualTo(false);
    }

    @Test
    public void given_input_with_spaces_when_compute_get_string_with_digits_then_boolean_is_returned() {
        //Given
        String input = "1234 55";

        //When
        Boolean returnedString = sut.stringWithDigits(input);

        //Then
        assertThat(returnedString).isEqualTo(false);
    }

    @Test
    public void given_string_input_when_compute_find_string_duplicates_then_duplicates_are_returned() {
        //Given
        String input = "AAABBBCCC";

        //When
        String returnedString = sut.findStringDuplicates(input);

        //Then
        assertThat(returnedString).isEqualTo("AAABBBCCC");
    }

    @Test
    public void given_empty_input_when_compute_find_string_duplicates_then_empty_is_returned() {
        //Given
        String input = "";

        //When
        String returnedString = sut.findStringDuplicates(input);

        //Then
        assertThat(returnedString).isEmpty();
    }

    @Test
    public void given_null_input_when_compute_find_string_duplicates_then_null_is_returned() {
        //Given
        String input = null;

        //When
        String returnedString = sut.findStringDuplicates(input);

        //Then
        assertThat(returnedString).isNull();
    }

    @Test
    public void given_input_with_spaces_when_compute_find_string_duplicates_then_null_is_returned() {
        //Given
        String input = "AAA CCCCDD ";

        //When
        String returnedString = sut.findStringDuplicates(input);

        //Then
        assertThat(returnedString).isEqualTo("AAACCCCDD  ");
    }

    @Test
    public void given_string_input_when_compute_get_vowels_and_consonants_number_then_vowels_and_consonants_are_printed() {
        //Given
        String input = "abcdefg";

        final String vowelsAndConsonantsMessage = "Consonants numbers is:5\nVowel numbers is:2\n";
        provideInput(vowelsAndConsonantsMessage);

        //When
        sut.getVowelsAndConsonantsNumber(input);

        //Then
        assertThat(vowelsAndConsonantsMessage).isEqualTo(getOutput());
    }

    @Test
    public void given_empty_input_when_compute_get_vowels_and_consonants_number_then_zero_are_printed() {
        //Given
        String input = "";

        final String vowelsAndConsonantsMessage = "Consonants numbers is:0\nVowel numbers is:0\n";
        provideInput(vowelsAndConsonantsMessage);

        //When
        sut.getVowelsAndConsonantsNumber(input);

        //Then
        assertThat(vowelsAndConsonantsMessage).isEqualTo(getOutput());
    }

    @Test
    public void given_null_input_when_compute_get_vowels_and_consonants_number_then_zero_are_printed() {
        //Given
        String input = null;

        final String vowelsAndConsonantsMessage = "Consonants numbers is:0\nVowel numbers is:0\n";
        provideInput(vowelsAndConsonantsMessage);

        //When
        sut.getVowelsAndConsonantsNumber(input);

        //Then
        assertThat(vowelsAndConsonantsMessage).isEqualTo(getOutput());
    }

    @Test
    public void given_string_with_spaces_input_when_compute_get_vowels_and_consonants_number_then_vowels_and_consonants_are_printed() {
        //Given
        String input = "abc de";

        final String vowelsAndConsonantsMessage = "Consonants numbers is:3\nVowel numbers is:2\n";
        provideInput(vowelsAndConsonantsMessage);

        //When
        sut.getVowelsAndConsonantsNumber(input);

        //Then
        assertThat(vowelsAndConsonantsMessage).isEqualTo(getOutput());
    }

    @Test
    public void given_string_with_different_chars_than_letters_input_when_compute_get_vowels_and_consonants_number_then_vowels_and_consonants_are_printed() {
        //Given
        String input = "1abc de@;";

        final String vowelsAndConsonantsMessage = "Consonants numbers is:3\nVowel numbers is:2\n";
        provideInput(vowelsAndConsonantsMessage);

        //When
        sut.getVowelsAndConsonantsNumber(input);

        //Then
        assertThat(vowelsAndConsonantsMessage).isEqualTo(getOutput());
    }

    @Test
    public void given_string_input_and_char_when_compute_get_string_occurences_of_char_then_occurences_are_returned() {
        //Given
        String input = "aaabbcf";
        char character = 'a';

        //When
        int returnedInt = sut.getStringOccurences(input, character);

        //Then
        assertThat(returnedInt).isEqualTo(3);
    }

    @Test
    public void given_empty_input_when_compute_get_string_occurences_of_char_then_occurences_are_returned() {
        //Given
        String input = "";
        char character = 'a';

        //When
        int returnedInt = sut.getStringOccurences(input, character);

        //Then
        assertThat(returnedInt).isEqualTo(0);
    }

    @Test
    public void given_empty_character_input_when_compute_get_string_occurences_of_char_then_occurences_are_returned() {
        //Given
        String input = "aaabbb";
        char character = ' ';

        //When
        int returnedInt = sut.getStringOccurences(input, character);

        //Then
        assertThat(returnedInt).isEqualTo(0);
    }

    @Test
    public void given_null_input_when_compute_get_string_occurences_of_char_then_occurences_are_returned() {
        //Given
        String input = null;
        char character = ' ';

        //When
        int returnedInt = sut.getStringOccurences(input, character);

        //Then
        assertThat(returnedInt).isEqualTo(0);
    }

    @Test
    public void given_input_with_spaces_when_compute_get_string_occurences_of_char_then_occurences_are_returned() {
        //Given
        String input = "a bc dee";
        char character = ' ';

        //When
        int returnedInt = sut.getStringOccurences(input, character);

        //Then
        assertThat(returnedInt).isEqualTo(2);
    }

    @Test
    public void given_string_input_when_compute_get_first_non_repeated_char_then_char_is_returned() {
        //Given
        String input = "aabbcdefg";

        //When
        String returnedString = sut.getFirstNonRepeatedChar(input);

        //Then
        assertThat(returnedString).isEqualTo("c");
    }

    @Test
    public void given_empty_input_when_compute_get_first_non_repeated_char_then_empty_is_returned() {
        //Given
        String input = "";

        //When
        String returnedString = sut.getFirstNonRepeatedChar(input);

        //Then
        assertThat(returnedString).isEqualTo("");
    }

    @Test
    public void given_null_input_when_compute_get_first_non_repeated_char_then_null_is_returned() {
        //Given
        String input = null;

        //When
        String returnedString = sut.getFirstNonRepeatedChar(input);

        //Then
        assertThat(returnedString).isNull();
    }

    @Test
    public void given_string_input_with_spaces_when_compute_get_first_non_repeated_char_then_char_is_returned() {
        //Given
        String input = "aabb cde";

        //When
        String returnedString = sut.getFirstNonRepeatedChar(input);

        //Then
        assertThat(returnedString).isEqualTo(" ");
    }

    @Test
    public void given_string_input_when_compute_get_int_from_string_then_int_is_returned() {
        //Given
        String input = "12345";

        //When
        int returnedString = sut.getIntFromString(input);

        //Then
        assertThat(returnedString).isEqualTo(12345);
    }

    @Test
    public void given_empty_input_when_compute_get_int_from_string_then_zero_is_returned() {
        //Given
        String input = "";

        //When
        int returnedString = sut.getIntFromString(input);

        //Then
        assertThat(returnedString).isEqualTo(0);
    }

    @Test
    public void given_null_input_when_compute_get_int_from_string_then_zero_is_returned() {
        //Given
        String input = null;

        //When
        int returnedString = sut.getIntFromString(input);

        //Then
        assertThat(returnedString).isEqualTo(0);
    }

    @Test
    public void given_input_with_spaces_when_compute_get_int_from_string_then_minus_one_is_returned() {
        //Given
        String input = "123 55";

        //When
        int returnedString = sut.getIntFromString(input);

        //Then
        assertThat(returnedString).isEqualTo(-1);
    }

    @Test
    public void given_input_with_letters_when_compute_get_int_from_string_then_minus_one_is_returned() {
        //Given
        String input = "123A55";

        //When
        int returnedString = sut.getIntFromString(input);

        //Then
        assertThat(returnedString).isEqualTo(-1);
    }

    @Test
    public void given_string_input_when_compute_get_backward_sentence_then_backward_sentece_is_returned() {
        //Given
        String input = "Covidul umbla liber pe strazi in lumina stralucitoare a soarelui";

        //When
        String returnedString = sut.getBackwardSentence(input);

        //Then
        assertThat(returnedString).isEqualTo("soarelui a stralucitoare lumina in strazi pe liber umbla Covidul");
    }

    @Test
    public void given_string_empty_when_compute_get_backward_sentence_then_empty_returned() {
        //Given
        String input = "";

        //When
        String returnedString = sut.getBackwardSentence(input);

        //Then
        assertThat(returnedString).isEmpty();
    }

    @Test
    public void given_string_null_when_compute_get_backward_sentence_then_null_is_returned() {
        //Given
        String input = null;

        //When
        String returnedString = sut.getBackwardSentence(input);

        //Then
        assertThat(returnedString).isNull();
    }

    @Test
    public void given_string_input_when_compute_validate_rotated_string_then_boolean_is_returned() {
        //Given
        String input1 = "ABD1";
        String input2 = "D1AB";

        //When
        Boolean returnedString = sut.validateRotatedString(input1, input2);

        //Then
        assertThat(returnedString).isEqualTo(true);
    }

    @Test
    public void given_string_first_input_empty_when_compute_validate_rotated_string_then_boolean_is_returned() {
        //Given
        String input1 = "";
        String input2 = "D1AB";

        //When
        Boolean returnedString = sut.validateRotatedString(input1, input2);

        //Then
        assertThat(returnedString).isEqualTo(false);
    }

    @Test
    public void given_string_second_input_empty_when_compute_validate_rotated_string_then_boolean_is_returned() {
        //Given
        String input1 = "ABD1";
        String input2 = "";

        //When
        Boolean returnedString = sut.validateRotatedString(input1, input2);

        //Then
        assertThat(returnedString).isEqualTo(false);
    }

    @Test
    public void given_string_first_input_null_when_compute_validate_rotated_string_then_boolean_is_returned() {
        //Given
        String input1 = null;
        String input2 = "D1AB";

        //When
        Boolean returnedString = sut.validateRotatedString(input1, input2);

        //Then
        assertThat(returnedString).isEqualTo(false);
    }

    @Test
    public void given_string_second_input_null_when_compute_validate_rotated_string_then_boolean_is_returned() {
        //Given
        String input1 = "ABD1";
        String input2 = null;

        //When
        Boolean returnedString = sut.validateRotatedString(input1, input2);

        //Then
        assertThat(returnedString).isEqualTo(false);
    }

    @Test
    public void given_string_first_input_with_spaces_when_compute_validate_rotated_string_then_boolean_is_returned() {
        //Given
        String input1 = "AB  D1";
        String input2 = " D1AB ";

        //When
        Boolean returnedString = sut.validateRotatedString(input1, input2);

        //Then
        assertThat(returnedString).isEqualTo(true);
    }

    @Test
    public void given_string_input_when_compute_is_palindrome_then_boolean_is_returned() {
        //Given
        String input = "capac";

        //When
        Boolean returnedString = sut.isPalindrome(input);

        //Then
        assertThat(returnedString).isEqualTo(true);
    }

    @Test
    public void given_string_empty_when_compute_is_palindrome_then_boolean_is_returned() {
        //Given
        String input = "";

        //When
        Boolean returnedString = sut.isPalindrome(input);

        //Then
        assertThat(returnedString).isEqualTo(false);
    }

    @Test
    public void given_string_null_when_compute_is_palindrome_then_boolean_is_returned() {
        //Given
        String input = null;

        //When
        Boolean returnedString = sut.isPalindrome(input);

        //Then
        assertThat(returnedString).isEqualTo(false);
    }

    @Test
    public void given_string_with_spaces_when_compute_is_palindrome_then_boolean_is_returned() {
        //Given
        String input = "cap ac";

        //When
        Boolean returnedString = sut.isPalindrome(input);

        //Then
        assertThat(returnedString).isEqualTo(false);
    }


    @Test
    public void given_string_input_when_compute_get_largest_substring_with_unique_chars_then_int_is_returned() {
        //Given
        String input = "abcdefgacd";

        //When
        int returnedStringLength = sut.getLargestSubstring(input);

        //Then
        assertThat(returnedStringLength).isEqualTo(7);
    }


    @Test
    public void given_string_empty_when_compute_get_largest_substring_with_unique_chars_then_int_is_returned() {
        //Given
        String input = "";

        //When
        int returnedStringLength = sut.getLargestSubstring(input);

        //Then
        assertThat(returnedStringLength).isEqualTo(0);
    }

    @Test
    public void given_string_null_when_compute_get_largest_substring_with_unique_chars_then_int_is_returned() {
        //Given
        String input = null;

        //When
        int returnedStringLength = sut.getLargestSubstring(input);

        //Then
        assertThat(returnedStringLength).isEqualTo(0);
    }

    @Test
    public void given_string_with_spaces_when_compute_get_largest_substring_with_unique_chars_then_int_is_returned() {
        //Given
        String input = "abcdefg hi jlkkm";

        //When
        int returnedStringLength = sut.getLargestSubstring(input);

        //Then
        assertThat(returnedStringLength).isEqualTo(10);
    }



    @Test
    public void given_string_input_when_compute_get_string_duplicates_then_duplicates_are_returned() {
        //Given
        String input = "aabbvvddg";

        //When
        String returnedString = sut.getStringDuplicates(input);

        //Then
        assertThat(returnedString).isEqualTo("abvd");
    }

    @Test
    public void given_empty_input_when_compute_get_string_duplicates_then_empty_is_returned() {
        //Given
        String input = "";

        //When
        String returnedString = sut.getStringDuplicates(input);

        //Then
        assertThat(returnedString).isEmpty();
    }

    @Test
    public void given_null_input_when_compute_get_string_duplicates_then_null_is_returned() {
        //Given
        String input = null;

        //When
        String returnedString = sut.getStringDuplicates(input);

        //Then
        assertThat(returnedString).isNull();
    }

    @Test
    public void given_string_with_spaces_input_when_compute_get_string_duplicates_then_duplicates_are_returned() {
        //Given
        String input = "aabbcc ff hh";

        //When
        String returnedString = sut.getStringDuplicates(input);

        //Then
        assertThat(returnedString).isEqualTo("abcf h");
    }



//getLargestPalindromicSubstring

//getStringWithoutDuplicates

//removeCharFromString

//getMostFrequentWord

}
