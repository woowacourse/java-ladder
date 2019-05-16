package ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final int width;
    private final List<Level> levels = new ArrayList<>();

    public Ladder(int width, int height, Possible possibility) {
        if (width < 1 || height < 1) {
            throw new IllegalArgumentException();
        }
        this.width = width;
        for (int i = 0; i < height; i++) {
            levels.add(new Level(width - 1, possibility));
        }
    }

    public List<Player> apply(List<Player> players) {
        final List<Integer> mappingTable = processMappingTable();
        final List<String> rewards = players.stream().map(x -> x.getReward()).collect(Collectors.toList());
        return Collections.unmodifiableList(new ArrayList<Player>() {{
            for (int i = 0; i < players.size(); i++) {
                add(new Player(players.get(i).getName(), rewards.get(mappingTable.indexOf(i))));
            }
        }});
    }

    private List<Integer> processMappingTable() {
        List<Integer> table = IntStream.rangeClosed(0, width).boxed().collect(Collectors.toList());
        levels.forEach(level -> {
            level.getLines().forEach(line -> {
                Collections.swap(table, line, line + 1);
            });
        });
        return Collections.unmodifiableList(table);
    }

    public int getWidth() {
        return width;
    }

    public List<Level> getLevels() {
        return levels;
    }
}