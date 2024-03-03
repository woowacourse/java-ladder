package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class PlayersTest {

    private List<Player> players;

    @BeforeEach
    void setUp() {
        Player pobi = new Player("pobi");
        Player honux = new Player("honux");
        Player crong = new Player("crong");
        Player jk = new Player("jk");
        players = new ArrayList<>(List.of(pobi, honux, crong, jk));
    }

    @Test
    @DisplayName("사람 이름이 중복이라면 예외가 발생한다.")
    void createDuplicatedNames() {
        players.add(new Player("pobi"));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Players(players));
    }

    @Test
    @DisplayName("이름이 2개 이하라면 예외가 발생한다.")
    void nameLengthExceptionTest() {
        List<Player> towPlayers = players.subList(0, 2);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Players(towPlayers));
    }

    @Test
    @DisplayName("가장 긴 이름의 길이를 찾을 수 있다.")
    void findMaxNameLength() {
        // given
        Players players = new Players(this.players);

        // when
        int maxNameLength = players.findMaxNameLength();

        // then
        assertThat(maxNameLength).isEqualTo(5);
    }

    @Test
    @DisplayName("이름으로 사다리 타기 전 위치를 알 수 있다.")
    void find() {
        // given
        Players players = new Players(this.players);
        Player crong = new Player("crong");

        // when
        int position = players.findPosition(crong);

        // then
        assertThat(position).isEqualTo(2);
    }

    @Test
    @DisplayName("존재하지 않는 참여자의 위치를 찾으면 예외가 발생한다")
    void TargetNotFoundExceptionTest() {
        // given
        Players players = new Players(this.players);

        // when && then
        assertThatThrownBy(() -> players.findPosition(new Name("any")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
