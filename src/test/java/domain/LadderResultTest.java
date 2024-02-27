package domain;

import common.exception.model.ValidationException;
import domain.ladder.LadderResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderResultTest {

    @Nested
    @DisplayName("사다리 실행 결과 길이 테스트")
    class LadderResultLengthTest {

        @ParameterizedTest
        @ValueSource(strings = {"a", "abcde"})
        @DisplayName("사다리 실행 결과 길이가 1 이상, 5 이하가 아니면 정상적으로 생성된다")
        void createLadderResultSuccessWithLength(String value) {
            Assertions.assertThatCode(() -> new LadderResult(value));
        }

        @ParameterizedTest
        @ValueSource(strings = {"", "abcdef"})
        @DisplayName("사다리 실행 결과 길이가 1 미만, 5 초과이면 예외가 발생한다")
        void createLadderResultFailByLength(String value) {
            Assertions.assertThatThrownBy(() -> new LadderResult(value))
                    .isInstanceOf(ValidationException.class)
                    .hasMessage(LadderResult.LENGTH_ERROR_MESSAGE);
        }
    }

    @Nested
    @DisplayName("사다리 실행 결과 공백,Null 테스트")
    class LadderResultBlankTest {

        @Test
        @DisplayName("사다리 실행 결과가 공백이면 예외가 발생한다")
        void createLadderResultFailByNull() {
            Assertions.assertThatThrownBy(() -> new LadderResult(" "))
                    .isInstanceOf(ValidationException.class)
                    .hasMessage(LadderResult.BLANK_ERROR_MESSAGE);
        }

        @Test
        @DisplayName("사다리 실행 결과가 Null 이면 예외가 발생한다")
        void createLadderResultFailByBlank() {
            Assertions.assertThatThrownBy(() -> new LadderResult(null))
                    .isInstanceOf(ValidationException.class)
                    .hasMessage(LadderResult.NULL_ERROR_MESSAGE);
        }
    }
}
