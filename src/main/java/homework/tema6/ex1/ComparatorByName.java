package homework.tema6.ex1;

import java.util.Comparator;

public class ComparatorByName implements Comparator<Person> {

    @Override
    public int compare(Person person1, Person person2) {
        return (int) person1.getName().compareTo(person2.getName());
    }
}