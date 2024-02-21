package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Bridges> bridges;

    public Ladder(BridgeConstructStrategy bridgeConstructStrategy, int personCount, int height) {
        validate(personCount, height);
        bridges = IntStream.range(0, height)
                .mapToObj((index) -> bridgeConstructStrategy.generate(personCount - 1))
                .toList();
    }

    private void validate(int personCount, int height) {
        if (height <= 0) {
            throw new IllegalArgumentException(); // TODO 예외 메시지
        }
        if (personCount <= 0) {
            throw new IllegalArgumentException(); // TODO 예외 메시지
        }

    }

    public List<Bridges> getBridge() {
        return Collections.unmodifiableList(bridges);
    }
}
