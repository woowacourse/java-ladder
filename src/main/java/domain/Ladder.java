package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import strategy.ConnectionStrategy;

public class Ladder {

    public static final int MIN_HEIGHT = 1;
    public static final int MAX_HEIGHT = 20;

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        validateHeight(lines.size());
        this.lines = lines;
    }

    private void validateHeight(int height) {
        if (height < MIN_HEIGHT || height > MAX_HEIGHT) {
            throw new IllegalArgumentException(MIN_HEIGHT + " 이상 " + MAX_HEIGHT + " 이하의 숫자를 입력해 주세요.");
        }
    }

    public static Ladder of(int memberCount, int height, ConnectionStrategy connectionStrategy) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(Line.from(memberCount, connectionStrategy));
        }
        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
