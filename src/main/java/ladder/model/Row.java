package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private static final int LINE = 1;
    private static final int MAX_BOUNDARY = 2;
    private static final String VERTICAL_LINE = "|";
    private static final String LINKED_LINE = "-----";
    private static final String NONE_LINKED_LINE = "     ";
    private static final String DOUBLE_BLANK = "  ";

    private List<Boolean> lines;

    public Row(int countOfMember) {
        lines = new ArrayList<>();

        lines.add(booleanGenerator(randomValueGenerator(), false));

        for (int i = 1; i < countOfMember - 1; i++) {
            lines.add(booleanGenerator(randomValueGenerator(), lines.get(i - 1)));
        }
    }

    private boolean booleanGenerator(int random, boolean prevStatus) {
        return !prevStatus && random == LINE;
    }

    private int randomValueGenerator() {
        return (int) (Math.random() * MAX_BOUNDARY);
    }

    public int getLineSize() {
        return lines.size();
    }

    public boolean checkDoubleDraw() {
        for (int i = 0; i < lines.size() - 1; i++) {
            if (lines.get(i) && lines.get(i + 1)) {
                return true;
            }
        }
        return false;
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
