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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderTest {

    private static final Height DEFAULT_HEIGHT = new Height(4);

    @DisplayName("객체가 정상적으로 생성된다.")
    @Test
    void constructSuccessTest() {
        assertThatNoException()
                .isThrownBy(() -> new Ladder(new RandomBridgeConstructStrategy(), 4, DEFAULT_HEIGHT));
    }

    @DisplayName("사람 수가 자연수가 아니라면 예외가 발생한다.")
    @ParameterizedTest(name = "사람 수가 {0}인 경우 예외가 발생한다.")
    @ValueSource(ints = {-3, 0})
    void constructFailWithNotPositiveWidth(int personCount) {
        assertThatThrownBy(() -> new Ladder(new RandomBridgeConstructStrategy(), personCount, DEFAULT_HEIGHT))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("연속된 브릿지가 존재하면 예외가 발생한다.")
    @Test
    void constructFailWithContinuousBridge() {
        assertThatThrownBy(() -> new Ladder(new ContinuousBridgeConstructStrategy(), 5, DEFAULT_HEIGHT))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Ladder 가 사람 수 - 1 개 만큼의 Bridges 를 가진다.")
    @Test
    void ladderContainsRightLength() {
        //given
        int personCount = 5;

        //when
        Ladder ladder = new Ladder(new RandomBridgeConstructStrategy(), personCount, DEFAULT_HEIGHT);

        //then
        assertThat(ladder.getBridge()).hasSize(personCount - 1);
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
