package homework.tema7.voting.service;

import homework.tema7.voting.entity.Person;
import homework.tema7.voting.entity.VotingPool;
import homework.tema7.voting.repository.PersonRepository;

import java.util.List;
import java.util.Scanner;

public class VotingService {
    public static void main(String[] args) {

        PersonRepository personRepository = new PersonRepository();
        List<Person> candidatesList = personRepository.getAll();
        VotingPool votingPool = new VotingPool();

        Scanner scanner = new Scanner(System.in);

        boolean voting = true;
        while (voting) {
            voting = voteCandidate(candidatesList, votingPool, scanner, voting);
        }

        votingPool.getVotesScore().forEach((candidateCnp, totalVotes) -> {
            System.out.println("Candidatul cu cnp " + candidateCnp + " are " + totalVotes);
        });

        votingPool.getVotingHistory().forEach((personCnp, candidateName) -> {
            System.out.println("Persoana cu cnp " + personCnp + " a votat cu " + candidateName);
        });
    }

    private static boolean voteCandidate(List<Person> candidatesList, VotingPool votingPool, Scanner scanner, boolean voting) {
        System.out.println("Votati candidatul : (introduceti CNP spatiu NUME CANDIDAT)");
        System.out.println("Pentru a opri votul si afisare rezultate tastati tasta 0 urmata de enter!");
        String vote = scanner.nextLine();

        String[] voteInfo = vote.split("\\+");

        if (voteInfo.length == 2) {
            addVote(candidatesList, votingPool, voteInfo);
        } else {
            System.out.println("Combinatia CPN + NUME nu este corecta!");
        }

        if (vote.equals("0")) {
            voting = false;
        }
        return voting;
    }

    private static void addVote(List<Person> candidatesList, VotingPool votingPool, String[] voteInfo) {
        if (!votingPool.getVotingHistory().containsKey(voteInfo[0])) {

            String candidateCnp = "";

            for (Person candidate : candidatesList) {

                String fullCandidateName = candidate.getFirstName() + " " + candidate.getLastName();

                if (fullCandidateName.equals(voteInfo[1].trim())) {
                    votingPool.getVotingHistory().put(voteInfo[0], voteInfo[1]);
                    candidateCnp = candidate.getCnp();
                    break;
                }
            }

            if (candidateCnp.equals("")) {
                System.out.println("Candidatul ales nu exista! Va rugam incercati din nou!");
            } else {
                votingPool.getVotesScore().put(candidateCnp, votingPool.getVotesScore().get(candidateCnp) + 1);
            }
        } else {
            System.out.println("Acest user a votata deja!");
        }
    }
}
