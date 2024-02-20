package ladderGame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    @DisplayName("Name을 인자로 받아서 객체를 생성할 수 있다.")
    void createPlayer() {
        assertThatCode(() -> new Player("초롱"));
    }
}