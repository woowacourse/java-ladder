import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @DisplayName("Player 객체 생성")
    @Test
    void createPlayer() {
        Name roy = new Name("roy");
        assertDoesNotThrow(() -> new Player(roy));
    }
}
