package laddergame.domain;

import java.util.Optional;

public class Ladder {
    private static final String LADDER_LINES_NULL_EXCEPTION = "Lines는 null이 될 수 없습니다.";

    private final Lines lines;

    public Ladder(final Lines inputLines) {
        this.lines = Optional.ofNullable(inputLines)
                .orElseThrow(() -> new IllegalArgumentException(LADDER_LINES_NULL_EXCEPTION));
    }

    public Lines getLines() {
        return lines;
    }
}
