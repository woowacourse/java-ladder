package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    @DisplayName("사용자가 정상적으로 생성되어야 한다.")
    void create_success() {
        // given
        Player glen = new Player("glen");

        // expect
        assertThat(glen.getName())
                .isEqualTo("glen");
    }
}
