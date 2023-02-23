package laddergame.domain.ladder;

import java.util.List;
import laddergame.domain.generator.RandomStepPointGenerator;
import laddergame.domain.ladder.line.Line;
import laddergame.domain.ladder.line.LineWidth;
import laddergame.domain.util.ExceptionMessageFormatter;
import laddergame.domain.util.IndexValidator;

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
            String message = String.format("결과의 개수와 라인의 폭(%d)은 일치해야 합니다.", linesWidth);
            throw new IllegalArgumentException(ExceptionMessageFormatter.format(message, resultsCount));
        }
    }

    public String findResultByStartIndex(int startIndex) {
        IndexValidator.validateBounds(startIndex, lines.width(), "출발 위치가 사다리 폭보다 큽니다.");
        int destinationIndex = lines.findDestinationIndex(startIndex);
        return destination.get(destinationIndex);
    }

    public List<Line> toLines() {
        return lines.toLines();
    }

    public List<String> toResults() {
        return destination.results();
    }
}
