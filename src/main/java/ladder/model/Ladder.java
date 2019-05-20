package ladder.model;

import ladder.model.coin.Coin;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Level> levels;
    private final List<Integer> mappingTable;

    public Ladder(int width, int height, Coin possibility) {
        if (width < 1 || height < 1) {
            throw new IllegalArgumentException();
        }
        this.levels = Collections.unmodifiableList(
                IntStream.range(0, height).boxed()
                        .map(i -> new Level(width - 1, possibility))
                        .collect(Collectors.toList())
        );
        this.mappingTable = processMappingTable(width);
    }

    private List<Integer> processMappingTable(int width) {
        final List<Integer> table = IntStream.range(0, width).boxed()
                                            .collect(Collectors.toList());
        levels.forEach(level -> level.getLines()
                .forEach(line -> Collections.swap(table, line, line + 1)));
        return Collections.unmodifiableList(table);
    }

    public Rewards apply(Players players, Rewards rewards) {
        if (players.number() != getWidth() || players.number() != rewards.number()) {
            throw new IllegalArgumentException();
        }
        return new Rewards(
            players,
            IntStream.range(0, rewards.number()).boxed()
                    .map(i -> rewards.get(mappingTable.indexOf(i)))
                    .collect(Collectors.toList())
        );
    }

    public List<Level> getLevels() {
        return levels;
    }

    public int getWidth() {
        return mappingTable.size();
    }
}