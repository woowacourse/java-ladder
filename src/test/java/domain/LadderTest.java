package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.bridgeConstructstrategy.BridgeConstructStrategy;
import domain.bridgeConstructstrategy.RandomBridgeConstructStrategy;
import java.util.List;
import java.util.stream.IntStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LadderTest {

    private static final Height DEFAULT_HEIGHT = new Height(4);
    private static final Names names = new Names(List.of("a", "b", "c", "d"));
    private static final Prizes prizes = new Prizes(List.of("A", "B", "C", "D"), names);



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

    @DisplayName("체크 패턴이고 높이가 4인 경우, 사다리 순회가 정상적으로 동작한다.")
    @ParameterizedTest
    @CsvSource({"a, D", "b, C", "c, B", "d, A"})
    void calculatePrizeTest(String name, String expected) {
        //then
        Ladder ladder = new Ladder(new CheckPatternBridgeConstructStrategy(), names, prizes, DEFAULT_HEIGHT);

        //when
        String result = ladder.findPrizeByName(name);

        //then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @DisplayName("체크 패턴이고 높이가 5인 경우, 사다리 순회가 정상적으로 동작한다.")
    @ParameterizedTest
    @CsvSource({"a, C", "b, D", "c, A", "d, B"})
    void calculatePrizeTest2(String name, String expected) {
        //then
        Ladder ladder = new Ladder(new CheckPatternBridgeConstructStrategy(), names, prizes, new Height(5));

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

class CheckPatternBridgeConstructStrategy implements BridgeConstructStrategy {
    static int callCount;
    static boolean canBuild;

    public CheckPatternBridgeConstructStrategy() {
        callCount = 0;
        canBuild = true;
    }

    @Override
    public Bridges generate(int count) {
        if (callCount++ % 2 == 0) {
            canBuild = true;
            List<Bridge> bridges = makeBridgesByCount(count);
            return new Bridges(bridges);
        }
        canBuild = false;
        List<Bridge> bridges = makeBridgesByCount(count);
        return new Bridges(bridges);
    }

    private List<Bridge> makeBridgesByCount(int count) {
        return IntStream.range(0, count)
                .mapToObj((i) -> makeBridgeWithSwitch())
                .toList();
    }

    private Bridge makeBridgeWithSwitch() {
        if (canBuild) {
            canBuild = false;
            return Bridge.BUILT;
        }
        canBuild = true;
        return Bridge.EMPTY;
    }
}
