package laddergame.domain;

import java.util.List;
import java.util.Objects;

public class Prizes {
    private List<String> prizes;

    public Prizes(List<String> prizes) {
        this.prizes = prizes;
    }

    public String getPrize(int index) {
        return prizes.get(index);
    }

    public List<String> getPrizes() {
        return prizes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prizes prizes1 = (Prizes) o;
        return Objects.equals(prizes, prizes1.prizes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prizes);
    }
}
