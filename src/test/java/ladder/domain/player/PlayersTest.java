package ladder.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class PlayersTest {

    @Test
    @DisplayName("참여자 이름이 중복이라면 예외가 발생한다.")
    void player_DuplicatedNames_ExceptionThrown() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Players(List.of("pobi", "honux", "crong", "jk", "pobi")));
    }

    @Test
    @DisplayName("참여자 이름이 2개 이하라면 예외가 발생한다.")
    void player_SizeLessThanTwo_ExceptionThrown() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Players(List.of("pobi", "honux")));
    }

    @Test
    @DisplayName("가장 긴 참여자 이름의 길이를 찾을 수 있다.")
    void findMaxNameLength_FiveLength_IsEqual() {
        // given
        Players players = new Players(List.of("pobi", "honux", "jk"));

        // when
        int maxNameLength = players.findMaxNameLength();

        // then
        assertThat(maxNameLength).isEqualTo(5);
    }

    @Test
    @DisplayName("참여자로 사다리 타기 전 위치를 알 수 있다.")
    void findPosition_Player_PositionIsTwo() {
        // given
        Players players = new Players(List.of("pobi", "honux", "crong", "jk"));
        Player crong = new Player("crong");

        // when
        int position = players.findPosition(crong);

        // then
        assertThat(position).isEqualTo(2);
    }

    @Test
    @DisplayName("존재하지 않는 참여자의 위치를 찾으면 예외가 발생한다")
    void findPosition_NotFoundPlayer_ExceptionThrown() {
        // given
        Players players = new Players(List.of("pobi", "honux", "crong", "jk"));

        // when && then
        assertThatThrownBy(() -> players.findPosition(new Name("any")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
