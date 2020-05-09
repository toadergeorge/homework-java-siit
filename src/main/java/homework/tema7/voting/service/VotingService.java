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
            try {
                voting = voteCandidate(candidatesList, votingPool, scanner, voting);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        votingPool.getVotesScore().forEach((candidateCnp, totalVotes) -> {
            System.out.println("Candidatul cu cnp " + candidateCnp + " are " + totalVotes);
        });

        votingPool.getVotingHistory().forEach((personCnp, candidateName) -> {
            System.out.println("Persoana cu cnp " + personCnp + " a votat cu " + candidateName);
        });
    }

    public static boolean voteCandidate(List<Person> candidatesList, VotingPool votingPool, Scanner scanner, boolean voting) throws Exception {
        System.out.println("Votati candidatul : (introduceti CNP urmat de '+' si  NUME CANDIDAT)");
        System.out.println("Pentru a opri votul si afisare rezultate tastati tasta 0 urmata de enter!");
        String vote = scanner.nextLine();

        if (vote.equals("0")) {
            return false;
        }

        String[] voteInfo = vote.split("\\+");

        if (voteInfo.length == 2) {
            try {
                addVote(candidatesList, votingPool, voteInfo);
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }

        } else {
            throw new Exception("Combinatia CPN + NUME nu este corecta!");
        }

        return voting;
    }

    public static void addVote(List<Person> candidatesList, VotingPool votingPool, String[] voteInfo) throws Exception {
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
                throw new Exception("Candidatul ales nu exista! Va rugam incercati din nou!");
            } else {
                votingPool.getVotesScore().put(candidateCnp, votingPool.getVotesScore().get(candidateCnp) + 1);
            }
        } else {
            throw new Exception("Acest user a votata deja!");
        }
    }
}
