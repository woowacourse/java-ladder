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
        List<String> playerNames = List.of("pobi");

        // when & then
        assertThatThrownBy(() -> new Players(playerNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사람의 수가 10명 이상이면 예외를 던진다.")
    void players_constructor_validate_over() {
        // given
        List<String> playerNames = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            playerNames.add("abc" + i);
        }

        // when & then
        assertThatThrownBy(() -> new Players(playerNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복된 사람의 이름이 있으면 예외를 던진다.")
    void throws_exception_duplicated_name() {
        // given
        String duplicatedName = "pobi";
        List<String> playerNames = List.of(duplicatedName, duplicatedName);

        // when & then
        assertThatThrownBy(() -> new Players(playerNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("플레이어 중 가장 긴 이름의 길이를 반환한다.")
    void returns_longest_players_name() {
        // given
        String bob = "bob";
        String popo = "popo";
        String dolbi = "dolbi";
        List<String> playerNames = List.of(bob, popo, dolbi);
        int expectedLongestLengthOfName = dolbi.length();

        Players players = new Players(playerNames);

        // when
        int longestLengthOfName = players.findLongestPlayerName();

        // then
        assertThat(longestLengthOfName).isEqualTo(expectedLongestLengthOfName);
    }
}
