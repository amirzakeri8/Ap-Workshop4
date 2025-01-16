# Voting System

This simple Java project implements a basic voting system where users can create voting sessions, cast their votes, and view the results. The project consists of the following classes:

## Person Class

The `Person` class represents a voter and has the following attributes and methods:

- `firstName`: The first name of the person.
- `lastName`: The last name of the person.
- `Person(String firstName, String lastName)`: Constructor to initialize a person with the provided first and last names.
- `getFirstName()`: Method to get the first name of the person.
- `getLastName()`: Method to get the last name of the person.
- `toString()`: Method to return the full name of the person.

## Vote Class

The `Vote` class represents a vote cast by a person and includes the following:

- `voter`: A `Person` object representing the voter.
- `date`: A string representing the date of the vote.
- `Vote(Person voter, String date)`: Constructor to initialize a vote with the specified voter and date.
- `equals(Object o)`: Method to check if two votes are equal.
- `hashCode()`: Method to generate a hash code for the vote.
- `getVoter()`: Method to get the voter.
- `getDate()`: Method to get the date of the vote.

## Voting Class

The `Voting` class implements a single voting session and provides methods for managing the session, casting votes, and viewing results. It includes the following features:

- A question to be voted on.
- A map of choices (options) with associated votes.
- Support for anonymous voting.
- Methods to create choices, cast votes, print results, and more.

## VotingSystem Class

The `VotingSystem` class acts as a controller for managing multiple voting sessions. It allows users to create new voting sessions, cast votes, and view results. Key features include:

- Creation of voting sessions with multiple choices.
- Casting votes by users.
- Randomized voting for testing purposes.
- Printing results, voters, and voting details.

## Usage

To use the voting system:

1. Create a `VotingSystem` object.
2. Create voting sessions using the `createVoting` method.
3. Cast votes using the `vote` method.
4. View results using the `printResults`, `printVoters`, and `printVoting` methods.

## Example

```java
public class Main {
    public static void main(String[] args) {
        // Usage example
        VotingSystem votingSystem = new VotingSystem();
        votingSystem.createVoting("Favorite Color", false, 1, new ArrayList<>(Arrays.asList("Red", "Blue", "Green")));
        
        // Cast vote
        Person person1 = new Person("testPerson", "LTestPerson");
        votingSystem.vote(0, person1);
        
        // Print results
        votingSystem.printResults(0);
    }
}
