package ladder.domain;

import java.util.List;
import ladder.util.ExceptionMessageFormatter;

public class Ladder {

    private final LadderLines lines;
    private final Destination destination;

    private Ladder(LadderLines lines, Destination destination) {
        this.lines = lines;
        this.destination = destination;
    }

    public static Ladder of(LineWidth width, LadderHeight height, List<String> results) {
        validateResults(width.get(), results.size());
        LadderLines ladderLines = LadderLines.of(new RandomStepPointGenerator(), width, height);
        Destination destination = new Destination(results);
        return new Ladder(ladderLines, destination);
    }

    private static void validateResults(int linesWidth, int resultsCount) {
        if (linesWidth != resultsCount) {
            throw new IllegalArgumentException(
                    ExceptionMessageFormatter.format("결과의 개수와 라인의 폭(" + linesWidth + ")은 일치해야 합니다.",
                            linesWidth)
            );
        }
    }

    public List<Line> toUnModifiableLines() {
        return lines.toLines();
    }
}
