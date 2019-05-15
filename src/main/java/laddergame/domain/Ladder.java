package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ladder {
    private int width;
    private int height;

    public Ladder(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public List<Line> makeLadder() {
        List<Line> lines = new ArrayList<>();
        for (int i = 0 ; i < height; i++) {
            lines.add(new Line(width));
        }
        return lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ladder)) return false;
        Ladder ladder = (Ladder) o;
        return width == ladder.width &&
                height == ladder.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }
}
