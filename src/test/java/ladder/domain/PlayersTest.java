package ladder.domain;

import static ladder.Util.createPlayers;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @Test
    @DisplayName("참여자 이름으로 참여자를 찾을 수 있어야 한다.")
    void findIndexByPlayerName_success() {
        // given
        Players players = createPlayers("glen", "pobi", "bero");

        // when
        Player foundPlayer = players.findByPlayerName("glen");

        // then
        assertThat(foundPlayer.getName())
                .isEqualTo("glen");
    }

    @Test
    @DisplayName("참여자 이름으로 참여자를 찾을 때 이름이 없으면 예와가 발생한다.")
    void findIndexByPlayerName_wrongName() {
        // given
        Players players = createPlayers("glen", "pobi", "mango");

        // expect
        assertThatIllegalArgumentException()
                .isThrownBy(() -> players.findByPlayerName("player"))
                .withMessage("[ERROR] 해당 참여자가 없습니다.");
    }

    @Test
    @DisplayName("인덱스로 Player를 찾을 수 있어야 한다.")
    void findPlayerByIndex_success() {
        // given
        Players players = createPlayers("glen","bero","mango");

        // when
        Player foundPlayer = players.findPlayerByIndex(1);

        // then
        assertThat(foundPlayer.getName())
                .isEqualTo("bero");
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 4, 5})
    @DisplayName("인덱스로 Player를 찾을 때 범위를 초과하면 예외가 발생한다.")
    void findPlayerByIndex_wrongIndex(int index) {
        // given
        Players players = createPlayers(3);

        // expect
        assertThatIllegalArgumentException()
                .isThrownBy(() -> players.findPlayerByIndex(index))
                .withMessage("[ERROR] 인덱스 범위를 초과했습니다.");
    }
}
