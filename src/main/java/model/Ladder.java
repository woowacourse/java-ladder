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
        for (int i = 0; i < height.getValue(); i++) {
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
        lineBuilder.append(LadderElement.COLUMN.getSymbol());
        for (int index = 0; index < line.size(); index++) {
            lineBuilder.append(getElement(line.isConnected(index)));
            lineBuilder.append(LadderElement.COLUMN.getSymbol());
        }
        return lineBuilder.toString();
    }

    private String getElement(boolean hasBridge) {
        if (hasBridge) {
            return LadderElement.ROW.getSymbol();
        }
        return LadderElement.EMPTY.getSymbol();
    }

    // tODO: players는 일급 컬렉션, result는 collections 형태임. 불일치 수정 필요
    public LadderResult findResult(final Players players, final List<Prize> result) {

        final int ladderSize = players.size() - 1;
        List<String> prizeResult = new ArrayList<>();

        for (int index = 0; index < players.size(); index++) {
            prizeResult.add(result.get(findLadderBottomIndex(index, ladderSize)).getValue());
        }
        return LadderResult.of(players.getNames(), prizeResult);
    }


    //TODO: 코드 전체적으로 수정
    private int findLadderBottomIndex(int index, final int ladderWidthSize) {
        for (Line line : lines) {
            if (0 == index) {
                if (line.isConnected(index)) {
                    index++;
                }
            } else if (0 < index && index < ladderWidthSize) {
                if (line.isConnected(index)) {
                    index++;
                } else if (line.isConnected(index - 1)) {
                    index--;
                }
            } else if (index == ladderWidthSize) {
                if (line.isConnected(index - 1)) {
                    index--;
                }
            }
        }
        return index;
    }
}
