package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Bridges> bridges;

    public Ladder(BridgeConstructStrategy bridgeConstructStrategy, int personCount, Height height) {
        validate(personCount);
        bridges = IntStream.range(0, height.getIntValue())
                .mapToObj((index) -> bridgeConstructStrategy.generate(personCount - 1))
                .toList();
    }

    private void validate(int personCount) {
        if (personCount <= 0) {
            throw new IllegalArgumentException("사람을 1 명 이상 입력해 주세요.");
        }
    }

    public List<Bridges> getBridge() {
        return Collections.unmodifiableList(bridges);
    }
}
