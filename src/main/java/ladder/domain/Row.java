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
        return footholds.get(position) == Foothold.PASSABLE
                && footholds.get(position + 1) == Foothold.PASSABLE;
    }

    public PlayerPosition movePlayer(PlayerPosition from) {
        if (isMovableToRight(from)) {
            return from.increase();
        }
        if (isMovableToLeft(from)) {
            return from.decrease();
        }
        return from;
    }

    private boolean isMovableToRight(PlayerPosition from) {
        if (isEndOfRow(from)) {
            return false;
        }
        return isPassable(from);
    }

    private boolean isEndOfRow(PlayerPosition position) {
        return position.getValue() >= footholds.size();
    }

    private boolean isMovableToLeft(PlayerPosition from) {
        if (isBeginOfRow(from)) {
            return false;
        }
        return isPassable(from.decrease());
    }

    private boolean isBeginOfRow(PlayerPosition position) {
        return position.getValue() == 0;
    }

    private boolean isPassable(PlayerPosition position) {
        return footholds.get(position.getValue()) == Foothold.PASSABLE;
    }

    public List<Foothold> getFootholds() {
        return footholds;
    }
}
