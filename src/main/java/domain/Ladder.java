package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private static final String ERROR_SAME_LINE_SIZE = "[ERROR] 다른 길이의 가로줄이 생성되었습니다";
    private static final String ERROR_LINE_SIZE_EMPTY = "[ERROR] 길이가 0인 가로줄이 생성되었습니다";

    private final List<Line> lines;

    public Ladder(final Width width, final Height height, final ScaffoldGenerator scaffoldGenerator) {
        this.lines = IntStream.range(0, height.getValue())
                .mapToObj(it -> new Line(width, scaffoldGenerator))
                .collect(Collectors.toUnmodifiableList());
        validateLines(lines);
    }

    private void validateLines(final List<Line> lines) {
        validateLineSizeEmpty(lines);
        validateLinesSameSize(lines);
    }

    private void validateLineSizeEmpty(final List<Line> lines) {
        if (lines.isEmpty()) {
            throw new IllegalArgumentException(ERROR_LINE_SIZE_EMPTY);
        }
    }

    private void validateLinesSameSize(final List<Line> lines) {
        for (int i = 0; i < lines.size() - 1; i++) {
            validateLineSameSize(lines, i);
        }
    }

    private void validateLineSameSize(final List<Line> lines, final int index) {
        if (lines.get(index).size() != lines.get(index + 1).size()) {
            throw new IllegalArgumentException(ERROR_SAME_LINE_SIZE);
        }
    }

    public Map<String, String> calculateResult(final Names names, final Prizes prizes) {
        Map<String, String> totalResult = new HashMap<>();
        for (int position = 0; position < names.size(); position++) {
            totalResult.put(names.getNameByIndex(position).getValue(), calculateSingleResult(prizes, position));
        }
        return new HashMap<>(totalResult);
    }

    private String calculateSingleResult(final Prizes prizes, final int startPosition) {
        int currentPosition = startPosition;
        for (Line line : lines) {
            List<Scaffold> scaffolds = line.getScaffolds();
            currentPosition = climbLadder(currentPosition, scaffolds);
        }
        return prizes.getPrizeByIndex(currentPosition).getValue();
    }

    private int climbLadder(int position, List<Scaffold> scaffolds) {
        if (isLeftMovable(position, scaffolds)) {
            return position - 1;
        }
        if (isRightMovable(position, scaffolds)) {
            return position + 1;
        }
        return position;
    }

    private boolean isRightMovable(int position, List<Scaffold> scaffold) {
        return position != scaffold.size() && scaffold.get(position).equals(Scaffold.EXIST);
    }

    private boolean isLeftMovable(int position, List<Scaffold> scaffold) {
        return position != 0 && scaffold.get(position - 1).equals(Scaffold.EXIST);
    }

    public int getHeight() {
        return lines.size();
    }

    public int getWidth() {
        return lines.get(0).size();
    }

    public List<Line> getLines() {
        return lines;
    }
}
