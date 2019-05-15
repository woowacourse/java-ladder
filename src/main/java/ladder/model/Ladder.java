package ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private int width;
    private final List<Level> levels = new ArrayList<>();

    public Ladder(int width, int height) {
        this.width = width;
        for (int i = 0; i < height; i++) {
            levels.add(new Level(width - 1));
        }
    }

    public void apply(List<Person> people) {
        levels.forEach(level -> {
            level.getLines().forEach(line -> {
                Collections.swap(people, line, line + 1);
            });
        });
    }

    public List<Level> getLevels() {
        return levels;
    }
}