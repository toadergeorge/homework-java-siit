package homework.Tema6.Ex1;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetExercise {
    public static void main(String[] args) {

        Person matei = Person.builder()
                .name("Matei")
                .age(18)
                .build();

        Person alex = Person.builder()
                .name("Alex")
                .age(25)
                .build();

        Person ioana = Person.builder()
                .name("Ioana")
                .age(22)
                .build();

        TreeSet<Person> treeSetSortedByName = new TreeSet<Person>(new ComparatorByName());

        treeSetSortedByName.add(alex);
        treeSetSortedByName.add(ioana);
        treeSetSortedByName.add(matei);

        for (Person person : treeSetSortedByName) {
            System.out.println(person.getName());
        }

        TreeSet<Person> treeSetSortedByAge = new TreeSet<Person>(new ComparatorByAge());
        treeSetSortedByAge.addAll(treeSetSortedByName);

        for (Person person : treeSetSortedByAge) {
            System.out.println(person.getAge());
        }
    }
}
