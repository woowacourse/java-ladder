package domain;

import java.util.List;

public class LadderRow {
    List<Boolean> lines;

    public LadderRow(List<Boolean> lines) {
        validate(lines);
        this.lines = lines;
    }

    private void validate(List<Boolean> lines) {
        boolean flag = false;
        for (int i = 0; i < lines.size() - 1; i++) {
            Boolean current = lines.get(i);
            Boolean next = lines.get(i + 1);
            if (current == next && current) {
                flag = true;
                break;
            }
        }
        if (flag) {
            throw new IllegalArgumentException();
        }
    }

    public List<Boolean> getLines() {
        return lines;
    }
}
