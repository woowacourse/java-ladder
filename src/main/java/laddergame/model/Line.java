package laddergame.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    static final Random random = new Random();
    private final List<Boolean> line;

    public Line(List<Boolean> line) {
        for (int i = 0; i < line.size() - 1; i++) {
            if (line.get(i) && line.get(i + 1)) {
                throw new IllegalArgumentException("[ERROR]");
            }
        }
        this.line = line;
    }

    public Line(int personCount) {
        this(getBooleans(personCount));
    }

    private static List<Boolean> getBooleans(int personCount) {
        List<Boolean> line = new ArrayList<>();

        for (int i = 0; i < personCount - 1; i++) {
            line.add(random.nextBoolean());
        }
        return line;
    }

    public int getSize() {
        return line.size();
    }
}
