package homework.Tema6.Ex2;

import java.util.*;

public class HashMapExercise {
    public static void main(String[] args) {

        Person matei = Person.builder()
                .name("Matei")
                .age(18)
                .build();

        Person ion = Person.builder()
                .name("Ion")
                .age(29)
                .build();

        Person ana = Person.builder()
                .name("Ana")
                .age(42)
                .build();

        List<Address> swimAddress = new ArrayList<>();
        Address swimAddress1 = Address.builder()
                .street("Vasile Milea")
                .country("Romania")
                .build();

        Address swimAddress2 = Address.builder()
                .street("Stefan cel Mare")
                .country("Romania")
                .build();

        swimAddress.add(swimAddress1);
        swimAddress.add(swimAddress2);

        Hobby swim = Hobby.builder()
                .name("Swim")
                .frequency(5)
                .addresses(swimAddress)
                .build();

        List<Address> runningAddress = new ArrayList<>();
        Address runningAddress1 = Address.builder()
                .street("Herastrau")
                .country("Romania")
                .build();

        Address runningAddress2 = Address.builder()
                .street("Snagov")
                .country("Romania")
                .build();

        runningAddress.add(runningAddress1);
        runningAddress.add(runningAddress2);

        Hobby run = Hobby.builder()
                .name("Running")
                .frequency(4)
                .addresses(runningAddress)
                .build();

        List<Address> tennisAddress = new ArrayList<>();
        Address tennisAddress1 = Address.builder()
                .street("Expozitiei")
                .country("Romania")
                .build();

        Address tennisAddress2 = Address.builder()
                .street("1 Mai")
                .country("Romania")
                .build();

        tennisAddress.add(tennisAddress1);
        tennisAddress.add(tennisAddress2);

        Hobby tennis = Hobby.builder()
                .name("Tennis")
                .frequency(3)
                .addresses(tennisAddress)
                .build();

        List<Hobby> mateiHobbies = new ArrayList<>();
        mateiHobbies.add(run);
        mateiHobbies.add(swim);

        List<Hobby> anaHobbies = new ArrayList<>();
        anaHobbies.add(tennis);
        anaHobbies.add(swim);

        Map<Person, List<Hobby>> hmap = new HashMap<Person, List<Hobby>>();

        hmap.put(matei, mateiHobbies);
        hmap.put(ana, anaHobbies);

        Set set = hmap.entrySet();
        Iterator iterator = set.iterator();

        while (iterator.hasNext()) {
            Map.Entry me = (Map.Entry) iterator.next();
            System.out.println("Key: " + me.getKey() + " & Value: " + me.getValue());
        }
    }
}
