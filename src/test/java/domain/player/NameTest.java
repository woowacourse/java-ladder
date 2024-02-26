package domain.player;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "ab", "pobi", "abcde"})
    @DisplayName("이름이 주어지면, 올바르게 생성된다.")
    void validNameCreationTest(String name) {
        assertDoesNotThrow(() -> new Name(name));
    }

    @ParameterizedTest
    @CsvSource(value = {"''", "abcdef", "abcdefg", "NULL"}, nullValues = {"NULL"})
    @DisplayName("올바르지 않은 이름이 주어지면, 예외를 발생한다.")
    void invalidNameLengthCreationTest(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 1자 이상 5자 이하여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"안", "1", "?", "A"})
    @DisplayName("올바르지 않은 이름이 주어지면, 예외를 발생한다.")
    void invalidNameFormatCreationTest(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 알파벳 소문자로만 작성해야 합니다.");
    }
}
