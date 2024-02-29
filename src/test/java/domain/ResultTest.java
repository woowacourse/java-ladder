package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


class ResultTest {

    @DisplayName("적절한 실행 결과가 주어지면 잘 생성된다.")
    @Test
    void createResult() {
        //given
        String result = "실행 결과";

        //when & then
        assertThatCode(() -> new Result(result)).doesNotThrowAnyException();
    }

    @DisplayName("실행 결과가 1글자 미만 5글자 초과이면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 6})
    void invalidLengthResult(int count) {
        //given
        String result = "r".repeat(count);

        //when & then
        assertThatThrownBy(() -> new Result(result)).isInstanceOf(IllegalArgumentException.class).hasMessage(Result.INVALID_RESULT_LENGTH);
    }

}
