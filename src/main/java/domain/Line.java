package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private static final int MIN_HEIGHT = 1;
    private static final int MAX_HEIGHT = 10;

    private static final Random random = new Random();
    private final List<Bridge> bridges = new ArrayList<>();

    public Line(final int width) {
        validateWidth(width);
        generateLine(width);
    }

    public List<Bridge> getBridges() {
        return this.bridges;
    }

    private void validateWidth(final int width) {
        if (MIN_HEIGHT > width || width > MAX_HEIGHT) {
            throw new IllegalArgumentException(String.format("높이는 %d 이상 %d 이하로 입력해 주세요.",
                    MIN_HEIGHT, MAX_HEIGHT));
        }
    }

    private void generateLine(final int width) {
        for (int i = 0; i < width; i++) {
            bridges.add(generateBridgeOne());
        }
    }

    private Bridge generateBridgeOne() {
        if (doesLastBridgeExist()) {
            return Bridge.EMPTY;
        }
        if (random.nextBoolean()) {
            return Bridge.EXIST;
        }
        return Bridge.EMPTY;
    }

    private boolean doesLastBridgeExist() {
        if (this.bridges.size() == 0) {
            return false;
        }
        return Bridge.EXIST == this.bridges.get(this.bridges.size() - 1);
    }
}
