package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("사람의 이름은 ")
class PersonTest {

    @DisplayName("1자 이상 5자 이하여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "123", "12345"})
    void succeed(String value) {
        assertDoesNotThrow(() -> new Person(value));
    }

    @DisplayName("1자 이상 5자 이하가 아니면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "123456"})
    void fail(String value) {
        assertThatThrownBy(() -> new Person(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
