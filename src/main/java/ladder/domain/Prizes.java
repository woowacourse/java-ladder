package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prizes {
    private final List<String> prizes;

    public Prizes(List<String> prizes) {
        this.prizes = new ArrayList<>(prizes);
    }

    public List<String> getPrizes() {
        return Collections.unmodifiableList(prizes);
    }
}
