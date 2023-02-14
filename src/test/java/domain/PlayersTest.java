package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayersTest {

    @Test
    @DisplayName("사람의 수가 1명 이하이면 예외를 던진다.")
    void players_constructor_validate() {
        // given
        Player player = new Player(new PlayerName("pobi"));
        List<Player> players = List.of(player);

        // when & then
        assertThatThrownBy(() -> new Players(players))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사람의 수가 10명 이상이면 예외를 던진다.")
    void players_constructor_validate_over() {
        // given
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            PlayerName playerName = new PlayerName("abc" + i);
            Player player = new Player(playerName);
            players.add(player);
        }

        // when & then
        assertThatThrownBy(() -> new Players(players))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복된 사람의 이름이 있으면 예외를 던진다.")
    void throws_exception_duplicated_name() {
        // given
        PlayerName duplicatedName = new PlayerName("pobi");
        Player player1 = new Player(duplicatedName);
        Player player2 = new Player(duplicatedName);
        List<Player> players = List.of(player1, player2);

        // when & then
        assertThat(player1.getName()).isEqualTo(player2.getName());
        assertThatThrownBy(() -> new Players(players))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("플레이어 중 가장 긴 이름의 길이를 반환한다.")
    void returns_longest_players_name() {
        // given
        Player bob = new Player(new PlayerName("bob"));
        Player popo = new Player(new PlayerName("popo"));
        Player dolbi = new Player(new PlayerName("dolbi"));
        Players players = new Players(List.of(bob, popo, dolbi));

        int expectedLongestLengthOfName = dolbi.getName().length();

        // when
        int longestLengthOfName = players.findLongestPlayerName();

        // then
        assertThat(longestLengthOfName).isEqualTo(expectedLongestLengthOfName);
    }
}
