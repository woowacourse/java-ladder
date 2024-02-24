package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.bridgeConstructstrategy.BridgeConstructStrategy;
import domain.bridgeConstructstrategy.RandomBridgeConstructStrategy;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderTest {

    private static final Height DEFAULT_HEIGHT = new Height(4);
    private static final Names names = new Names(List.of("a", "b", "c", "d"));
    private static final Prizes prizes = new Prizes(List.of("A", "B", "C", "D"), names);
    private static final Ladder ladder = new Ladder(new CheckPatternBridgeConstructStrategy(), names, prizes, DEFAULT_HEIGHT);


    @DisplayName("객체가 정상적으로 생성된다.")
    @Test
    void constructSuccessTest() {
        assertThatNoException()
                .isThrownBy(() -> new Ladder(new RandomBridgeConstructStrategy(), names, prizes, DEFAULT_HEIGHT));
    }

    @DisplayName("연속된 브릿지가 존재하면 예외가 발생한다.")
    @Test
    void constructFailWithContinuousBridge() {
        assertThatThrownBy(() -> new Ladder(new ContinuousBridgeConstructStrategy(), names, prizes, DEFAULT_HEIGHT))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Ladder 가 높이 만큼의 Bridges 를 가진다.")
    @Test
    void ladderContainsRightLength() {
        //when
        Ladder ladder = new Ladder(new RandomBridgeConstructStrategy(), names, prizes, DEFAULT_HEIGHT);

        //then
        assertThat(ladder.getBridge()).hasSize(DEFAULT_HEIGHT.getIntValue());
    }

    @ParameterizedTest
    @CsvSource({"a, D", "b, C", "c, B", "d, A"})
    void calculatePrizeTest(String name, String expected) {
        //when
        String result = ladder.findPrizeByName(name);

        //then
        Assertions.assertThat(result).isEqualTo(expected);
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

// TODO 한 번 이상 사용시 예상 값이 변경될 수 있으므로 리팩터링
class CheckPatternBridgeConstructStrategy implements BridgeConstructStrategy {
    static int callCount = 0;

    @Override
    public Bridges generate(int count) {
        if (callCount++ % 2 == 0) {
            List<Bridge> bridges = IntStream.range(0, count)
                    .mapToObj((i) -> {
                        if (i % 2 == 0) {
                            return Bridge.BUILT;
                        }
                        return Bridge.EMPTY;
                    })
                    .toList();
            return new Bridges(bridges);
        }
        List<Bridge> bridges = IntStream.range(0, count)
                .mapToObj((i) -> {
                    if (i % 2 == 1) {
                        return Bridge.BUILT;
                    }
                    return Bridge.EMPTY;
                })
                .toList();
        return new Bridges(bridges);
    }
}
