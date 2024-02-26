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

    public Prize findResult(final Players players, final Player target, final List<Prize> result) {
        int index = players.getNames().indexOf(target.getName());
        final int ladderSize = players.size() - 1;
        for (Line line : lines) {
            if (0 == index) {
                if (line.isConnected(index)) {
                    index++;
                }
            } else if (0 < index && index < ladderSize) {
                if (line.isConnected(index)) {
                    index++;
                } else if (line.isConnected(index - 1)) {
                    index--;
                }
            } else if (index == ladderSize) {
                if (line.isConnected(index - 1)) {
                    index--;
                }
            }
        }
        return result.get(index);
    }
}
