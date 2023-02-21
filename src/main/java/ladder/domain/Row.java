package ladder.domain;

import java.util.List;

public class Row {
    private final List<Foothold> footholds;

    private Row(List<Foothold> footholds) {
        validateNoContinuousSteps(footholds);
        this.footholds = footholds;
    }

    public static Row of(List<Foothold> footholds, int expectedWidth) {
        validateWidthOf(footholds, expectedWidth);
        return new Row(footholds);
    }

    private static void validateWidthOf(List<Foothold> footholds, int expectedWidth) {
        int actualWidth = footholds.size();
        if (actualWidth != expectedWidth) {
            throw new IllegalArgumentException("사다리 너비가 맞지 않습니다.");
        }
    }

    private void validateNoContinuousSteps(List<Foothold> row) {
        int initialPosition = 0;
        int lastPosition = row.size() - 2;
        for (int position = initialPosition; position <= lastPosition; position++) {
            checkContinuousSteps(row, position);
        }
    }

    private void checkContinuousSteps(List<Foothold> footholds, int position) {
        if (isContinuousSteps(footholds, position)) {
            throw new IllegalArgumentException("가로로 연속된 발판은 만들 수 없습니다.");
        }
    }

    private boolean isContinuousSteps(List<Foothold> footholds, int position) {
        return footholds.get(position) == Foothold.Y
                && footholds.get(position + 1) == Foothold.Y;
    }

    public Position acceptPlayer(Position beforeMove) {
        int position = beforeMove.getValue();
        if (position == 0) {
            if (footholds.get(0) == Foothold.Y) {
                return new Position(1);
            }
            return new Position(0);
        }
        if (position == footholds.size()) {
            if (footholds.get(footholds.size() - 1) == Foothold.Y) {
                return new Position(position - 1);
            }
            return new Position(position);
        }
        if (footholds.get(position) == Foothold.Y) {
            return new Position(position + 1);
        }
        if (footholds.get(position - 1) == Foothold.Y) {
            return new Position(position - 1);
        }
        return new Position(position);
    }

    public List<Foothold> getFootholds() {
        return footholds;
    }
}
