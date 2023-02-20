package domain.players;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayersTest {

    @DisplayName("참여자가 20명을 넘을 수 없다.")
    @Test
    void playerSizeNotMoreThan20() {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            players.add(new Player(String.valueOf(i)));
        }
        assertThatThrownBy(() -> new Players(players))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참여자 수는 1명 이상 20명 이하입니다.");
    }

    @DisplayName("참여자가 0명 이하일 수 없다.")
    @ValueSource(ints = {0, -1})
    @ParameterizedTest
    void playerSizeNotLessThan1() {
        List<Player> players = Collections.emptyList();
        assertThatThrownBy(() -> new Players(players))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참여자 수는 1명 이상 20명 이하입니다.");
    }

    @DisplayName("참여자 수는 1명 이상 20명 이하이다.")
    @ValueSource(ints = {1, 10, 20})
    @ParameterizedTest
    void playerSizeTest(int playerSize) {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < playerSize; i++) {
            players.add(new Player(String.valueOf(i)));
        }
        assertThat(new Players(players).getPlayerNames().size()).isEqualTo(playerSize);
    }

    @DisplayName("참여자 이름이 중복될 수 없다.")
    @Test
    void playerNameNotDuplicated() {
        List<Player> players = List.of(new Player("a"), new Player("a"));
        assertThatThrownBy(() -> new Players(players))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참여자 이름은 중복될 수 없습니다.");
    }

    @DisplayName("참여자들의 이름을 불러올 수 있다.")
    @Test
    void getPlayerNames() {
        Players players = new Players(List.of(new Player("a"), new Player("b")));
        assertThat(players.getPlayerNames()).containsExactly("a", "b");
    }

}
