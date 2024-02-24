package domain;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LadderTest {

    static Stream<Arguments> climbParameters() {
        return Stream.of(
                Arguments.of(0,1),
                Arguments.of(1,0),
                Arguments.of(2,2)
        );
    }

    @Test
    @DisplayName("사다리 전체 폭 검증")
    void validateRowCount() {
        Ladder ladder = new Ladder(5, 5, new BridgeRandomGenerator());
        Assertions.assertThat(ladder.getRows().size())
                .isEqualTo(5);
    }

    @ParameterizedTest
    @MethodSource("climbParameters")
    @DisplayName("사다리 타기")
    void climb(int startPosition, int endPosition) {
        Ladder ladder = new Ladder(5, 3, width -> List.of(true,false));
        /*
        * |-----|    |
        * |-----|    |
        * |-----|    |
        * |-----|    |
        * |-----|    |
        * */
        int actual = ladder.climb(startPosition);
        Assertions.assertThat(actual)
                .isEqualTo(endPosition);
    }
}
