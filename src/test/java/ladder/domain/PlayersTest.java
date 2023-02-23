package ladder.domain;

import static ladder.Util.createPlayers;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {

    @Test
    @DisplayName("사용자 이름이 중복되면 예외가 발생한다.")
    void create_duplicateName() {
        // expect
        assertThatIllegalArgumentException().isThrownBy(() -> {
            createPlayers("glen", "glen");
        }).withMessage("[ERROR] 중복된 이름이 있습니다.");
    }

    @Test
    @DisplayName("사용자가 13명을 초과하면 예외가 발생한다.")
    void create_overMaxPlayers() {
        // expect
        assertThatIllegalArgumentException().isThrownBy(() -> {
            createPlayers(14);
        }).withMessage("[ERROR] 사용자는 2명에서 13명까지 가능합니다.");
    }

    @Test
    @DisplayName("사용자가 2명 미만이면 예외가 발생한다.")
    void create_underMinPlayers() {
        // expect
        assertThatIllegalArgumentException().isThrownBy(() -> {
            createPlayers(1);
        }).withMessage("[ERROR] 사용자는 2명에서 13명까지 가능합니다.");
    }
}
