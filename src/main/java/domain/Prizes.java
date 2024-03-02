package domain;

import java.util.Collections;
import java.util.List;

public class Prizes {

    private final List<String> prizes;

    public Prizes(List<String> prizes) {
        this.prizes = prizes;
    }

    public String getPrizeByPosition(int position) {
        return prizes.get(position);
    }

    public List<String> getPrizes() {
        return Collections.unmodifiableList(prizes);
    }
}
