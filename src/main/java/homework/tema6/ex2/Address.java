package homework.tema6.ex2;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Address {
    private String street;
    private String country;

    @Builder
    private Address(String street, String country) {
        this.street = street;
        this.country = country;
    }
}
