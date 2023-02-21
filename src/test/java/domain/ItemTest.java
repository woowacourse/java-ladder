package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    @DisplayName("아이템에 공백이 포함될 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {" ", "  "})
    void itemBlankFailTest(String name) {
        assertThrows(IllegalArgumentException.class,
                () -> new Item(name));
    }

    @DisplayName("아이템에 공백이 없는경우 정상적으로 수행된다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "1 2", "123 ", " 1234"})
    void itemSuccessTest(String name) {
        assertThatCode(() -> new Item(name)).doesNotThrowAnyException();
    }

    @DisplayName("아이템 이름의 길이가 0글자 이하일 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {""})
    void itemLengthFailTest(String name) {
        assertThrows(IllegalArgumentException.class,
                () -> new Item(name));
    }
}
