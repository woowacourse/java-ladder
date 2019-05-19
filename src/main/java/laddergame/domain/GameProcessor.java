package laddergame.domain;

import java.util.Collections;
import java.util.List;

public class GameProcessor {
    private List<Player> players;

    public GameProcessor(List<Player> inputs) {
        this.players = inputs;
    }

    public List<Player> processGame(List<Line> ladder) {

        for (int i = 0; i < ladder.size(); i++) {
            switchPosition(ladder.get(i));
        }
        return players;
    }

    private void switchPosition(Line line) {
        for (int i = 0; i < line.getWidth(); i++) {
            swap(line, i);
        }
    }

    private void swap(Line line, int position) {
        if (line.getHandle(position)) {
            Collections.swap(players, position, position + 1);
        }
    }
}
