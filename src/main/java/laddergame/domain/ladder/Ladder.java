package laddergame.domain.ladder;

import java.util.List;
import java.util.stream.Collectors;
import laddergame.domain.generator.RandomStepPointGenerator;
import laddergame.domain.ladder.destination.Destination;
import laddergame.domain.ladder.destination.Item;
import laddergame.domain.ladder.line.Line;
import laddergame.domain.ladder.line.LineWidth;
import laddergame.util.ExceptionMessageFormatter;
import laddergame.util.IndexValidator;

public class Ladder {

    private final LadderLines lines;
    private final Destination destination;

    private Ladder(LadderLines lines, Destination destination) {
        this.lines = lines;
        this.destination = destination;
    }

    public static Ladder of(LineWidth width, LadderHeight height, List<Item> items) {
        validateItems(width.get(), items.size());
        LadderLines ladderLines = LadderLines.of(new RandomStepPointGenerator(), width, height);
        Destination destination = new Destination(items);
        return new Ladder(ladderLines, destination);
    }

    private static void validateItems(int linesWidth, int itemsCount) {
        if (linesWidth != itemsCount) {
            String message = String.format("결과의 개수와 라인의 폭(%d)은 일치해야 합니다.", linesWidth);
            throw new IllegalArgumentException(ExceptionMessageFormatter.format(message, itemsCount));
        }
    }

    public Item findItemsByStartIndex(int startIndex) {
        IndexValidator.validateBounds(startIndex, lines.width(), "출발 위치가 범위 밖의 수입니다.");
        int destinationIndex = lines.findDestinationIndex(startIndex);
        return destination.get(destinationIndex);
    }

    public List<Line> toLadderLines() {
        return lines.toLines();
    }

    public List<String> toDestinationItems() {
        return destination.items()
                .stream()
                .map(Item::getValue)
                .collect(Collectors.toList());
    }
}
