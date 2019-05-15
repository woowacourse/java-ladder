package ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final int width;
    private final List<Level> levels = new ArrayList<>();
    private final List<Integer> mappingTable;

    public Ladder(int width, int height, Possible possibility) {
        if (width < 1 || height < 1) {
            throw new IllegalArgumentException();
        }
        this.width = width;
        for (int i = 0; i < height; i++) {
            levels.add(new Level(width - 1, possibility));
        }
        mappingTable = processMappingTable();
    }

    private List<Integer> processMappingTable() {
        List<Integer> table = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            table.add(i);
        }
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

    public List<String> apply(List<String> rewards) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < rewards.size(); i++) {
            result.add(rewards.get(mappingTable.indexOf(i)));
        }
        return result;
    }
}