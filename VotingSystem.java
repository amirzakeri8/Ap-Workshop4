import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

/**
 * The VotingSystem class manages multiple voting sessions and provides methods for creating new voting sessions,
 * casting votes, and viewing results.
 */
public class VotingSystem {
    private ArrayList<Voting> votingList;

    /**
     * Constructs a new VotingSystem object with an empty list of voting sessions.
     */
    public VotingSystem() {
        this.votingList = new ArrayList<>();
    }

    /**
     * Computes a hash code value for the object.
     *
     * @return A hash code value for the object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(votingList);
    }

    /**
     * Creates a new voting session with the specified question, anonymity setting, type, and choices.
     *
     * @param question    The question to be voted on.
     * @param isAnonymous Whether the voting session is anonymous or not.
     * @param type        The type of the voting session.
     * @param choices     The list of choices available for voting.
     */
    public void createVoting(String question, boolean isAnonymous, int type,
                             ArrayList<String> choices) {
        Voting voting = new Voting(type, question, isAnonymous);
        for (String choice : choices) {
            voting.createChoice(choice);
        }
        this.votingList.add(voting);
    }

    /**
     * Reads user input to create a list of choices for voting.
     *
     * @return The list of choices entered by the user.
     */
    private ArrayList<String> makeChoices() {
        ArrayList<String> choices = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your choices to vote or Q to quit: ");
        while (true) {
            String newChoice = scanner.nextLine();
            if (newChoice.equals("Q")) {
                break;
            }
            choices.add(newChoice);
        }

        return choices;
    }

    /**
     * Casts a vote for a specific voting session at the given index by the specified voter.
     *
     * @param index The index of the voting session to vote on.
     * @param voter The person casting the vote.
     */
    public void vote(int index, Person voter) {
        if (isOutOfIndex(index)) {
            System.out.println("Index is out of range!");
            return;
        }

        ArrayList<String> choices =  this.makeChoices();
        Voting voting = this.votingList.get(index);
        voting.vote(voter, choices);
    }

    /**
     * Generates a random index within the range of voting sessions.
     *
     * @return A random index within the range of voting sessions.
     */
    private int createRandomIndex() {
        Random randomIndex = new Random();
        return randomIndex.nextInt(this.votingList.size());
    }

    /**
     * Generates a random index and casts a random vote for the specified person.
     *
     * @param person The person for whom a random vote will be cast.
     */
    public void vote(Person person) {
        int randomIndex = createRandomIndex();
        Voting voting = this.votingList.get(randomIndex);
        voting.vote(person);
    }

    /**
     * Checks if the given index is out of range.
     *
     * @param index The index to check.
     * @return True if the index is out of range, false otherwise.
     */
    private boolean isOutOfIndex(int index) {
        return index >= this.votingList.size();
    }

    /**
     * Prints the results of the voting session at the specified index.
     *
     * @param index The index of the voting session to print results for.
     */
    public void printResults(int index) {
        if (isOutOfIndex(index)) {
            System.out.println("Out of index");
            return;
        }

        Voting voting = this.votingList.get(index);
        voting.printResults();
    }

    /**
     * Prints the voters for each choice in the voting session at the specified index.
     *
     * @param index The index of the voting session to print voters for.
     */
    public void printVoters(int index) {
        if (isOutOfIndex(index)) {
            System.out.println("Out of index");
            return;
        }

        Voting voting = this.votingList.get(index);
        voting.printVoters();
    }

    /**
     * Prints the details of the voting session at the specified index.
     *
     * @param index The index of the voting session to print details for.
     */
    public void printVoting(int index) {
        if (isOutOfIndex(index)) {
            System.out.println("Out of index");
            return;
        }

        Voting voting = this.votingList.get(index);
        voting.printVoting();
    }

    /**
     * Gets the voting session at the specified index.
     *
     * @param index The index of the voting session to get.
     * @return The voting session at the specified index.
     */
    public Voting getVoting(int index) {
        return this.votingList.get(index);
    }

    /**
     * Gets the list of voting sessions.
     *
     * @return The list of voting sessions.
     */
    public ArrayList<Voting> getVotingList() {
        return this.votingList;
    }
}
