package domain;

import domain.player.Name;
import domain.result.Prize;
import java.util.Objects;

public class MatchingResult {
    private final Name name;
    private final Prize prize;

    public MatchingResult(Name name, Prize prize) {
        this.name = name;
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
        MatchingResult that = (MatchingResult) o;
        return Objects.equals(name, that.name) && Objects.equals(prize, that.prize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, prize);
    }

    public String getName() {
        return name.getName();
    }

    public String getPrize() {
        return prize.getPrizeName();
    }
}
