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
    public void restoreSystemInputOutput(){
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





}
