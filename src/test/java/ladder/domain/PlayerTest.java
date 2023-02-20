package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    @DisplayName("이름과 순서로 참여자가 생성된다.")
    void generatePlayerTest() {
        String name = "seongha";
        int order = 0;
        Assertions.assertDoesNotThrow(() -> new Player(name, order));
    }
}
