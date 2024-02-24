package domain;

import static org.assertj.core.api.Assertions.assertThat;

import domain.booleangenerator.BooleanGenerator;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LineTest {

    @DisplayName("현재 생성된 Bridge 갯수를 리턴하는 기능")
    @ParameterizedTest
    @MethodSource("createLineBridgeCountsArguments")
    public void getPointCount(Players players, int expectedLinesCount) {
        assertThat(new Line(players, new FixedBooleanGenerator(true)).getBridgeCount())
                .isEqualTo(expectedLinesCount);
    }

    static Stream<Arguments> createLineBridgeCountsArguments() {
        return Stream.of(
                Arguments.arguments(new Players(List.of("pobi", "tommy")), 1),
                Arguments.arguments(new Players(List.of("pobi", "tommy", "woni", "lisa", "brown")), 4)
        );
    }

    @DisplayName("연속으로 이어진 다리는 존재하지 않는다")
    @ParameterizedTest
    @MethodSource("createLineBridges")
    public void createLineNonContinuous(Players players, List<Bridge> bridges) {
        Line line = new Line(players, new FixedBooleanGenerator(true));

        assertThat(line.getBridges()).isEqualTo(bridges);
    }

    static Stream<Arguments> createLineBridges() {
        return Stream.of(
                Arguments.arguments(new Players(List.of("pobi", "tommy")), List.of(Bridge.EXIST)),
                Arguments.arguments(new Players(List.of("pobi", "tommy", "woni", "lisa", "brown")),
                        List.of(Bridge.EXIST, Bridge.BLANK, Bridge.EXIST, Bridge.BLANK))
        );
    }

    static class FixedBooleanGenerator implements BooleanGenerator {

        private final boolean value;

        public FixedBooleanGenerator(boolean value) {
            this.value = value;
        }

        @Override
        public boolean generate() {
            return value;
        }
    }
}
