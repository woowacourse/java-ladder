package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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
}
