package domain;

import util.Generator;
import util.LadderString;
import util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    Ladder ladder;
    Players players;
    Generator generator;

    public LadderGame(List<String> names, int height) {
        this.ladder = new Ladder(height);
        this.players = new Players(names);
        this.generator = new RandomGenerator();

        this.ladder.init(names.size(), this.generator);
    }

    LadderGame(List<String> names, int height, Generator generator) {
        this.ladder = new Ladder(height);
        this.players = new Players(names);
        this.generator = generator;

        this.ladder.init(names.size(), this.generator);
    }

    public List<String> getResult() {
        StringBuilder nameResult = new StringBuilder();
        for (Name player : players) {
            nameResult.append("     ").append(player.getName());
        }
        List<String> results = new ArrayList<>();
        results.add(nameResult.toString());
        results.addAll(LadderString.from(ladder));
        return results;
    }
}
