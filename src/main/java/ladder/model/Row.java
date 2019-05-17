package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private static final int LINE = 1;
    private static final String VERTICAL_LINE = "|";
    private static final String LINKED_LINE = "-----";
    private static final String NONE_LINKED_LINE = "     ";
    private static final String DOUBLE_BLANK = "  ";
    private static final int MOVE = 1;
    private static final int PREV = 1;

    private List<Boolean> lines;

    public Row(int[] linked) {
        lines = new ArrayList<>();

        lines.add(booleanGenerator(linked[0], false));

        for (int i = 1; i < linked.length; i++) {
            lines.add(booleanGenerator(linked[i], lines.get(i - PREV)));
        }
    }

    private boolean booleanGenerator(int random, boolean prevStatus) {
        return !prevStatus && random == LINE;
    }

    public boolean checkDoubleDraw() {
        int i = 0;

        while (i < lines.size() - 1 && !(lines.get(i) && lines.get(i + 1))) {
            i++;
        }

        return i == lines.size();
    }

    public int move(int position) {
        if (position < lines.size() && lines.get(position)) {
            return position + MOVE;
        }

        if (position > 0 && lines.get(position - PREV)) {
            return position - MOVE;
        }
        return position;
    }

    public int getLineSize() {
        return lines.size();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(DOUBLE_BLANK);
        for (Boolean line : lines) {
            stringBuilder.append(isLinked(line));
        }
        stringBuilder.append(VERTICAL_LINE);
        return stringBuilder.toString();
    }

    private String isLinked(boolean line) {
        if (line) {
            return VERTICAL_LINE + LINKED_LINE;
        }
        return VERTICAL_LINE + NONE_LINKED_LINE;
    }
}
