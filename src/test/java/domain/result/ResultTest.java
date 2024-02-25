package domain.result;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class ResultTest {

    @ParameterizedTest
    @ValueSource(strings = {"꽝", "10000"})
    @DisplayName("결과는 정해진 글자 수 범위 안에서 정상적으로 생성된다.")
    void validCreationTest(String result) {
        System.out.println(result.getBytes().length);
        assertDoesNotThrow(() -> new Result(result));
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456"})
    @NullAndEmptySource
    @DisplayName("결과가 정해진 글자 수 범위를 벗어나는 경우, 예외를 발생한다.")
    void exceedingBytesCreationTest(String result) {
        assertThatThrownBy(() -> new Result(result))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("결과는 1글자에서 5글자 사이여야 합니다.");
    }
}