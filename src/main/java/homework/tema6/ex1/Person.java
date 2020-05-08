package homework.tema6.ex1;

import lombok.*;

@Getter
@ToString
public class Person {
    private String name;
    private int age;

    @Builder
    private Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
