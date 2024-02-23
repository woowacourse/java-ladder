package domain;

import java.util.List;
import java.util.stream.IntStream;


public class Ladder {
    private static final int MIN_HEIGHT = 1;
    private static final int MAX_HEIGHT = 10;

    private final List<Line> lines;

    public Ladder(final int width, final int height) {
        validateHeight(height);
        lines = generateLadder(width, height);
    }

    public List<Line> generateLadder(final int width, final int height) {
        return IntStream.range(0, height)
                .mapToObj(ignore -> new Line(width))
                .toList();
    }

    public List<Line> getLines() {
        return lines;
    }

    private void validateHeight(final int height) {
        String errorMessage = String.format("높이는 %d 이상 %d 이하로 입력해 주세요.", MIN_HEIGHT, MAX_HEIGHT);
        if (MIN_HEIGHT > height || height > MAX_HEIGHT) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
