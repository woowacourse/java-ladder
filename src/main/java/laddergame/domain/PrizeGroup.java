package laddergame.domain;

import java.util.List;
import java.util.Objects;

public class PrizeGroup {
    private final List<Prize> prizes;

    public PrizeGroup(final List<Prize> prizes) {
        this.prizes = prizes;
    }

    public List<Prize> getPrizes() {
        return prizes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrizeGroup that = (PrizeGroup) o;
        return Objects.equals(prizes, that.prizes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prizes);
    }
}
