package domain;

import exception.InvalidLadderHeightException;
import java.util.List;
import java.util.stream.IntStream;
import util.BooleanGenerator;

public class Ladder {

    private final boolean[] status;

    public Ladder(int height) {
        validateHeight(height);
        status = new boolean[height];
    }

    private void validateHeight(int height) {
        if (!isValidHeight(height)) {
            throw new InvalidLadderHeightException();
        }
    }

    private boolean isValidHeight(int height) {
        final int maxHeight = 10;
        final int minHeight = 1;
        return minHeight <= height && height <= maxHeight;
    }

    public int getHeight() {
        return status.length;
    }

    public void generateStatus(List<Integer> avoid, BooleanGenerator booleanGenerator) {
        IntStream.range(0, status.length)
            .filter((num) -> !avoid.contains(num))
            .forEach((num) -> {
                boolean isConnect = booleanGenerator.generate();
                status[num] = isConnect;
            });
    }

    public boolean[] getStatus() {
        return status;
    }
}
