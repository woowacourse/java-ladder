package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayersTest {

    String firstPlayerName;
    String secondPlayerName;

    @BeforeEach
    void setUp() {
        firstPlayerName = "bob";
        secondPlayerName = "popo";
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 11})
    @DisplayName("사람의 수가 2명보다 작거나 10명 이상이면 예외를 던진다.")
    void throws_exception_number_of_player_under_two(int numberOfPlayer) {
        // given
        List<String> playerNames = new ArrayList<>();
        for (int i = 0; i < numberOfPlayer; i++) {
            playerNames.add("abc" + i);
        }

        // when & then
        assertThatThrownBy(() -> new Players(playerNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참여 가능한 플레이어의 수는 2명이상 10명이하 입니다.");
    }

    @Test
    @DisplayName("중복된 사람의 이름이 있으면 예외를 던진다.")
    void throws_exception_when_existing_duplicated_name() {
        // given
        String duplicatedName = "pobi";
        List<String> playerNames = List.of(duplicatedName, duplicatedName);

        // when & then
        assertThatThrownBy(() -> new Players(playerNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참가한 플레이어의 이름 중 중복된 이름이 존재하면 안됩니다.");
    }

    @Test
    @DisplayName("참여한 플레이어의 수를 반환하다.")
    void returns_number_of_players() {
        // given
        String playerHavingLongestName = "dolbi";
        List<String> playerNames = List.of(firstPlayerName, secondPlayerName, playerHavingLongestName);
        Players players = new Players(playerNames);
        int expectedResult = players.getPlayers().size();

        // when
        int numberOfPlayer = players.findNumberOfPlayers();

        // then
        assertThat(numberOfPlayer).isEqualTo(expectedResult);
    }
}
