package model.ladder;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.IntStream;
import model.line.Line;

public class LadderResult {

    private static final int RESULT_OFFSET = 1;
    private final List<Integer> values;

    private LadderResult(List<Integer> values) {
        this.values = List.copyOf(values);
    }

    public static LadderResult from(Ladder ladder) {
        List<Integer> result = initialize(ladder);
        List<Line> lines = ladder.getLines();
        lines.forEach(line -> result.replaceAll(line::cross));
        return new LadderResult(result);
    }

    private static List<Integer> initialize(Ladder ladder) {
        int resultSize = ladder.width() + RESULT_OFFSET;
        return IntStream.range(0, resultSize)
            .boxed()
            .collect(toList());
    }

    public int findValue(int index) {
        return values.get(index);
    }

    public int size() {
        return values.size();
    }
}
