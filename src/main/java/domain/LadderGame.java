package domain;

import util.Connection;
import util.Generator;
import util.LadderBuilder;
import util.RandomGenerator;

import java.util.Collections;
import java.util.List;

public class LadderGame {
    private final Ladder ladder;
    private final Players players;
    private final Generator generator;

    public LadderGame(Players players, Height height) {
        this.ladder = new Ladder(height);
        this.players = players;
        this.generator = new RandomGenerator();

        this.ladder.init(players.getPlayers().size(), this.generator);
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

    public List<String> getResult() {
        List<Name> names = players.getPlayers();
        for (Line line : ladder.getLadder()) {
            climb(line, names);
        }
        return names.stream()
                .map(Name::getName)
                .toList();
    }

    private void climb(Line line, List<Name> names) {
        List<Connection> connections = line.getLine();
        for (int index = 1; index < names.size(); index++) {
            if (connections.get(index).equals(Connection.CONNECTED)) {
                Collections.swap(names, index, index - 1);
            }
        }
    }
}
