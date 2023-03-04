package domain;

import static java.util.List.copyOf;

import java.util.List;

public class Prizes {

    private final List<String> prizes;

    public Prizes(List<String> prizes) {
        this.prizes = copyOf(prizes);
    }

    public boolean doNotHaveSizeOf(int size) {
        return prizes.size() != size;
    }

    public String getPrizeAt(Position position) {
        return prizes.get(position.getPosition());
    }

    public List<String> getPrizes() {
        return prizes;
    }
}
