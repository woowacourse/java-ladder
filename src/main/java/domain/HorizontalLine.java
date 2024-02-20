package domain;

import generator.BooleanGenerator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HorizontalLine {

    private static final int MIN_PLAYER_COUNT = 2;
    private static final int MAX_PLAYER_COUNT = 10;

    private final int playerCount;
    private final List<Integer> crossingLineIndices;

    public HorizontalLine(int playerCount) {
        validatePlayerCount(playerCount);
        this.playerCount = playerCount;
        this.crossingLineIndices = new ArrayList<>();
    }

    public void createCrossingLines(BooleanGenerator generator) {
        crossingLineIndices.clear();
        // TODO: Indent 간소화 및 Stream 사용 고려
        for (int i = 0; i < playerCount - 1; i++) {
            if (generator.generate()) {
                crossingLineIndices.add(i);
                i++;
            }
        }
    }

    public List<Integer> getCrossingLineIndices() {
        // TODO: 일급컬렉션으로 래핑하기
        return Collections.unmodifiableList(crossingLineIndices);
    }

    private void validatePlayerCount(int playerCount) {
        if (playerCount < MIN_PLAYER_COUNT || playerCount > MAX_PLAYER_COUNT) {
            throw new IllegalArgumentException("플레이어 수 범위는 2 이상 10 이하여야 합니다.");
        }
    }
}
