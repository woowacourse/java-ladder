package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ResultTest {

    @DisplayName("입력값이 영어, 한글, 숫자이고 길이가 1자 이상 5자 이하면 에러가 발생하지 않는다")
    @ParameterizedTest
    @ValueSource(strings = {"꽝", "가나다라마", "a", "abcde", "A", "ABCDE", "1", "12345", "a가1b나"})
    public void createSuccess(String inputResult) {
        assertThatCode(() -> new Result(inputResult))
                .doesNotThrowAnyException();
    }

    @DisplayName("입력값이 영어, 한글, 숫자여도 길이가 길이가 1자 미만이거나 5자를 초과하면 에러가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"", "abcdef", "가나다라마바", "woowacourse6기"})
    public void createFailByLength(String inputResult) {
        int MAXIMUM_LENGTH = 5;
        assertThatCode(() -> new Result(inputResult))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("결과의 길이는 최대 %d자만 입력 가능합니다. 입력값: %s", MAXIMUM_LENGTH, inputResult));
    }

    @DisplayName("입력값이 영어, 한글, 숫자가 아니면 에러가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {" ", "!", "asd!@"})
    public void createFailByNotPermittedCharacter(String inputResult) {
        assertThatCode(() -> new Result(inputResult))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("결과는 영어, 한글, 숫자만 가능합니다. 입력값: %s", inputResult));
    }

    @DisplayName("결과가 가진 값을 반환한다")
    @Test
    public void getResult() {
        Result actual = new Result("꽝");

        assertThat(actual.getResult()).isEqualTo("꽝");
    }
}
