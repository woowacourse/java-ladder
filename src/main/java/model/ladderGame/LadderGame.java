package model.ladderGame;

import model.ladder.Ladder;
import model.players.Position;

public class LadderGame {
    private final Ladder ladder;

    public LadderGame(Ladder ladder) {
        this.ladder = ladder;
    }

    public int move(Position position) {
        return ladder.move(position);
    }
}

