package laddergame.domain;

import java.util.Collections;
import java.util.List;

public class LadderGameProcessor {
    private List<Player> players;

    public LadderGameProcessor(List<Player> inputs) {
        this.players = inputs;

    }

    public List<Player> switchPosition(List<Boolean> instructions) {
        for (int i = 0; i < instructions.size(); i++) {
            if (instructions.get(i)) {
                Collections.swap(players, i, i+1);
            }
        }

        return players;
    }
}
