package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void 플레이어_생성_테스트() {
        assertThatCode(() -> new Player("pobi"))
                .doesNotThrowAnyException();
    }
}