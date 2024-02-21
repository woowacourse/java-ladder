package domain;

import generator.BooleanGenerator;
import generator.LadderBooleanGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class HorizontalLine {

    private static final int MIN_PLAYER_COUNT = 2;
    private static final int MAX_PLAYER_COUNT = 10;

    private final int playerCount;
    private final List<Boolean> ladderConnections = new ArrayList<>();

    public HorizontalLine(int playerCount) {
        validatePlayerCount(playerCount);
        this.playerCount = playerCount;
    }

    public void createCrossingLines(BooleanGenerator generator) {
        ladderConnections.clear();

        LadderBooleanGenerator ladderBooleanGenerator = new LadderBooleanGenerator(generator);
        Stream.generate(ladderBooleanGenerator::generate)
                .limit(playerCount - 1)
                .forEach(ladderConnections::add);
    }

    public HorizontalLineStatus createStatus() {
        List<Boolean> placeStatuses = List.copyOf(ladderConnections);
        return new HorizontalLineStatus(placeStatuses);
    }

    private void validatePlayerCount(int playerCount) {
        if (playerCount < MIN_PLAYER_COUNT || playerCount > MAX_PLAYER_COUNT) {
            throw new IllegalArgumentException("플레이어 수 범위는 2 이상 10 이하여야 합니다.");
        }
    }
}
