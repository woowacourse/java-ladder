package view;

import java.util.List;
import model.ladder.Line;

public class Formatter {

    private Formatter() {
    }

    public static String formatNames(List<String> names) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(names.get(0)).append(" ");
        for (String name : names.subList(1, names.size() - 1)) {
            stringBuilder.append(getNameWithSpace(6 - name.length(), name));
        }
        String lastPlayer = names.get(names.size() - 1);
        stringBuilder.append(getNameWithSpace(5 - lastPlayer.length(), lastPlayer));
        return stringBuilder.toString();
    }

    private static String getNameWithSpace(int spaceRepeat, String name) {
        return " ".repeat(spaceRepeat) + name;
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
            lineBuilder.append(getElement(line.isConnected(index)));
            lineBuilder.append(LadderElement.COLUMN.getSymbol());
        }
        return lineBuilder.toString();
    }

    private static String getElement(boolean isConnected) {
        if (isConnected) {
            return LadderElement.ROW.getSymbol();
        }
        return LadderElement.EMPTY.getSymbol();
    }
}
