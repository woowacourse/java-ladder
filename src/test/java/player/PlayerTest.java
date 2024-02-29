package player;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {

    @ParameterizedTest
    @ValueSource(strings = {"aru", "pobi", "zzang"})
    @DisplayName("이름이 올바르게 생성된다.")
    void validCreationTest(String name) {
        assertDoesNotThrow(() -> new Player(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"myname", "abcdefg"})
    @NullAndEmptySource
    @DisplayName("이름의 길이가 올바르지 않은 경우, 예외를 발생한다.")
    void invalidNameLengthTest(String name) {
        Assertions.assertThatThrownBy(() -> new Player(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"안녕", "123", "abc12", "HI"})
    @DisplayName("이름이 영어 소문자로 이루어지지 않은 경우, 예외를 발생한다.")
    void invalidNamePatternTest(String name) {
        Assertions.assertThatThrownBy(() -> new Player(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
