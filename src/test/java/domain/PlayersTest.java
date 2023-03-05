package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayersTest {

    @DisplayName("참여자가 20명을 넘을 수 없다.")
    @Test
    void playerSizeNotMoreThan20() {
        // given
        List<Player> players = new ArrayList<>();
        for (int playerIndex = 0; playerIndex < 21; playerIndex++) {
            players.add(new Player(String.valueOf(playerIndex), playerIndex));
        }

        // when, then
        assertThatThrownBy(() -> new Players(players))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참여자 수는 1명 이상 20명 이하입니다.");
    }

    @DisplayName("참여자가 0명 이하일 수 없다.")
    @ValueSource(ints = {0, -1})
    @ParameterizedTest
    void playerSizeNotLessThan1() {
        // given
        List<Player> players = Collections.emptyList();

        // when, then
        assertThatThrownBy(() -> new Players(players))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참여자 수는 1명 이상 20명 이하입니다.");
    }

    @DisplayName("참여자 수는 1명 이상 20명 이하이다.")
    @ValueSource(ints = {1, 10, 20})
    @ParameterizedTest
    void playerSizeTest(int expectedPlayersSize) {
        // given
        List<Player> players = new ArrayList<>();
        for (int playerIndex = 0; playerIndex < expectedPlayersSize; playerIndex++) {
            players.add(new Player(String.valueOf(playerIndex), playerIndex));
        }

        // when
        int playersSize = new Players(players).getPlayerNames().size();

        // then
        assertThat(playersSize).isEqualTo(expectedPlayersSize);
    }

    @DisplayName("참여자 이름이 중복될 수 없다.")
    @Test
    void playerNameNotDuplicated() {
        // given
        List<Player> players = Stream.generate(() -> new Player("merry", 0))
                .limit(2)
                .collect(Collectors.toList());

        // when, then
        assertThatThrownBy(() -> new Players(players))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참여자 이름은 중복될 수 없습니다.");
    }

    @DisplayName("참여자들의 이름을 불러올 수 있다.")
    @Test
    void getPlayerNames() {
        // given
        Players players = new Players(List.of(
                new Player("a", 0),
                new Player("b", 1))
        );

        // when
        List<String> playerNames = players.getPlayerNames();
        String playerName1 = "a";
        String playerName2 = "b";

        // then
        assertThat(playerNames).containsExactly(playerName1, playerName2);
    }

}
