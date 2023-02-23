package domain;

import java.util.Objects;

public class LadderResult {

    private final Person person;
    private final String prize;

    public LadderResult(Person person, String prize) {
        this.person = person;
        this.prize = prize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LadderResult that = (LadderResult) o;
        return Objects.equals(person, that.person) && Objects.equals(prize,
            that.prize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, prize);
    }
}
