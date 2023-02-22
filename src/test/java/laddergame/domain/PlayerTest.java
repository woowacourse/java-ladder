package laddergame.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Player는")
class PlayerTest {

    @DisplayName("생성된다.")
    @Test
    void create() {
        assertDoesNotThrow(() -> new Player(new PersonalName("hihi"), 0));
    }

}