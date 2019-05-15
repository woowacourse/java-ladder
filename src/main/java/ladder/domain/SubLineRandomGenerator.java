package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public final class SubLineRandomGenerator implements SubLineGenerator {
    private final int countOfPlayers;

    public SubLineRandomGenerator(int countOfPlayers) {
        this.countOfPlayers = countOfPlayers;
    }

    @Override
    public List<Boolean> generate() {
        List<Boolean> subLines = new ArrayList<>();
        for (int i = 0; i < countOfPlayers - 1; i++) {
            subLines.add(Math.random() < 0.4);
        }
        return subLines;
    }
}
