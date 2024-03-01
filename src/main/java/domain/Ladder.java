package domain;

import java.util.List;

public class Ladder {
    private static final int MAX_HEIGHT = 100;

    private final List<Line> lines;

    public Ladder(Line... line) {
        validate(List.of(line));
        lines = List.of(line);
    }

    private void validate(final List<Line> ladder) {
        validateEmptiness(ladder);
        validateMaxHeight(ladder);
        validateLadderShape(ladder);
    }

    private void validateEmptiness(final List<Line> ladder) {
        if (ladder.isEmpty()) {
            throw new IllegalArgumentException("사다리 가로 라인 길이는 1 이상이어야 합니다");
        }
    }

    private void validateLadderShape(final List<Line> ladder) {
        validateEmptiness(ladder);
        final int firstLineWidth = ladder.get(0).size();

        if (ladder.stream().anyMatch(line -> line.size() != firstLineWidth)) {
            throw new IllegalArgumentException("사다리의 가로 길이는 일정해야 합니다.");
        }
    }

    private void validateMaxHeight(final List<Line> ladder) {
        final int height = ladder.size();

        if (height > MAX_HEIGHT) {
            throw new IllegalArgumentException(String.format("입력된 값: %d, 사다리 높이는 최대 %d입니다.", height, MAX_HEIGHT));
        }
    }

    public int play(final int position) {
        Index index = new Index(position);

        for (final Line line : lines) {
            index = line.move(index);
        }

        return index.toInt();
    }

    public int height() {
        return lines.size();
    }

    public int width() {
        final Line firstLine = lines.get(0);
        return firstLine.size();
    }

    public List<Line> getLadder() {
        return lines;
    }
}
