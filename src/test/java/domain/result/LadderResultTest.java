package domain.result;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import domain.result.message.ResultExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderResultTest {

    @Nested
    @DisplayName("실행 결과 생성 예외 테스트")
    class LadderResultExceptionTest {

        @ParameterizedTest
        @ValueSource(strings = {"", " "})
        @DisplayName("공백만 입력되면 예외가 발생한다")
        void createLadderResultFailByBlank(String ladderResult) {
            assertThatThrownBy(() -> new LadderResult(ladderResult))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ResultExceptionMessage.LADDER_RESULT_BLANK);
        }

        @Test
        @DisplayName("문자 길이가 1 이상 5 이하가 아니면 예외가 발생한다")
        void createLadderResultFailByLength() {
            String ladderResult = "abcdef";

            assertThatThrownBy(() -> new LadderResult(ladderResult))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ResultExceptionMessage.LADDER_RESULT_LENGTH);
        }
    }

    @Nested
    @DisplayName("실행 결과 생성 성공 테스트")
    class LadderResultSuccessTest {

        @ParameterizedTest
        @ValueSource(strings = {"a", "abcde"})
        @DisplayName("실행 결과의 길이가 1 ~ 5글자라면 정상적으로 생성된다")
        void createLadderResultFailByBlank(String ladderResult) {
            assertThatCode(() -> new LadderResult(ladderResult))
                    .doesNotThrowAnyException();
        }
    }
}
