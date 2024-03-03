package model.player;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {

    @DisplayName("참여자 이름이 5자 초과면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"pobiii", "dooraaa", "jojojojojojo"})
    void testInvalidLengthOfPlayerName(String name) {
        assertThatThrownBy(() -> new Player(name))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참여자 이름이 5자 이하면 객체 생성 성공")
    @ParameterizedTest
    @ValueSource(strings = {"p", "dora", "joj", "doraa"})
    void testValidLengthOfPlayerName(String name) {
        assertThatCode(() -> new Player(name))
            .doesNotThrowAnyException();
    }
}
