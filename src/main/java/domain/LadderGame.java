package domain;

import util.Generator;
import util.LadderBuilder;
import util.RandomGenerator;

import java.util.List;

public class LadderGame {
    private final Ladder ladder;
    private final Players players;
    private final Generator generator;

    public LadderGame(Players players, Height height) {
        this.ladder = new Ladder(height);
        this.players = players;
        this.generator = new RandomGenerator();

        this.ladder.init(players.getPersonCount(), this.generator);
    }

    LadderGame(List<String> names, Height height, Generator generator) {
        this.ladder = new Ladder(height);
        this.players = new Players(names);
        this.generator = generator;

        this.ladder.init(names.size(), this.generator);
    }

    public List<String> getLadderShape() {
        return LadderBuilder.getResult(players, ladder);
    }
}
