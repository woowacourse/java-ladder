package laddergame.domain;

import java.util.List;
import java.util.Objects;

public class Prizes {
    private List<String> prizes;

    public Prizes(List<String> prizes) {
        this.prizes = prizes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prizes prizes = (Prizes) o;
        return Objects.equals(prizes, prizes.prizes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prizes);
    }
}
