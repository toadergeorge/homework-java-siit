package homework.tema7.cinema.service;

import homework.tema7.cinema.entity.Cinema;
import homework.tema7.cinema.repository.CinemaRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class CinemaServiceTest {

    private CinemaService sut;
    private List<Cinema> cinemaList;

    @Before
    public void setup() {
        this.sut = new CinemaService();

        CinemaRepository cinemaRepository = new CinemaRepository();
        this.cinemaList = cinemaRepository.getAll();
        this.cinemaList.add(new CinemaService().generateCinemaFixture("Cinema Patria", 'J', 10));
    }

    @Test
    public void given_one_cinema_and_seat_input_when_cancel_reservation_then_seat_is_unreserved_in_given_cinema() {
        //Given
        String seatForReservationCancel = "A1";
        String cinemaName = "Cinema Patria";

        this.cinemaList.forEach((cinema) -> {
                    String name = cinema.getName();
                    if (name.equals(cinemaName)) {

                        try {
                            this.sut.addSeatReservation(cinema, seatForReservationCancel);
                        } catch (Exception e) {
                            Assert.fail("Unexpected exception to be thrown!");
                        }

                    }
                }
        );

        //When
        this.cinemaList.forEach((cinema) -> {
                    String name = cinema.getName();
                    if (name.equals(cinemaName)) {
                        try {
                            this.sut.cancelReservation(cinema, seatForReservationCancel);
                        } catch (Exception e) {
                            Assert.fail("Unexpected exception to be thrown!");
                        }
                    }
                }
        );

        //Then
        boolean reservationStatus = this.cinemaList.get(0).getSeats().get(seatForReservationCancel).isReserved();
        assertThat(reservationStatus).isEqualTo(false);
    }

    @Test
    public void given_one_cinema_and_wrong_seat_input_when_cancel_reservation_then_exception_is_thrown(){
        //Given
        String correctSeatForReservationCancel = "A1";
        String wrongSeatForReservationCancel = "a1";
        String cinemaName = "Cinema Patria";

        this.cinemaList.forEach((cinema) -> {
                    String name = cinema.getName();
                    if (name.equals(cinemaName)) {

                        try {
                            this.sut.addSeatReservation(cinema, correctSeatForReservationCancel);
                        } catch (Exception e) {
                            Assert.fail("Expected exception not thrown");
                        }
                    }
                }
        );

        //When
        this.cinemaList.forEach((cinema) -> {
                    String name = cinema.getName();
                    if (name.equals(cinemaName)) {
                        try {
                            this.sut.cancelReservation(cinema, wrongSeatForReservationCancel);
                            Assert.fail("Expected exception not thrown");
                        } catch (Exception e) {
                            assertThat(e.getMessage()).isEqualTo("Seat not found, please try again!");
                        }
                    }
                }
        );
    }

    @Test
    public void given_one_cinema_and_null_seat_input_when_cancel_reservation_then_exception_is_thrown(){
        //Given
        String correctSeatForReservationCancel = "A1";
        String wrongSeatForReservationCancel = null;
        String cinemaName = "Cinema Patria";

        this.cinemaList.forEach((cinema) -> {
                    String name = cinema.getName();
                    if (name.equals(cinemaName)) {

                        try {
                            this.sut.addSeatReservation(cinema, correctSeatForReservationCancel);
                        } catch (Exception e) {
                            Assert.fail("Expected exception not thrown");
                        }
                    }
                }
        );

        //When
        this.cinemaList.forEach((cinema) -> {
                    String name = cinema.getName();
                    if (name.equals(cinemaName)) {
                        try {
                            this.sut.cancelReservation(cinema, wrongSeatForReservationCancel);
                            Assert.fail("Expected exception not thrown");
                        } catch (Exception e) {
                            assertThat(e.getMessage()).isEqualTo("Seat not found, please try again!");
                        }
                    }
                }
        );
    }


    @Test
    public void given_one_cinema_and_seat_input_when_add_reservation_then_seat_is_reserved_in_given_cinema() {
        //Given
        String seatForReservation = "A2";
        String cinemaName = "Cinema Patria";

        //When
        this.cinemaList.forEach((cinema) -> {
                    String name = cinema.getName();
                    if (name.equals(cinemaName)) {

                        try {
                            this.sut.addSeatReservation(cinema, seatForReservation);
                        } catch (Exception e) {
                            Assert.fail("Unexpected exception to be thrown!");
                        }

                    }
                }
        );

        //Then
        boolean reservationStatus = this.cinemaList.get(0).getSeats().get(seatForReservation).isReserved();
        assertThat(reservationStatus).isEqualTo(true);
    }

    @Test
    public void given_one_cinema_and_wrong_seat_input_when_add_reservation_then_exception_is_thrown() {
        //Given
        String seatForReservation = "a2";
        String cinemaName = "Cinema Patria";

        //When
        //Then
        this.cinemaList.forEach((cinema) -> {
                    String name = cinema.getName();
                    if (name.equals(cinemaName)) {

                        try {
                            this.sut.addSeatReservation(cinema, seatForReservation);
                            Assert.fail("Expected exception to be thrown!");
                        } catch (Exception e) {
                            assertThat(e.getMessage()).isEqualTo("Seat not found, please try again!");
                        }

                    }
                }
        );
    }

    @Test
    public void given_one_cinema_and_null_seat_input_when_add_reservation_then_exception_is_thrown() {
        //Given
        String seatForReservation = null;
        String cinemaName = "Cinema Patria";

        //When
        //Then
        this.cinemaList.forEach((cinema) -> {
                    String name = cinema.getName();
                    if (name.equals(cinemaName)) {

                        try {
                            this.sut.addSeatReservation(cinema, seatForReservation);
                            Assert.fail("Expected exception to be thrown!");
                        } catch (Exception e) {
                            assertThat(e.getMessage()).isEqualTo("Seat not found, please try again!");
                        }

                    }
                }
        );
    }
}
