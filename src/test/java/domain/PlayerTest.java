package domain;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @DisplayName("생성 테스트")
    @Test
    void createTest() {
        assertThatCode(() -> new Player("산초"))
                .doesNotThrowAnyException();
    }
}
