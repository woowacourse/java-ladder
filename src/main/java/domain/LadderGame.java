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
    private final PlayerNames playerNames;
    private final WinningNames winningNames;
    private final Generator generator;

    public LadderGame(PlayerNames playerNames, WinningNames winningNames, Height height) {
        this.playerNames = playerNames;
        this.winningNames = winningNames;
        this.ladder = new Ladder(height);
        this.generator = new RandomGenerator();

        this.ladder.init(playerNames.getPersonCount(), this.generator);
    }

    LadderGame(PlayerNames playerNames, WinningNames winningNames, Height height, Generator generator) {
        this.playerNames = playerNames;
        this.winningNames = winningNames;
        this.ladder = new Ladder(height);
        this.generator = generator;

        this.ladder.init(playerNames.getPersonCount(), this.generator);
    }

    public List<String> getLadderSequence() {
        return LadderSequence.of(playerNames, ladder, winningNames);
    }

    public Map<String, String> getResult() {
        List<Name> climbers = new ArrayList<>(this.playerNames.getNames());
        ladder.getLines()
                .forEach(line -> climb(climbers, line));
        Map<String, String> result = new HashMap<>();
        IntStream.range(0, climbers.size())
                .forEach(index -> result.put(
                        climbers.get(index).getName(),
                        winningNames.getNames().get(index).getName()
                ));
        return result;
    }

    private void climb(List<Name> climbers, Line line) {
        List<Connection> connections = line.getConnections();
        IntStream.range(0, connections.size())
                .filter(index -> connections.get(index) == CONNECTED)
                .forEach(index -> Collections.swap(climbers, index - 1, index));
    }
}
