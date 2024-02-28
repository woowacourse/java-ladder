package domain;

import util.Generator;
import util.LadderSequence;
import util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private final Ladder ladder;
    private final Players players;
    private final Winnings winnings;
    private final Generator generator;

    public LadderGame(Players players, Winnings winnings, Height height) {
        this.players = players;
        this.winnings = winnings;
        this.ladder = new Ladder(height);
        this.generator = new RandomGenerator();

        this.ladder.init(players.getPersonCount(), this.generator);
    }

    LadderGame(Players players, Winnings winnings, Height height, Generator generator) {
        this.players = players;
        this.winnings = winnings;
        this.ladder = new Ladder(height);
        this.generator = generator;

        this.ladder.init(players.getPersonCount(), this.generator);
    }

    public List<String> getResult() {
        return LadderSequence.of(players, ladder, winnings);
    }
}
