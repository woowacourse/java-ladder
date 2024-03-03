package ladder.model;

import java.util.Collections;
import java.util.stream.IntStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private static final Random random = new Random();
    private final List<Line> ladder;

    private Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    public static Ladder of(int height, int width) {
        validate(height, width);

        List<Line> ladder = IntStream.range(0, height)
                .mapToObj(idx -> new Line(makeRandomRow(width)))
                .toList();

        return new Ladder(ladder);
    }

    private static void validate(int height, int width) {
        if (notNaturalNumber(height) || notNaturalNumber(width)) {
            throw new IllegalArgumentException("사다리 높이와 너비는 자연수여야 합니다.");
        }
    }

    private static boolean notNaturalNumber(int value) {
        return value <= 0;
    }

    private static List<LadderPath> makeRandomRow(int width) {
        List<LadderPath> randomPaths = new ArrayList<>();

        while (randomPaths.size() < width) {
            randomPaths.add(generateRandomPath(randomPaths, width));
        }

        return randomPaths;
    }

    private static LadderPath generateRandomPath(List<LadderPath> currentPaths, int width) {
        if (isLastPathConnected(currentPaths)) {
            return LadderPath.LEFT;
        }

        boolean isLastElement = currentPaths.size() == width - 1;
        if (isLastElement) {
            return LadderPath.STAY;
        }

        boolean isConnectedPath = random.nextBoolean();
        if (isConnectedPath) {
            return LadderPath.RIGHT;
        }
        return LadderPath.STAY;
    }

    private static boolean isLastPathConnected(List<LadderPath> currentPaths) {
        if (currentPaths.isEmpty()) {
            return false;
        }

        LadderPath lastPath = currentPaths.get(currentPaths.size() - 1);
        return lastPath.equals(LadderPath.RIGHT);
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(ladder);
    }

    public int getWidth() {
        return ladder.get(0).size();
    }
}
