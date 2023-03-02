package domain.player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {

    @DisplayName("Player가 두 명 이상일 경우 정상적으로 생성된다.")
    @Test
    void create_success() {
        // given
        List<Player> players = generateRawPlayersByNames("pobi", "neo");
        // then
        assertThatNoException().isThrownBy(() -> new Players(players));
    }

    @DisplayName("Player가 두 명 미만일 경우 예외를 반환한다.")
    @Test
    void create_fail_by_not_enough_number_of_name() {
        // given
        List<Player> players = generateRawPlayersByNames("pobi");
        // then
        assertThatThrownBy(() -> new Players(players))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("플레이어는 최소 2명 이상이여햡니다.");
    }

    @DisplayName("사람 이름이 중복되면 예외를 반환한다.")
    @Test
    void create_fail_by_duplicate_name() {
        // given
        List<Player> players = generateRawPlayersByNames("neo", "neo");
        // then
        assertThatThrownBy(() -> new Players(players))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("플레이어의 이름은 중복 될 수 없습니다.");
    }

    @DisplayName("포지션이 중복되면 예외를 반환한다.")
    @Test
    void create_fail_by_duplicate_position() {
        // given
        List<Player> players = generateRawPlayersByNames("neo", "pobi");
        players.add(new Player(new Name("asd"), new Position(1)));
        // then
        assertThatThrownBy(() -> new Players(players))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 위치가 존재합니다.");
    }

    @DisplayName("size()를 통해서 Player의 숫자를 정확하게 반환한다.")
    @Test
    void return_correct_size() {
        // given
        List<Player> rawPlayers = generateRawPlayersByNames("neo", "pobi", "jun");
        Players players = new Players(rawPlayers);
        //when
        int size = players.size();
        // then
        assertThat(size).isEqualTo(3);
    }

    @DisplayName("해당하는 이름의 Player가 존재하면 true를 반환한다.")
    @Test
    void has_specific_name_player_return_true() {
        // given
        List<Player> rawPlayers = generateRawPlayersByNames("neo", "pobi", "jun");
        Players players = new Players(rawPlayers);
        // when
        boolean result = players.containName("neo");
        // then
        assertThat(result).isTrue();
    }

    @DisplayName("해당하는 이름의 Player가 존재하지않으면 false를 반환한다.")
    @Test
    void has_not_specific_name_player_return_false() {
        // given
        List<Player> rawPlayers = generateRawPlayersByNames("neo", "pobi", "jun");
        Players players = new Players(rawPlayers);
        // when
        boolean result = players.containName("noNeo");
        // then
        assertThat(result).isFalse();
    }

    @DisplayName("특정한 이름의 Player를 반환한다.")
    @Test
    void return_specific_name_player() {
        // given
        List<Player> rawPlayers = generateRawPlayersByNames("neo", "pobi", "jun");
        Players players = new Players(rawPlayers);
        Player expectedPlayer = rawPlayers.get(0);
        // when
        Player actualPlayer = players.findPlayerByName(expectedPlayer.getName());
        // then
        assertThat(actualPlayer).isEqualTo(expectedPlayer);
    }

    @DisplayName("특정한 이름의 Player가 없다면 예외를 반환한다..")
    @Test
    void specific_name_player_not_contain_throw() {
        // given
        List<Player> rawPlayers = generateRawPlayersByNames("neo", "pobi", "jun");
        Players players = new Players(rawPlayers);
        // then
        assertThatThrownBy(() -> players.findPlayerByName("wrongName"))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("해당하는 이름을 가진 Player는 존재하지 않습니다.");
    }

    private List<Player> generateRawPlayersByNames(String... names) {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            players.add(new Player(new Name(names[i]), new Position(i + 1)));
        }
        return players;
    }
}
