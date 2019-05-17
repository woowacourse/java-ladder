package laddergame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderGameProcessor {
    private List<Player> players;

    public LadderGameProcessor(List<Player> inputs) {
        this.players = inputs;

    }

    public List<Player> doGame(List<List<Boolean>> instructions) {

        for (int i = 0; i < instructions.size(); i++) {
            switchPosition(instructions.get(i));
        }
        return players;
    }

    private void switchPosition(List<Boolean> line) {
        for (int i = 0; i < line.size(); i++) {
            swap(line, i);
        }
    }

    private void swap(List<Boolean> line, int position) {
        if (line.get(position)) {
            Collections.swap(players, position, position + 1);
        }
    }
}
