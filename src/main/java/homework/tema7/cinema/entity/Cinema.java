package homework.tema7.cinema.entity;

import lombok.*;

import java.util.Map;

@Getter
@ToString
@Builder
@Data
@EqualsAndHashCode
public class Cinema {
    private String name;
    private Map<String, Seat> seats;
}
