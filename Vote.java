import java.util.Objects;

/**
 * The Vote class represents a vote cast by a person on a specific date.
 * It contains information about the voter and the date of the vote.
 */
public class Vote {
    private final Person voter;
    private final String date;

    /**
     * Constructs a new Vote object with the specified voter and date.
     *
     * @param voter The person who cast the vote.
     * @param date  The date when the vote was cast.
     */
    public Vote(Person voter, String date) {
        this.voter = voter;
        this.date = date;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * Two votes are considered equal if they have the same voter and date.
     *
     * @param o The object to compare.
     * @return true if this object is the same as the o argument; false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vote vote)) return false;
        return Objects.equals(voter, vote.voter) && Objects.equals(date, vote.date);
    }

    /**
     * Returns a hash code value for the vote.
     * The hash code is generated based on the voter and date.
     *
     * @return A hash code value for the vote.
     */
    @Override
    public int hashCode() {
        return Objects.hash(voter, date);
    }

    /**
     * Gets the person who cast the vote.
     *
     * @return The person who cast the vote.
     */
    public Person getVoter() {
        return this.voter;
    }

    /**
     * Gets the date when the vote was cast.
     *
     * @return The date when the vote was cast.
     */
    public String getDate() {
        return this.date;
    }
}
