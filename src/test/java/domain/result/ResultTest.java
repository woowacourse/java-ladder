package domain.result;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ResultTest {
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "    "})
    @DisplayName("결과의 이름이 비어 있으면 예외가 발생한다")
    void emptyName(final String name) {
        System.out.printf("%5s\n","가나");
        System.out.printf("%5s","ab");
        assertThatCode(() -> new Result(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "qwrqwrqwrkkk"})
    @DisplayName("결과의 이름이 5글자를 초과하면 예외가 발생한다")
    void length(final String name) {
        assertThatCode(() -> new Result(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"!@#", "\\uD83D\\uDE03\\uD83D"})
    @DisplayName("결과의 이름에 영문,숫자,한글이 아닌 문자가 포함 되면 예외가 발생한다")
    void character(final String name) {
        assertThatCode(() -> new Result(name)).isInstanceOf(IllegalArgumentException.class);
    }
}
