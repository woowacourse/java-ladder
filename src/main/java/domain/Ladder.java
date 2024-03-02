package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;


public class Ladder {

    private final List<Row> rows;

    public Ladder(final int width, final int height) {
        validationSize(width, height);

        LadderStrategy strategy = new RandomLadderStrategy();
        this.rows = IntStream.range(0, height)
                .mapToObj(i -> new Row(width))
                .toList();
    }

    public Map<Integer, Integer> getAllMatch() {
        Map<Integer, Integer> playerResult = new HashMap<>();

        final int width = rows.get(0).getRow().size();
        for (int index = 0; index < width; ++index) {
            int result = match(index);
            playerResult.put(index, result);
        }

        return playerResult;
    }

    public List<Row> getRows() {
        return rows;
    }

    private int match(int index) {
        validationIndex(index);

        int position = index;
        for (Row row : rows) {
            position = row.goDown(position);
        }
        return position;
    }

    private void validationSize(final int width, final int height) {
        if (width < 1 || height < 1) {
            throw new IllegalArgumentException("가로 및 높이는 1 이상이어야 한다.");
        }
    }

    private void validationIndex(final int index) {
        if (index >= rows.size() || index < 0) {
            throw new IllegalArgumentException("위치는 0 이상 가로 길이 미만 이어야 한다.");
        }
    }
}
