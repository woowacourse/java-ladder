package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import ladder.utils.BarGenerator;
import ladder.utils.BooleanGenerator;

public class Line {
    private static final int PRE_CREATED_BARS_COUNT = 1;
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
        bars.add(generateBar(booleanGenerator));
        for (int i = 0; i < size - PRE_CREATED_BARS_COUNT; i++) {
            Bar existBar = getAppropriateBar(bars.get(i), booleanGenerator);
            bars.add(existBar);
        }
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
}
