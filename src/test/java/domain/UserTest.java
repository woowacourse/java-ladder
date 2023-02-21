package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UserTest {
    @ParameterizedTest(name = "이름이 1글자 이상 5글자 이하면 User를 생성한다. 입력값 = {0}")
    @ValueSource(strings = {"pobi", "honux", "jk"})
    void userSuccessTest(String name) {
        Assertions.assertThatCode(() -> new User(name))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest(name = "이름이 1글자 미만 5글자 초과면 예외를 던진다. 입력값 = {0}")
    @ValueSource(strings = {"", "honuxx"})
    void userFailureTest(String name) {
        Assertions.assertThatThrownBy(() -> new User(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
