package homework.tema6.ex2;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class Hobby {

    private String name;
    private int frequency;
    private List<Address> addresses;

    @Builder
    private Hobby(String name, int frequency, List<Address> addresses) {
        this.name = name;
        this.frequency = frequency;
        this.addresses = addresses;
    }
}
