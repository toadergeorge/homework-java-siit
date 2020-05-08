package homework.tema7.voting.entity;

import homework.tema7.voting.repository.PersonRepository;
import lombok.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@ToString
@EqualsAndHashCode
public class VotingPool {
    private Map<String, Integer> votesScore = new HashMap<String, Integer>();
    private Map<String, String> votingHistory = new HashMap<String, String>();

    public VotingPool() {
        intitCanditates();
    }

    private void intitCanditates() {

        PersonRepository personRepository = new PersonRepository();
        List<Person> candidates = personRepository.getAll();

        candidates.forEach((person) -> {
            votesScore.put(person.getCnp(), 0);
        });
    }
}
