package laddergame.domain;

import java.util.Collections;
import java.util.List;

public class GameEngine {
    private Players players;
    private Ladder ladder;

    public GameEngine(Players players, Ladder ladder) {
        this.players = players;
        this.ladder = ladder;
    }

    public void makePlayersPlayTheLadder() {

        for (int i = 0; i < ladder.getLadderInformationAsTrueFalse().size(); i++) {
            switchPosition(ladder.getLadderInformationAsTrueFalse().get(i));
        }
        //return players;
    }

    private void switchPosition(Line line) {
        for (int i = 0; i < line.getSize(); i++) {
            swap(line, i);
        }
    }

    private void swap(Line line, int position) {
        if (line.getBooleanValue(position)) {
            Collections.swap(players.getPlayers(), position, position + 1);
        }
    }
}
