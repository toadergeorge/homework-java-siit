package homework.tema9.smallExercises;

import homework.tema7.cinema.entity.Cinema;
import homework.tema7.cinema.repository.CinemaRepository;
import homework.tema7.cinema.service.CinemaService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class IoExercisesTest {

    private IoExercises sut;

    @Before
    public void setup() {
        this.sut = new IoExercises();
    }

    @Test
    public void given_path_input_when_press_enter_then_all_files_and_folder_names_in_given_path() {
        //Given
        String path = "files";

        //When
        String result = "";
        try {
            result = this.sut.getPathElements(path);
        } catch (IOException e) {
            Assert.fail("Unexpected exception to be thrown!");
        }

        //Then
        assertThat(result).isEqualTo("[files, files/test1, files/test_folder]");
    }

    @Test
    public void given_empty_path_input_when_press_enter_then_empty_string_as_result() {
        //Given
        String path = "";

        //When
        String result = "";
        try {
            result = this.sut.getPathElements(path);
        } catch (IOException e) {
            Assert.fail("Unexpected exception to be thrown!");
        }

        //Then
        assertThat(result).isEqualTo("");
    }


}
