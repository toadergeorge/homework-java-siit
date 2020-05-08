package homework.tema7.cinema.service;

import homework.tema7.cinema.entity.Cinema;
import homework.tema7.cinema.entity.Seat;
import homework.tema7.cinema.repository.CinemaRepository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CinemaService {

    public static void main(String[] args) {

        CinemaRepository cinemaRepository = new CinemaRepository();
        List<Cinema> cinemaList = cinemaRepository.getAll();
        cinemaList.add(new CinemaService().generateCinemaFixture("Cinema Patria", 'J', 10));

        CinemaService cinemaService = new CinemaService();

        cinemaList.forEach((cinema) -> {
                    String name = cinema.getName();
                    if (name.equals("Cinema Patria")) {

                        try {
                            cinemaService.addSeatReservation(cinema, "A1");
                            cinemaService.addSeatReservation(cinema, "A2");

                            cinemaService.cancelReservation(cinema, "A1");
                            cinemaService.cancelReservation(cinema, "A2");

                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
        );
    }

    public void cancelReservation(Cinema cinema, String seatNumber) throws Exception {
        if (cinema.getSeats().containsKey(seatNumber)) {
            cinema.getSeats().get(seatNumber).setReserved(false);
        } else {
            throw new Exception("Seat not found, please try again!");
        }
    }

    public void addSeatReservation(Cinema cinema, String seatNumber) throws Exception {
        if (cinema.getSeats().containsKey(seatNumber)) {
            cinema.getSeats().get(seatNumber).setReserved(true);
        } else {
            throw new Exception("Seat not found, please try again!");
        }
    }

    public Cinema generateCinemaFixture(String cinemaName, char seatMaxRow, int seatMaxNumber) {
        Map<String, Seat> seats = new HashMap<String, Seat>();
        for (char i = 'A'; i <= seatMaxRow; i++) {
            for (int j = 1; j <= seatMaxNumber; j++) {

                BigDecimal price = new BigDecimal("0");

                if (i > 'E') {
                    price = new BigDecimal("40");
                } else {
                    price = new BigDecimal("32");
                }

                String mapKey = i + String.valueOf(j);
                Seat seat = Seat.builder()
                        .seatNumber(mapKey)
                        .reserved(false)
                        .price(price)
                        .build();
                seats.put(seat.getSeatNumber(), seat);
            }
        }

        return Cinema.builder()
                .name(cinemaName)
                .seats(seats)
                .build();
    }
}
