package view;

import java.util.List;
import model.LadderElement;
import model.Line;

/**
 * 1. Ladder : List<Line>을 String으로 변환 2. Players : List<String>을 String으로 변환 (공백 포함) =
 */
public class Formatter {

    private Formatter() {
    }

    public static String formatPlayers(List<String> names) {
        StringBuilder stringBuilder = new StringBuilder();
        String firstPlayer = names.get(0);

        stringBuilder.append(firstPlayer);
        stringBuilder.append(" ");

        for (String name : names.subList(1, names.size() - 1)) {
            stringBuilder.append(" ".repeat(6 - name.length()));
            stringBuilder.append(name);
        }

        String lastPlayer = names.get(names.size() - 1);

        stringBuilder.append(" ".repeat(5 - lastPlayer.length()));
        stringBuilder.append(lastPlayer);

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
            lineBuilder.append(getElement(line.hasBridge(index)));
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
