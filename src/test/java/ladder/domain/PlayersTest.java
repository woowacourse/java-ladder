package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {

    @Test
    @DisplayName("사용자 이름이 중복되면 예외가 발생한다.")
    void create_duplicateName() {
        // given
        String[] input = {"glen", "glen"};

        // expect
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Players(input);
        }).withMessage("[ERROR] 중복된 이름이 있습니다.");
    }

    @Test
    @DisplayName("사용자가 13명을 초과하면 예외가 발생한다.")
    void create_overMaxPlayers() {
        // given
        String[] input = {"1,2,3,4,5,6,7,8,9,10,11,12,13,14"};

        // expect
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Players(input);
        }).withMessage("[ERROR] 사용자는 2명에서 13명까지 가능합니다.");
    }

    @Test
    @DisplayName("사용자가 2명 미만이면 예외가 발생한다.")
    void create_underMinPlayers() {
        // given
        String[] input = {"1"};

        // expect
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Players(input);
        }).withMessage("[ERROR] 사용자는 2명에서 13명까지 가능합니다.");
    }
}
