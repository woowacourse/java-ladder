package model;

import java.util.ArrayList;
import java.util.List;
import model.strategy.RandomBuildStrategy;

public class Ladder {
    private final List<Line> lines;

    protected Ladder(final List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(final Height height, final int width) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height.value(); i++) {
            lines.add(new Line(width, new RandomBuildStrategy()));
        }
        return new Ladder(lines);
    }

    public int size() {
        return lines.size();
    }

    public List<String> getFormattedLines() {
        List<String> result = new ArrayList<>();
        for (Line line : lines) {
            result.add(formatLine(line));
        }
        return result;
    }

    private String formatLine(final Line line) {
        StringBuilder lineBuilder = new StringBuilder();
        lineBuilder.append("|");
        for (int index = 0; index < line.size(); index++) {
            lineBuilder.append(line.getLadderStatus(index).getLadderForm());
        }
        return lineBuilder.toString();
    }

    public LadderResult findResult(final Players players, final Result prizes) {
        final int ladderSize = players.size() - 1;
        List<String> prizeResult = new ArrayList<>();
        List<Prize> result = prizes.getPrizes();

        for (int index = 0; index < players.size(); index++) {
            prizeResult.add(result.get(findLadderBottomIndex(index, ladderSize)).value());
        }
        return LadderResult.of(players.getNames(), prizeResult);
    }

    private int findLadderBottomIndex(int index, final int ladderWidthSize) {
        for (Line line : lines) {
            index = move(index, ladderWidthSize, line);
        }
        return index;
    }

    private int move(final int index, final int ladderWidthSize, final Line line) {
        if (canMoveLeft(index, line)) {
            return index - 1;
        } else if (canMoveRight(index, ladderWidthSize, line)) {
            return index + 1;
        }
        return index;
    }

    private boolean canMoveRight(final int index, final int ladderWidthSize, final Line line) {
        return index < ladderWidthSize && line.isConnected(index);
    }

    private boolean canMoveLeft(final int index, final Line line) {
        return 0 < index && line.isConnected(index - 1);
    }
}
