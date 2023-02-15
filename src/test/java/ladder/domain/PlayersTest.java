package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import ladder.domain.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayersTest {

    @Test
    @DisplayName("사용자 이름이 입력되면 콤마(,) 로 구분한다.")
    void create_usingComma() {
        // given
        String input = "glen,doggy";
        // when
        Players players = new Players(input);
        // then
        assertThat(players.getPlayers()).hasSize(2);
    }

    @ParameterizedTest
    @DisplayName("사용자 이름이 중복되면 예외가 발생한다.")
    @ValueSource(strings = {"glen,glen", "glen,doggy,doggy", "glen,doggy,glen"})
    void create_duplicateName(String input) {
        // expect
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Players(input);
        }).withMessage("[ERROR] 중복된 이름이 있습니다.");
    }

    @Test
    @DisplayName("사용자가 13명을 초과하면 예외가 발생한다.")
    void create_overMaxPlayers() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Players("1,2,3,4,5,6,7,8,9,10,11,12,13,14");
        }).withMessage("[ERROR] 사용자는 2명에서 13명까지 가능합니다.");
    }

    @Test
    @DisplayName("사용자가 2명 미만이면 예외가 발생한다.")
    void create_underMinPlayers() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Players("1");
        }).withMessage("[ERROR] 사용자는 2명에서 13명까지 가능합니다.");
    }
}
