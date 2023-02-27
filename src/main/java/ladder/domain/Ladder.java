package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Ladder 는 Row 를 가지고 있습니다
 * <p>
 * Position 을 받아서 결과를 반환하는 역할을 가지고 있습니다
 */
class Ladder {

    private static final String MINIMUM_SIZE_MESSAGE = "최소 세로는 1보다 커야 합니다 합니다. 현재 세로 : 0";
    private static final int MINIMUM_HEIGHT = 1;

    private final List<Row> rows;

    private Ladder(List<Row> rows) {
        validateMinimumHeight(rows);
        this.rows = rows;
    }

    static Ladder of(int width, int height, ConnectionJudgement connectionJudgement) {
        List<Row> rows = Stream.generate(() -> Row.valueOf(width, connectionJudgement))
                .limit(height)
                .collect(Collectors.toList());
        return new Ladder(rows);
    }

    private void validateMinimumHeight(List<Row> rows) {
        if (rows.size() < MINIMUM_HEIGHT) {
            throw new IllegalArgumentException(MINIMUM_SIZE_MESSAGE);
        }
    }

    List<List<Boolean>> getRows() {
        return rows.stream()
                .map(Row::getPoints)
                .collect(Collectors.toList());
    }

    Position calculateResult(Position position) {
        Position result = position;
        for (Row row : rows) {
            result = row.calculateNextPosition(result);
        }
        return result;
    }
}
