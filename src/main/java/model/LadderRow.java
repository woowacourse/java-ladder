package model;

import java.util.List;

public class LadderRow {

    private final List<Line> isLines;

    public LadderRow(List<Boolean> isLines) {
        validateLadderRow(isLines);
        this.isLines = isLines.stream().map(Line::valueOf).toList();
    }

    private void validateLadderRow(List<Boolean> isLines) {
        for (int i = 1; i < isLines.size(); i++) {
            isConsecutiveTrue(isLines, i);
        }
    }

    private void isConsecutiveTrue(List<Boolean> isLines, int index) {
        if (isLines.get(index - 1) && isLines.get(index)) {
            throw new IllegalStateException("연속된 true 값이 존재하면 안됩니다");
        }
    }

    public int move(int position) {
        if (position > 0 && isLines.get(position - 1).getConnected()) {
            return position - 1;
        }
        if (position < isLines.size() && isLines.get(position).getConnected()) {
            return position + 1;
        }
        return position;
    }

    public List<Line> getIsLines() {
        return isLines;
    }

    public int getLinesSize() {
        return isLines.size();
    }
}
