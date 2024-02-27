package model;

import java.util.ArrayList;
import java.util.List;
import model.strategy.RandomBuildStrategy;

public class Ladder {
    private final List<Line> lines;

    protected Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(Height height, int width) {
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

    private String formatLine(Line line) {
        StringBuilder lineBuilder = new StringBuilder();
        lineBuilder.append("|");
        for (int index = 0; index < line.size(); index++) {
            lineBuilder.append(line.getLadderStatus(index).getLadderForm());
            lineBuilder.append("|");
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


    //TODO: 코드명 수정
    private int findLadderBottomIndex(int index, final int ladderWidthSize) {
        for (Line line : lines) {
            index = move(index, ladderWidthSize, line);
        }
        return index;
    }

    private int move(int index, final int ladderWidthSize, final Line line) {
        if (0 == index && line.isConnected(index)) {
            index++;
        } else if (isMiddle(index, ladderWidthSize) && line.isConnected(index)) {
            index++;
        } else if (isMiddle(index, ladderWidthSize) && line.isConnected(index - 1)) {
            index--;
        } else if (index == ladderWidthSize && line.isConnected(index - 1)) {
            index--;
        }
        return index;
    }

    private boolean isMiddle(final int index, final int ladderWidthSize) {
        return 0 < index && index < ladderWidthSize;
    }
}
