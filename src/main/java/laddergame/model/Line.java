package laddergame.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    static final Random random = new Random();
    private final List<Boolean> line;

    public Line(int personCount) {
        List<Boolean> line = new ArrayList<>();
        for (int i = 0; i < personCount - 1; i++) {
            line.add(random.nextBoolean());
        }
        this.line= line;
    }

    public int getSize() {
        return line.size();
    }
}
