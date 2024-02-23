package view;

import java.util.List;
import model.LadderElement;
import model.Line;

public class Formatter {

    private Formatter() {
    }

    public static String formatPlayers(List<String> names) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%s ", names.get(0)));
        for (String name : names.subList(1, names.size() - 1)) {
            stringBuilder.append(String.format("%6s", name));
        }
        String lastPlayer = names.get(names.size() - 1);
        stringBuilder.append(String.format("%5s", lastPlayer));
        return stringBuilder.toString();
    }

    public static String formatLadder(int paddingSize, List<Line> lines) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Line line : lines) {
            stringBuilder.append(" ".repeat(paddingSize));
            stringBuilder.append(formatLine(line));
            stringBuilder.append("%n");
        }
        return stringBuilder.toString();
    }

    private static String formatLine(Line line) {
        StringBuilder lineBuilder = new StringBuilder();
        lineBuilder.append(LadderElement.COLUMN.getSymbol());
        for (int index = 0; index < line.size(); index++) {
            lineBuilder.append(getElement(line.hasStep(index)));
            lineBuilder.append(LadderElement.COLUMN.getSymbol());
        }
        return lineBuilder.toString();
    }

    private static String getElement(boolean hasBridge) {
        if (hasBridge) {
            return LadderElement.ROW.getSymbol();
        }
        return LadderElement.EMPTY.getSymbol();
    }
}
