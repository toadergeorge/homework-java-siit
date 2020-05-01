package homework.Tema6.Ex2;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

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

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !(o instanceof Person)) {
            return false;
        }
        Person person = (Person) o;
        return (name.equals(person.getName()) && age == person.getAge());
    }
}
