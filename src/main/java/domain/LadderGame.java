package domain;

import util.Generator;
import util.LadderBuilder;
import util.RandomGenerator;

import java.util.Collections;
import java.util.List;

public class LadderGame {
    private final Ladder ladder;
    private final Players players;
    private final Winnings winnings;
    private final Generator generator;

    public LadderGame(Players players, Height height, Winnings winnings) {
        this.ladder = new Ladder(height);
        this.players = players;
        this.generator = new RandomGenerator();
        this.winnings = winnings;
        this.ladder.init(players.getPlayers().size(), this.generator);
    }

    LadderGame(List<String> names, Height height, Winnings winnings, Generator generator) {
        this.ladder = new Ladder(height);
        this.players = new Players(names);
        this.generator = generator;
        this.winnings = winnings;
        this.ladder.init(names.size(), this.generator);
    }

    public List<String> getLadderShape() {
        return LadderBuilder.getResult(players, ladder, winnings);
    }

    public List<String> getClimbedNames() {
        List<Name> names = players.getPlayers();
        for (Line line : ladder.getLadder()) {
            climb(line, names);
        }
        return names.stream()
                .map(Name::getName)
                .toList();
    }

    private void climb(Line line, List<Name> names) {
        List<Integer> indices = line.getUnconnectedIndex();
        for (int index : indices) {
            Collections.swap(names, index, index - 1);
        }
    }
}
