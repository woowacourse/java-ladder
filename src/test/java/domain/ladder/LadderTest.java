package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.ladder.bridgeConstructstrategy.LineConstructStrategy;
import domain.ladder.bridgeConstructstrategy.RandomLineConstructStrategy;
import domain.player.Names;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    private static final Height DEFAULT_HEIGHT = new Height(4);
    private static final Names names = new Names(List.of("a", "b", "c", "d"));

    static class ContinuousLineConstructStrategy implements LineConstructStrategy {
        @Override
        public Line generate(int count) {
            List<Bridge> bridges = IntStream.range(0, count)
                    .mapToObj((i) -> Bridge.BUILT)
                    .toList();
            return new Line(bridges);
        }
    }

    @DisplayName("객체가 정상적으로 생성된다.")
    @Test
    void constructSuccessTest() {
        assertThatNoException()
                .isThrownBy(() -> new Ladder(new RandomLineConstructStrategy(), names, DEFAULT_HEIGHT));
    }

    @DisplayName("연속된 브릿지가 존재하면 예외가 발생한다.")
    @Test
    void constructFailWithContinuousBridge() {
        assertThatThrownBy(() -> new Ladder(new ContinuousLineConstructStrategy(), names, DEFAULT_HEIGHT))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Ladder 가 높이 만큼의 Bridges 를 가진다.")
    @Test
    void ladderContainsRightLength() {
        //when
        Ladder ladder = new Ladder(new RandomLineConstructStrategy(), names, DEFAULT_HEIGHT);

        //then
        assertThat(ladder.getLines()).hasSize(DEFAULT_HEIGHT.getIntValue());
    }
}
