package domain;

import static util.Connection.CONNECTED;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import util.Connection;
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

    public List<String> getLadderSequence() {
        return LadderSequence.of(players, ladder, winnings);
    }

    public Map<Name, Name> getResult() {
        List<Name> climbers = new ArrayList<>(this.players.getNames());
        ladder.getLines()
                .forEach(line -> climb(climbers, line));
        Map<Name, Name> result = new HashMap<>();
        for (int i = 0; i < climbers.size(); ++i) {
            result.put(climbers.get(i), winnings.getWinnings().get(i));
        }
        return result;
    }

    private void climb(List<Name> climbers, Line line) {
        List<Connection> connections = line.getConnections();
        IntStream.range(0, connections.size())
                .filter(index -> connections.get(index) == CONNECTED)
                .forEach(index -> Collections.swap(climbers, index - 1, index));
    }
}
