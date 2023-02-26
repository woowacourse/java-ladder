package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import ladder.domain.player.Position;

/**
 * Ladder 는 Row 를 가지고 있습니다
 * <p>
 * Position 을 받아서 결과를 반환하는 역할을 가지고 있습니다
 */
public class Ladder {

    private static final String MINIMUM_SIZE_MESSAGE = "최소 가로는 2, 세로는 1이어야 합니다. 현재 가로 : %s, 세로 : %s";
    private static final int MINIMUM_WIDTH = 2;
    private static final int MINIMUM_HEIGHT = 1;
    private final List<Row> rows;
    private int check = 0;

    private Ladder(List<Row> rows) {
        this.rows = rows;
    }

    public static Ladder of(int width, int height, ConnectionJudgement connectionJudgement) {
        validateMinimumSize(width, height);
        List<Row> rows = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            rows.add(Row.valueOf(width, connectionJudgement));
        }
        return new Ladder(rows);
    }

    private static void validateMinimumSize(int width, int height) {
        if (width < MINIMUM_WIDTH || height < MINIMUM_HEIGHT) {
            throw new IllegalArgumentException(
                    String.format(MINIMUM_SIZE_MESSAGE, width, height));
        }
    }

    public List<List<Boolean>> getRows() {
        return rows.stream()
                .map(Row::getPoints)
                .collect(Collectors.toList());
    }

    public Position calculateResult(Position position) {
        Position result = position;
        for (Row row : rows) {
            result = row.calculateNextPosition(result);
        }
        return result;
    }
}
