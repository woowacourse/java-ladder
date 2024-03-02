package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class PlayersTest {

    @DisplayName("참여자 간 이름이 중복되면 예외가 발생한다.")
    @Test
    void occurExceptionIfPlayerNameIsDuplicated() {
        assertThatThrownBy(() -> new Players(List.of("test1", "test2", "test2")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Players.ERROR_DUPLICATED_NAME);
    }

    @DisplayName("참여자 수가 최소 인원보다 적으면 예외가 발생한다.")
    @Test
    void occurExceptionIfPlayerCountIsLessThanMinCount() {
        assertThatThrownBy(() -> new Players(List.of("pobi")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Players.ERROR_MIN_PLAYER_COUNT);
    }

    @DisplayName("결과를 조회할 참여자의 인덱스를 반환한다.")
    @Test
    void returnIndexOfResultName() {
        // given
        Players players = new Players(List.of("pobi", "honux", "crong", "jk"));
        String resultName = "crong";

        // when
        int index = players.findPositionOfPlayer(resultName);

        // then
        assertThat(index).isEqualTo(2);
    }
}
