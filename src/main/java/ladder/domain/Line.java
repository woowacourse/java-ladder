package ladder.domain;

import static ladder.domain.Bar.IMMOVABLE;
import static ladder.domain.Bar.MOVABLE;
import static ladder.domain.Direction.CENTER;
import static ladder.domain.Direction.LEFT;
import static ladder.domain.Direction.RIGHT;

import java.util.ArrayList;
import java.util.List;
import ladder.utils.BarGenerator;
import ladder.utils.BooleanGenerator;

public class Line {
    private static final int LEFT_BIAS = 0;
    private static final int RIGHT_BIAS = 1;
    private static final int MINIMUM_BARS_SIZE = 1;
    private final List<Bar> bars = new ArrayList<>();

    public Line(int size) {
        this(size, new BarGenerator());
    }

    public Line(int size, BooleanGenerator booleanGenerator) {
        validateSize(size);
        generateBars(size, booleanGenerator);
    }

    private void validateSize(int size) {
        if (size < MINIMUM_BARS_SIZE) {
            throw new IllegalArgumentException("한 Line의 Bar는 1개 이상이어야 합니다.");
        }
    }

    private void generateBars(int size, BooleanGenerator booleanGenerator) {
        bars.add(IMMOVABLE);
        for (int i = 0; i < size; i++) {
            Bar existBar = getAppropriateBar(bars.get(i), booleanGenerator);
            bars.add(existBar);
        }
        bars.add(IMMOVABLE);
    }

    private Bar generateBar(BooleanGenerator booleanGenerator) {
        return Bar.of(booleanGenerator.generate());
    }

    private Bar getAppropriateBar(Bar beforeBar, BooleanGenerator booleanGenerator) {
        if (beforeBar.isMovable()) {
            return Bar.IMMOVABLE;
        }
        return generateBar(booleanGenerator);
    }

    public List<Bar> getBars() {
        return bars;
    }

    public void move(Location location) {
        if (moveLeftIfPossible(location)) {
            return;
        }

        if (moveRightIfPossible(location)) {
            return;
        }
        moveCenterIfPossible(location);
    }

    private boolean moveLeftIfPossible(Location location) {
        int startColumnIndex = location.getColumnIndex();
        if (isMovableToLeft(startColumnIndex)) {
            location.moveColumnTo(LEFT);
            return true;
        }
        return false;
    }

    private boolean moveRightIfPossible(Location location) {
        int startColumnIndex = location.getColumnIndex();
        if (isMovableToRight(startColumnIndex)) {
            location.moveColumnTo(RIGHT);
            return true;
        }
        return false;
    }

    private void moveCenterIfPossible(Location location) {
        int startColumnIndex = location.getColumnIndex();
        if (isMovableToCenter(startColumnIndex)) {
            location.moveColumnTo(CENTER);
        }
    }

    private boolean isMovableToLeft(int startColumnIndex) {
        return this.bars.get(startColumnIndex + LEFT_BIAS) == MOVABLE;
    }

    private boolean isMovableToRight(int startColumnIndex) {
        return this.bars.get(startColumnIndex + RIGHT_BIAS) == MOVABLE;
    }

    private boolean isMovableToCenter(int startColumnIndex) {
        return !(isMovableToLeft(startColumnIndex) || isMovableToRight(startColumnIndex));
    }
}
