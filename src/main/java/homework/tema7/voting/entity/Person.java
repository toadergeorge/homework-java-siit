package homework.tema7.voting.entity;

import lombok.*;

@Getter
@ToString
@Builder
@Data
@EqualsAndHashCode
public class Person {
    private String firstName;
    private String lastName;
    private String address;
    private String cnp;
    private String idSeries;
    private int idNumber;
}
