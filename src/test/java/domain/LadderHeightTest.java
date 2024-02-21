package domain;

import common.exception.message.ExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class LadderHeightTest {

    @Nested
    @DisplayName("사다리 높이 입력 형식 테스트")
    class LadderHeightFormatTest {
        @Test
        @DisplayName("정수형태가 입력되면 정상적으로 생성된다")
        void createLadderHeightSuccessWithFormat() {
            LadderHeight height = new LadderHeight("2");
            Assertions.assertThat(height.getValue()).isEqualTo(2);
        }

        @Test
        @DisplayName("정수형태가 아니라면 예외가 발생한다")
        void createLadderHeightFailByFormat() {
            Assertions.assertThatThrownBy(() -> new LadderHeight("a"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INTEGER_FORMAT);
        }
    }

    @Nested
    @DisplayName("사다리 높이 범위 테스트")
    class LadderHeightRangeTest {
        @ParameterizedTest
        @MethodSource("createLadderHeightSuccessByRangeArguments")
        @DisplayName("높이가 2 이상, 10 이하라면 정상적으로 생성된다")
        void createLadderHeightSuccessWithRange(String value, int expected) {
            LadderHeight ladderHeight = new LadderHeight(value);
            Assertions.assertThat(ladderHeight.getValue()).isEqualTo(expected);
        }

        static Stream<Arguments> createLadderHeightSuccessByRangeArguments() {
            return Stream.of(
                    Arguments.arguments("2", 2),
                    Arguments.arguments("10", 10)
            );
        }

        @ParameterizedTest
        @ValueSource(strings = {"1", "11"})
        @DisplayName("높이가 2 미만, 10 초과라면 예외가 발생한다")
        void createLadderHeightFailByRange(String value) {
            Assertions.assertThatThrownBy(() -> new LadderHeight(value))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.LADDER_HEIGHT_RANGE);
        }
    }
}
