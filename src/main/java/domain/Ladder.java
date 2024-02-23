package domain;

import domain.bridgeConstructstrategy.BridgeConstructStrategy;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    public static final int MIN_PLAYER_SIZE = 2;
    private final List<Bridges> bridges;

    public Ladder(BridgeConstructStrategy bridgeConstructStrategy, int personCount, Height height) {
        validate(personCount);
        bridges = IntStream.range(0, height.getIntValue()) // TODO for 문과 차이점 비교
                .mapToObj((index) -> bridgeConstructStrategy.generate(personCount - 1))
                .toList();
    }

    private void validate(int personCount) {
        if (personCount < MIN_PLAYER_SIZE) {
            throw new IllegalArgumentException("사람을 "+ MIN_PLAYER_SIZE + " 명 이상 입력해 주세요.");
        }
    }

    public List<Bridges> getBridge() {
        return Collections.unmodifiableList(bridges);
    }
}
