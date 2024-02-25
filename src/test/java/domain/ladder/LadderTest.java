package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.ladder.bridgeConstructstrategy.BridgeConstructStrategy;
import domain.ladder.bridgeConstructstrategy.CustomBridgeConstructStrategy;
import domain.ladder.bridgeConstructstrategy.RandomBridgeConstructStrategy;
import domain.player.Names;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    private static final Height DEFAULT_HEIGHT = new Height(4);
    private static final Names names = new Names(List.of("a", "b", "c", "d"));

    static class ContinuousBridgeConstructStrategy implements BridgeConstructStrategy {
        @Override
        public Bridges generate(int count) {
            List<Bridge> bridges = IntStream.range(0, count)
                    .mapToObj((i) -> Bridge.BUILT)
                    .toList();
            return new Bridges(bridges);
        }
    }

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

    @DisplayName("사다리가 생성된 이후엔 올바른 결과를 조회할 수 있다.")
    @Test
    void ladderMatchesCollectResult() {
/*  테스트 되는 사다리의 형태 :
            |-----|     |-----|
            |     |-----|     |
            |-----|     |     |
            |     |-----|     |
            |-----|     |-----|
 */
        Ladder customLadder = new Ladder(
                new CustomBridgeConstructStrategy(List.of(
                        List.of(Bridge.BUILT, Bridge.EMPTY, Bridge.BUILT),
                        List.of(Bridge.EMPTY, Bridge.BUILT, Bridge.EMPTY),
                        List.of(Bridge.BUILT, Bridge.EMPTY, Bridge.EMPTY),
                        List.of(Bridge.EMPTY, Bridge.BUILT, Bridge.EMPTY),
                        List.of(Bridge.BUILT, Bridge.EMPTY, Bridge.BUILT)
                )), names, new Height(5)
        );

        assertThat(customLadder.getResultIndex(0))
                .isEqualTo(0);
        assertThat(customLadder.getResultIndex(1))
                .isEqualTo(3);
        assertThat(customLadder.getResultIndex(2))
                .isEqualTo(2);
        assertThat(customLadder.getResultIndex(3))
                .isEqualTo(1);
    }
}
