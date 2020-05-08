package homework.tema7.voting.repository;

import homework.tema7.voting.entity.Person;
import java.util.ArrayList;
import java.util.List;

public class PersonRepository {
    public final static List<Person> personDbRecords = new ArrayList<>();

    public PersonRepository(){
        addPersonToDbFixture(personDbRecords);
    }

    public List<Person> getAll() {
        return personDbRecords;
    }

    public void addPersonToDbFixture(List personList) {
        String[] firstName = {"John", "Ionescu", "Popescu", "Petrache", "Popa", "Gabi", "Nistor", "Boli", "Lupu", "Ghioane"};
        String[] lastName = {"Mircea", "Cristi", "Andrei", "Gogu", "Ionica", "Nicu", "Catalin", "Sorin", "Denis", "Marius"};
        String[] address = {"Str Tunari, nr 33", "Str Tunari, nr 33", "Str Tunari, nr 33", "Str Tunari, nr 33", "Str Tunari, nr 33", "Str Tunari, nr 33", "Str Tunari, nr 33", "Str Tunari, nr 33", "Str Tunari, nr 33", "Str Tunari, nr 33"};
        String[] cnp = {"1801213410021", "1801213410022", "1801213410023", "1801213410024", "1801213410025", "1801213410026", "1801213410027", "1801213410028", "1801213410029", "1801213410020"};
        String[] cnpSeries = {"RD", "RK", "TG", "VG", "FG", "ES", "GH", "SE", "TT", "ER"};
        int[] cnpNumber = {1233654, 2233654, 3233654, 4233654, 5233654, 6233654, 7233654, 8233654, 9233654, 0233654};

        for (int i = 0; i < 10; i++) {
            Person person = Person.builder()
                    .firstName(firstName[i])
                    .lastName(lastName[i])
                    .address(address[i])
                    .cnp(cnp[i])
                    .idSeries(cnpSeries[i])
                    .idNumber(cnpNumber[i])
                    .build();

            personDbRecords.add(person);
        }
    }
}
