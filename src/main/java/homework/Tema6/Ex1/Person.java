package homework.Tema6.Ex1;

import lombok.*;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
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
