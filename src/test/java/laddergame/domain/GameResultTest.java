package laddergame.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("사다리 게임의 결과는")
class GameResultTest {

    @DisplayName("1자 이상, 5자 이하의 길이를 갖는다.")
    @ParameterizedTest
    @ValueSource(strings = {"5자이내", "민트", "12345"})
    public void length_success(String name) {
        assertDoesNotThrow(() -> {
            new GameResult(name);
        });
    }

    @DisplayName("5자를 초과하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"5자를초과함", "민트민트민트", "1234567"})
    public void length_fail(String name) {
        assertThrows(IllegalArgumentException.class, () -> new GameResult(name));
    }

    @DisplayName("공백을 포함하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " 앞에포함", "중간 포함", "끝에포함 "})
    public void blank(String name) {
        assertThrows(IllegalArgumentException.class, () -> new GameResult(name));
    }
}
