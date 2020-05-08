package homework.tema6.ex2;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

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

    public int hashCode() {
        return Objects.hash(name, age);
    }
}
