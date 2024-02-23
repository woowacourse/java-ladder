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
            lineBuilder.append(getElement(line.hasStep(index)));
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
}
