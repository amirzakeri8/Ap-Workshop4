import java.time.LocalDate;
import java.util.*;

/**
 * The Voting class represents a voting session where participants can vote on a question with multiple choices.
 * It provides methods for managing the voting process, including creating choices, casting votes, and viewing results.
 */
public class Voting {
    private int type;
    private String question;
    private HashMap<String, HashSet<Vote>> choices;
    private boolean isAnonymous;
    private ArrayList<Person> voters;

    /**
     * Constructs a new Voting object with the specified type, question, and anonymity setting.
     *
     * @param type        The type of the voting session.
     * @param question    The question to be voted on.
     * @param isAnonymous Whether the voting session is anonymous or not.
     */
    public Voting(int type, String question, boolean isAnonymous) {
        this.type = type;
        this.question = question;
        this.isAnonymous = isAnonymous;
        this.choices = new HashMap<>();
        this.voters = new ArrayList<>();
    }

    /**
     * Gets the question being voted on.
     *
     * @return The question being voted on.
     */
    public String getQuestion() {
        return this.question;
    }

    /**
     * Sets the question to be voted on.
     *
     * @param question The new question to be voted on.
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * Gets the list of choices available for voting.
     *
     * @return The list of choices available for voting.
     */
    public ArrayList<String> getChoices() {
        return new ArrayList<>(choices.keySet());
    }

    /**
     * Creates a new choice for voting.
     *
     * @param choice The new choice to be added for voting.
     */
    public void createChoice(String choice) {
        this.choices.put(choice, new HashSet<>());
    }

    /**
     * Casts votes for the specified voter on the given choices.
     *
     * @param voter        The person casting the vote.
     * @param voterChoices The choices made by the voter.
     */
    public void vote(Person voter, ArrayList<String> voterChoices) {
        // Check if voter does not exist.
        if (!this.voters.contains(voter)) {
            for (String choice : voterChoices) {
                LocalDate currentDate = LocalDate.now();
                HashSet<Vote> votes = this.choices.get(choice);
                if (votes != null) {
                    // Create new Vote object and add it to votes.
                    votes.add(new Vote(voter, currentDate.toString()));
                } else {
                    System.out.println("Choice '" + choice + "' does not exist.");
                }
            }
            this.voters.add(voter);
            System.out.println("Done!");
        } else {
            System.out.println("You have already voted.");
        }
    }

    /**
     * Casts a random vote for the specified person.
     *
     * @param person The person for whom a random vote will be cast.
     */
    public void vote(Person person) {
        // Check if voter exists.
        if (this.voters.contains(person)) {
            System.out.println("You have already voted.");
            return;
        }

        // Create a random choice.
        ArrayList<String> keys = new ArrayList<>(this.choices.keySet());
        Random random = new Random();
        int randomIndex = random.nextInt(keys.size());
        String randomChoice = keys.get(randomIndex);

        // Vote to random choice.
        HashSet<Vote> vote = this.choices.get(randomChoice);
        LocalDate currentDate = LocalDate.now();
        if (vote != null) {
            vote.add(new Vote(person, currentDate.toString()));
        } else {
            System.out.println("Failed to vote.");
        }
        this.voters.add(person);
        System.out.println("Done!");
    }

    /**
     * Prints the results of the voting session.
     */
    public void printResults() {
        System.out.println("******");
        System.out.println("Results: ");
        for (Map.Entry<String, HashSet<Vote>> entry : this.choices.entrySet()) {
            String option = entry.getKey();
            int votes = entry.getValue().size();
            System.out.println(option + " with " + votes + " votes");
            System.out.println("- - - - - -");
        }
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o The object to compare.
     * @return true if this object is the same as the o argument; false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Voting voting)) return false;
        return type == voting.type && isAnonymous == voting.isAnonymous && Objects.equals(question, voting.question) && Objects.equals(choices, voting.choices) && Objects.equals(voters, voting.voters);
    }

    /**
     * Prints the voters for each choice in the voting session.
     */
    public void printVoters() {
        if (this.isAnonymous) {
            System.out.println("Voting is anonymous!");
            return;
        }

        for (String choice : this.choices.keySet()) {
            System.out.println("- - - - -");
            System.out.println("Voters for " + choice + ":");
            for (Vote vote : this.choices.get(choice)) {
                System.out.println(vote.getVoter() + " at " + vote.getDate());
            }
        }
    }

    /**
     * Prints the details of the voting session.
     */
    public void printVoting() {
        System.out.println("Question for this voting: " + this.question);
        for (String choice : this.choices.keySet()) {
            System.out.println("- - - -");
            System.out.println(choice);
        }
    }
}
