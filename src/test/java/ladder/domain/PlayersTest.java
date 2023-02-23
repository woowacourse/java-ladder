package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PlayersTest {

    @Test
    @DisplayName("여러 개의 이름을 입력받고 players를 생성한다")
    void shouldCreatePlayersWhenInputStrings() {
        List<String> names = new ArrayList<>(List.of("a", "ab", "abc"));

        assertDoesNotThrow(() -> Players.generate(names));
    }

    @Test
    @DisplayName("플레이어의 수를 반환한다")
    void shouldReturnSizeWhenRequest() {
        List<String> names = new ArrayList<>(List.of("a", "ab", "abc"));

        Players players = Players.generate(names);

        assertThat(players.getSize()).isEqualTo(3);
    }

    @Test
    @DisplayName("플레이어들의 이름을 문자열로 반환한다")
    void shouldReturnNameValuesWhenRequest() {
        List<String> names = new ArrayList<>(List.of("a", "ab", "abc"));

        Players players = Players.generate(names);

        assertThat(players.getNameValues()).containsExactly("a", "ab", "abc");
    }

    @Test
    @DisplayName("플레이어는 2명 이상이여야 한다")
    void shouldMinimum2PlayersWhenCreate() {
        List<String> names = new ArrayList<>(List.of("a"));

        assertThatThrownBy(() -> Players.generate(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("플레이어는 최소 2명 이상이여야 합니다");
    }

    @Test
    @DisplayName("플레이어의 위치는 입력 순이다")
    void shouldPlayersOrderIsSameWithInputOrderWhenCreate() {
        List<String> names = new ArrayList<>(List.of("a", "ab", "abc"));
        Players players = Players.generate(names);

        List<Player> playerList = players.toUnmodifiablePlayers();

        assertAll(
                () -> assertThat(playerList.get(0).getPosition()).isEqualTo(0),
                () -> assertThat(playerList.get(1).getPosition()).isEqualTo(1),
                () -> assertThat(playerList.get(2).getPosition()).isEqualTo(2)
        );
    }

    @Test
    @DisplayName("플레이어의 이름으로 위치를 알 수 있다")
    void shouldFindPositionWhenInputName() {
        List<String> names = new ArrayList<>(List.of("a", "b"));

        Players players = Players.generate(names);

        assertThat(players.findPositionBy(new Name("a"))).isEqualTo(0);
    }

    /*
    a   b   c
    |---|   |
    |   |---|
    b   c   a
    */
    @ParameterizedTest
    @CsvSource(value = {"a:2", "b:0", "c:1"}, delimiter = ':')
    @DisplayName("players 모두의 위치가 이동한다")
    void shouldChangeAllPositionsWhenMoveAll(String playerName, int expectPosition) {
        Players players = Players.generate(List.of("a", "b", "c"));
        List<Boolean> determinedBars = new ArrayList<>(List.of(true, false, true));
        Ladder ladder = Ladder.generate(2, 2, new DeterminedBooleanGenerator(determinedBars));

        players.moveAll(ladder);

        assertThat(players.findPositionBy(new Name(playerName))).isEqualTo(expectPosition);
    }
}
