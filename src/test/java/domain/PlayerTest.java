package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("사람의 이름은 ")
class PlayerTest {

    @DisplayName("1자 이상 5자 이하여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "123", "12345"})
    void succeed(String value) {
        assertDoesNotThrow(() -> new Player(value));
    }

    @DisplayName("1자 이상 5자 이하가 아니면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "123456"})
    void fail_length(String value) {
        assertThatThrownBy(() -> new Player(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 1자 이상 5자 이하여야 합니다.");
    }

    @DisplayName("이름에 all이 오면 예외를 발생시킨다.")
    @Test
    void fail_invalid_name() {
        assertThatThrownBy(() -> new Player("all"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 all이 될 수 없습니다.");
    }
}
