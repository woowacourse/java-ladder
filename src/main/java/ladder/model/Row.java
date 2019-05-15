package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private List<Boolean> lines;

    public Row(int countOfMember) {
        lines = new ArrayList<>();

        lines.add(booleanGenerator(randomValueGenerator(), false));

        for (int i = 1; i < countOfMember - 1; i++) {
            lines.add(booleanGenerator(randomValueGenerator(), lines.get(i - 1)));
        }
    }

    private boolean booleanGenerator(int random, boolean prevStatus) {
        return !prevStatus && random == 1;
    }

    private int randomValueGenerator() {
        return (int) (Math.random() * 2);
    }

    public int getLineSize() {
        return lines.size();
    }

    public boolean checkDoubleDraw() {
        for (int i = 0; i < lines.size() - 1; i++) {
            if (lines.get(i) && lines.get(i+1)) {
                return true;
            }
        }
        return false;
    }
}
