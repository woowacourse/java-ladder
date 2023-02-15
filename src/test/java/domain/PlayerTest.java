package domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayerTest {

    @DisplayName("사람 이름의 앞 뒤 공백은 무시한다.")
    @ParameterizedTest
    @ValueSource(strings = {"  kong", "kong  ", " ko ng ", "    kong   "})
    void validateTest(String name) {
        assertThatCode(() -> new Player(name))
                .doesNotThrowAnyException();
    }

    @DisplayName("사람 이름은 1글자에서 5글자 사이이다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "kongha", "  ", "ko   ng"})
    void validateTest2(String name) {
        assertThatThrownBy(() -> new Player(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사람 이름은 1글자에서 5글자 사이이어야 합니다.");
    }

    @DisplayName("사람 이름이 정상적으로 입력되는 경우에는 이름이 생성된다.")
    @ParameterizedTest
    @ValueSource(strings = {"odo", "kong"})
    void validateTest3(String name) {
        assertThatCode(() -> new Player(name))
                .doesNotThrowAnyException();
    }
}
