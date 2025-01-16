import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();
        Voting voting1 = new Voting(1, "voting1Question", false);
        Voting voting2 = new Voting(1, "voting2Question", false);
        Voting voting3 = new Voting(0, "voting3Question", true);

        Person person1 = new Person("P1", "LP1");
        Person person2 = new Person("P2", "LP2");
        Person person3 = new Person("P3", "LP3");

        ArrayList<String> choices1 = new ArrayList<>();
        choices1.add("first");
        choices1.add("second");
        choices1.add("third");
        votingSystem.createVoting("voting1Question", false, 1, choices1);
        votingSystem.createVoting("voting2Question", false, 1, choices1);
        votingSystem.createVoting("voting3Question", true, 0, choices1);

        votingSystem.vote(0, person1);
        votingSystem.vote(5, person2);
        votingSystem.vote(person3);

        votingSystem.printVoting(0);
        votingSystem.printResults(0);

        votingSystem.printVoters(0);
        votingSystem.printVoters(1);
        votingSystem.printVoters(2);
    }
}
