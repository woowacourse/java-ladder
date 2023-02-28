package domain;

import java.util.Objects;

public class LadderResult {

    private final String personName;
    private final String prize;

    public LadderResult(Person person, String prize) {
        this.personName = person.getName();
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
        return Objects.equals(personName, that.personName) && Objects.equals(prize,
            that.prize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personName, prize);
    }

    public String getPersonName() {
        return personName;
    }

    public String getPrize() {
        return prize;
    }
}
