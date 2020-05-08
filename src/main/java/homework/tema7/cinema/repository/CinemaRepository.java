package homework.tema7.cinema.repository;

import homework.tema7.cinema.entity.Cinema;
import java.util.ArrayList;
import java.util.List;

public class CinemaRepository {

    public final static List<Cinema> cinemaDbRecords = new ArrayList<>();

    public List<Cinema> getAll(){
        return cinemaDbRecords;
    }

    public void insertCinema(Cinema cinema){
        cinemaDbRecords.add(cinema);
    }

    public void deleteCinema(Cinema cinema){
        cinemaDbRecords.remove(cinema);
    }
}
