package domain;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UserTest {

    @ParameterizedTest(name = "이름이 1글자 이상 5글자 이하면 예외를 던지지 않는다. 입력값 = {0}")
    @ValueSource(strings = {"pobi", "honux", "j"})
    void should_notThrowException_when_nameLengthIsValid(String name) {
        assertThatCode(() -> new User(name))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest(name = "이름이 1글자 미만 5글자 초과면 예외를 던진다. 입력값 = {0}")
    @ValueSource(strings = {"", "honuxx"})
    void should_throwException_when_nameLengthIsInvalid(String name) {
        assertThatThrownBy(() -> new User(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름이 같은 User는 서로 동등하다.")
    void should_equal_when_sameName() {
        User userA = new User("kodak");
        User userB = new User("kodak");

        assertThat(userA).isEqualTo(userB);
    }
}
