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
        assertThatCode(() -> new Result(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings ={"abcdef","qwrqwrqwrkkk"})
    @DisplayName("결과의 이름이 5글자를 초과하면 예외가 발생한다")
    void nameTest(final String name) {
        assertThatCode(() -> new Result(name)).isInstanceOf(IllegalArgumentException.class);
    }
}
