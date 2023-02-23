package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.PlayersMaker;

public class PlayersTest {

    private List<Player> players = new ArrayList<>();

    @BeforeEach
    void init() {
        players.add(new Player("roy"));
    }

    @Test
    @DisplayName("Players 객체 생성 테스트")
    void makePlayers() {
        players.add(new Player("soy"));

        assertDoesNotThrow(() -> new Players(players));
    }

    @Test
    @DisplayName("플레이어 수가 한명일 경우 예외 발생")
    void validateMoreThanOnePlayer() {
        assertThatThrownBy(() -> new Players(players))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 플레이어는 두 명 이상 입력해야 합니다.");
    }

    @Test
    @DisplayName("플레이어 수 확인")
    void getNumberOfPlayers() {
        players.add(new Player("soy"));

        assertThat(new Players(players).getNumberOfPlayers()).isEqualTo(2);
    }

    @Test
    @DisplayName("입력받은 이름의 플레이어 반환")
    void findPlayerByName() {
        Players resultPlayers = PlayersMaker.makePlayers("a,b,c,d");

        assertThat(resultPlayers.findPlayerByName("b")).isEqualTo(new Player("b"));
    }

    @Test
    @DisplayName("입력받은 플레이어가 존재하지 않으면 예외 발생")
    void doesNotFindPlayerByName() {
        Players resultPlayers = PlayersMaker.makePlayers("a,b,c,d");

        assertThatThrownBy(() -> resultPlayers.findPlayerByName("e"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 존재하지 않는 사람입니다.");
    }
}
