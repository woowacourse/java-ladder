package model.player;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PlayerTest {
    @DisplayName("참여자 이름이 5자 초과면 예외 발생")
    @ParameterizedTest
    @CsvSource({"pobiii", "dooraaa", "jojojojojojo"})
    void testInvalidLengthOfPlayerName(String name) {
        assertThatThrownBy(() -> new Player(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참여자 이름이 5자 이하면 객체 생성 성공")
    @ParameterizedTest
    @CsvSource({"p", "dora", "joj", "doraa"})
    void testValidLengthOfPlayerName(String name) {
        assertDoesNotThrow(() -> new Player(name));
    }
}
