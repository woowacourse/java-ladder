package ladder.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerResultTest {

    @Test
    @DisplayName("playerResult가 정상적으로 생성되어야 한다.")
    void create_success() {
        // given
        PlayerResult result = new PlayerResult(new Player("glen"), new Prize("1000"));

        // expect
        assertThat(result.getPlayerName())
                .isEqualTo("glen");
        assertThat(result.getPrize())
                .isEqualTo("1000");
    }

    @Test
    @DisplayName("사용자의 이름이 같으면 참이 반횐되어야 한다.")
    void isPlayerNameMatch_correctName() {
        // given
        PlayerResult result = new PlayerResult(new Player("glen"), new Prize("1000"));

        // expect
        assertThat(result.isPlayerNameMatch("glen"))
                .isTrue();
    }

    @Test
    @DisplayName("사용자의 이름이 같지않으면 거짓이 반환되어야 한다.")
    void isPlayerNameMatch_incorrectName() {
        // given
        PlayerResult result = new PlayerResult(new Player("glen"), new Prize("1000"));

        // expect
        assertThat(result.isPlayerNameMatch("pobi"))
                .isFalse();
    }
}
