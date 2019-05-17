package ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Level> levels = new ArrayList<>();
    private final List<Integer> mappingTable;

    public Ladder(int width, int height, Possible possibility) {
        if (width < 1 || height < 1) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < height; i++) {
            levels.add(new Level(width - 1, possibility));
        }
        mappingTable = processMappingTable(width - 1);
    }

    public List<Player> apply(List<Player> players) {
        if (players.size() != getWidth()) {
            throw new IllegalArgumentException();
        }
        final List<String> rewards = players.stream().map(x -> x.getReward()).collect(Collectors.toList());
        final List<Player> result = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            result.add(new Player(players.get(i).getName(), rewards.get(mappingTable.indexOf(i))));
        }
        return Collections.unmodifiableList(result);
    }

    private List<Integer> processMappingTable(int width) {
        List<Integer> table = IntStream.rangeClosed(0, width).boxed().collect(Collectors.toList());
        levels.forEach(level -> level.getVerticalLines().forEach(line -> Collections.swap(table, line, line + 1)));
        return Collections.unmodifiableList(table);
    }

    public int getWidth() {
        return mappingTable.size();
    }

    public List<Level> getLevels() {
        return levels;
    }
}