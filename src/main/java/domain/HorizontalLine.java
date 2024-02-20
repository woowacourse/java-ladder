package domain;

import generator.BooleanGenerator;
import java.util.List;
import java.util.stream.IntStream;

public class HorizontalLine {

    private static final int MIN_PLAYER_COUNT = 2;
    private static final int MAX_PLAYER_COUNT = 10;

    private final int playerCount;
    private final CrossingIndices crossingLineIndices;

    public HorizontalLine(int playerCount) {
        validatePlayerCount(playerCount);
        this.playerCount = playerCount;
        this.crossingLineIndices = new CrossingIndices();
    }

    public void createCrossingLines(BooleanGenerator generator) {
        crossingLineIndices.clear();

        IntStream.range(0, playerCount - 1)
                .filter(i -> generator.generate())
                .forEach(crossingLineIndices::add);
    }

    public List<Integer> getCrossingLineIndices() {
        return crossingLineIndices.getCopyOfIndices();
    }

    private void validatePlayerCount(int playerCount) {
        if (playerCount < MIN_PLAYER_COUNT || playerCount > MAX_PLAYER_COUNT) {
            throw new IllegalArgumentException("플레이어 수 범위는 2 이상 10 이하여야 합니다.");
        }
    }
}
