package model.player;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PlayerTest {
    @DisplayName("참여자 이름이 5자 초과면 예외가 발생한다")
    @ParameterizedTest
    @CsvSource({"pobiii", "dooraaa", "jojojojojojo"})
    void testInvalidLengthOfPlayerName(String name) {
        assertThatThrownBy(() -> new Player(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참여자 이름이 5자 이하면 예외가 발생하지 않는다")
    @ParameterizedTest
    @CsvSource({"p", "dora", "joj", "doraa"})
    void testValidLengthOfPlayerName(String name) {
        assertDoesNotThrow(() -> new Player(name));
    }
}
