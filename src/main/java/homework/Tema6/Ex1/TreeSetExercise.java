package homework.Tema6.Ex1;

import java.util.Comparator;
import java.util.Iterator;
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

        Iterator<Person> iterator = treeSetSortedByName.iterator();

        while (iterator.hasNext()) {
            Person currentElement = iterator.next();
            System.out.println(currentElement.getName());
        }

        TreeSet<Person> treeSetSortedByAge = new TreeSet<Person>(new ComparatorByAge());
        treeSetSortedByAge.addAll(treeSetSortedByName);

        Iterator<Person> iterator2 = treeSetSortedByAge.iterator();

        while (iterator2.hasNext()) {
            Person currentElement = iterator2.next();
            System.out.println(currentElement.getAge());
        }
    }
}
