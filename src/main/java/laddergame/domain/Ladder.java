package laddergame.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Ladder {
    private final Width width;
    private final Height height;

    private List<Line> lines;

    public Ladder(final Width width, final Height height, final List<Line> lines) {
        if (Objects.isNull(width)) {
            throw new IllegalArgumentException("너비는 null이 될 수 없습니다.");
        }
        if (Objects.isNull(height)) {
            throw new IllegalArgumentException("높이는 null이 될 수 없습니다.");
        }
        this.width = width;
        this.height = height;
        this.lines = lines;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
