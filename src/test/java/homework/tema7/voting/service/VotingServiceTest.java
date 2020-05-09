package homework.tema7.voting.service;

import homework.tema7.voting.entity.Person;
import homework.tema7.voting.entity.VotingPool;
import homework.tema7.voting.repository.PersonRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class VotingServiceTest {

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    private VotingService sut;
    private List<Person> candidatesList;
    private VotingPool votingPool;


    @Before
    public void setup() {
        this.sut = new VotingService();

        PersonRepository personRepository = new PersonRepository();
        this.candidatesList = personRepository.getAll();
        this.votingPool = new VotingPool();

        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void given_one_voter_cnp_and_candidate_name_when_add_vote_then_candidate_has_one_vote() {
        //Given
        String voterCnp = "1801213412221";
        String candidateName = "Ionescu Cristi";
        String candidateCnp = "1801213410022";
        String[] voteInfo = {voterCnp, candidateName};

        final String testVoterString = "1801213412221+Ionescu Cristi";
        provideInput(testVoterString);

        //When
        try {
            VotingService.addVote(this.candidatesList,this.votingPool,voteInfo);
        } catch (Exception e) {
            Assert.fail("Unexpected exception to be thrown!");
        }

        //Then
        int newVotesNumber = this.votingPool.getVotesScore().get(candidateCnp);
        assertThat(newVotesNumber).isEqualTo(1);
    }

    @Test
    public void given_one_voter_cnp_and_wrong_candidate_name_when_add_vote_then_error_is_given() {
        //Given
        String voterCnp = "1801213412221";
        String candidateName = "Ionescu Cristiii";
        String[] voteInfo = {voterCnp, candidateName};

        final String testVoterString = "1801213412221+Ionescu Cristi";
        provideInput(testVoterString);

        //When
        //Then
        try {
            VotingService.addVote(this.candidatesList,this.votingPool,voteInfo);
            Assert.fail("Expected exception to be thrown!");
        } catch (Exception e) {
            assertThat(e.getMessage()).isEqualTo("Candidatul ales nu exista! Va rugam incercati din nou!");
        }
    }

    @Test
    public void given_already_voter_cnp_and_candidate_name_when_add_vote_then_error_is_given() {
        //Given
        String voterCnp = "1801213412221";
        String candidateName = "Ionescu Cristi";
        String[] voteInfo = {voterCnp, candidateName};

        final String testVoterString = "1801213412221+Ionescu Cristi";
        provideInput(testVoterString);

        //When
        //Then
        try {
            VotingService.addVote(this.candidatesList,this.votingPool,voteInfo);
            VotingService.addVote(this.candidatesList,this.votingPool,voteInfo);
            Assert.fail("Expected exception to be thrown!");
        } catch (Exception e) {
            assertThat(e.getMessage()).isEqualTo("Acest user a votata deja!");
        }
    }

    @Test
    public void given_voter_input_when_vote_candidate_then_candidate_has_new_vote() {
        //Given
        String voterCnp = "1801213412221";
        String candidateName = "Ionescu Cristi";
        String candidateCnp = "1801213410022";
        String[] voteInfo = {voterCnp, candidateName};

        final String testVoterString = "1801213412221+Ionescu Cristi";
        provideInput(testVoterString);

        //When
        try {
            Scanner scanner = new Scanner(System.in);
            boolean vote = VotingService.voteCandidate(this.candidatesList, this.votingPool, scanner, true);

        } catch (Exception e) {
            Assert.fail("Expected exception to be thrown!");;
        }

        //Then
        int newVotesNumber = this.votingPool.getVotesScore().get(candidateCnp);
        assertThat(newVotesNumber).isEqualTo(1);
    }

    @Test
    public void given_voter_wrong_input_when_vote_candidate_then_exception_received() {
        //Given
        String voterCnp = "1801213412221";
        String candidateName = "Ionescu Cristi";
        String candidateCnp = "1801213410022";
        String[] voteInfo = {voterCnp, candidateName};

        final String testVoterString = "1801213412221";
        provideInput(testVoterString);

        //When
        //Then
        try {
            Scanner scanner = new Scanner(System.in);
            boolean vote = VotingService.voteCandidate(this.candidatesList, this.votingPool, scanner, true);
            Assert.fail("Expected exception to be thrown!");;
        } catch (Exception e) {
            assertThat(e.getMessage()).isEqualTo("Combinatia CPN + NUME nu este corecta!");
        }
    }

    @Test
    public void given_voter_end_of_vote_input_when_vote_candidate_then_false_received() {
        //Given
        String voterCnp = "1801213412221";
        String candidateName = "Ionescu Cristi";
        String candidateCnp = "1801213410022";
        String[] voteInfo = {voterCnp, candidateName};

        final String testVoterString = "0";
        provideInput(testVoterString);

        boolean vote=false;
        //When
        try {
            Scanner scanner = new Scanner(System.in);
            vote = VotingService.voteCandidate(this.candidatesList, this.votingPool, scanner, true);
        } catch (Exception e) {
            Assert.fail("Unexpected exception to be thrown!");;
        }

        //Then
        int newVotesNumber = this.votingPool.getVotesScore().get(candidateCnp);
        assertThat(vote).isEqualTo(false);
    }
}
