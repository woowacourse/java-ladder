package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private static final String VERTICAL_LINE = "|";
    private static final String LINKED_LINE = "-----";
    private static final String BLANK_LINE = "     ";
    private static final String DOUBLE_BLANK = "  ";
    private static final int LINE = 1;
    private static final int MOVE = 1;
    private static final int PREV = 1;
    private static final int BACK = -1;
    private static final int DIRECT = 0;
    private List<Boolean> lines;

    public Row(List<Integer> linked) {
        lines = new ArrayList<>();
        lines.add(booleanGenerator(linked.get(0), false));

        for (int i = 1; i < linked.size() - 1; i++) {
            lines.add(booleanGenerator(linked.get(i), lines.get(i - PREV)));
        }
    }

    private boolean booleanGenerator(int random, boolean prevStatus) {
        return !prevStatus && random == LINE;
    }

    public boolean checkDoubleDraw() {
        int i = 0;
        while (i < (lines.size() - 1) && isNotContinuous(i)) {
            i++;
        }
        return i == lines.size();
    }

    private boolean isNotContinuous(int i) {
        return !(lines.get(i) && lines.get(i + 1));
    }

    public int judgeMove(int position) {
        if (position < lines.size() && lines.get(position)) {
            return MOVE;
        }
        if (position > 0 && lines.get(position - PREV)) {
            return BACK;
        }
        return DIRECT;
    }

    private String isLinked(boolean line) {
        String lineString = line ? LINKED_LINE : BLANK_LINE;
        return VERTICAL_LINE + lineString;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(DOUBLE_BLANK);
        for (Boolean line : lines) {
            sb.append(isLinked(line));
        }
        sb.append(VERTICAL_LINE);
        return sb.toString();
    }
}
