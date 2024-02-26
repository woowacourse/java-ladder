package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.bridgeConstructstrategy.BridgeConstructStrategy;
import domain.bridgeConstructstrategy.RandomBridgeConstructStrategy;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    private static final Height DEFAULT_HEIGHT = new Height(4);
    private static final Names names = new Names(List.of("a", "b", "c", "d"));

    @DisplayName("객체가 정상적으로 생성된다.")
    @Test
    void constructSuccessTest() {
        assertThatNoException()
                .isThrownBy(() -> new Ladder(new RandomBridgeConstructStrategy(), names, DEFAULT_HEIGHT));
    }

    @DisplayName("연속된 브릿지가 존재하면 예외가 발생한다.")
    @Test
    void constructFailWithContinuousBridge() {
        assertThatThrownBy(() -> new Ladder(new ContinuousBridgeConstructStrategy(), names, DEFAULT_HEIGHT))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Ladder 가 높이 만큼의 Bridges 를 가진다.")
    @Test
    void ladderContainsRightLength() {
        //when
        Ladder ladder = new Ladder(new RandomBridgeConstructStrategy(), names, DEFAULT_HEIGHT);

        //then
        assertThat(ladder.getBridge()).hasSize(DEFAULT_HEIGHT.getIntValue());
    }
}

class ContinuousBridgeConstructStrategy implements BridgeConstructStrategy {

    @Override
    public Bridges generate(int count) {
        List<Bridge> bridges = IntStream.range(0, count)
                .mapToObj((i) -> Bridge.BUILT)
                .toList();
        return new Bridges(bridges);
    }
}
