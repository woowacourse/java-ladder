package domain;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LadderTest {

    @Test
    @DisplayName("정상적인 사다리가 생성되는지 검증")
    void validLadder() {
        Assertions.assertThatNoException()
                .isThrownBy(() -> new Ladder(
                        List.of(Line.from(false, true, false), Line.from(true, false, false),
                                Line.from(false, true, false), Line.from(false, true, false),
                                Line.from(false, true, false), Line.from(false, true, false))));
    }

    @Test
    @DisplayName("두 지점 사이에 연결이 없는 사다리가 생성되지 않는지 검증")
    void noConnectedLadder() {
        Assertions.assertThatThrownBy(() -> new Ladder(
                        List.of(Line.from(false, true, false), Line.from(false, true, false), Line.from(false, true, false),
                                Line.from(false, true, false), Line.from(false, true, false), Line.from(false, true, false))))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("두 지점 사이에는 반드시 한개 이상의 발판이 있어야 합니다.");
    }

    @ParameterizedTest
    @MethodSource("climbParameter")
    @DisplayName("사다리 타기 결과가 잘 나오는지 검증")
    void climb(int startIndex, int endIndex) {
        /*
         * |     |-----|
         * |-----|     |
         * |     |-----|
         * |     |-----|
         * |     |-----|
         * |     |-----|
         * */
        Ladder ladder = new Ladder(
                List.of(Line.from(false, true, false), Line.from(true, false, false),
                        Line.from(false, true, false), Line.from(false, true, false),
                        Line.from(false, true, false), Line.from(false, true, false)));
        int actual = ladder.climb(startIndex);
        Assertions.assertThat(actual)
                .isEqualTo(endIndex);
    }

    static Stream<Arguments> climbParameter() {
        return Stream.of(Arguments.of(0, 1),
                Arguments.of(1, 2),
                Arguments.of(2, 0));
    }
}
