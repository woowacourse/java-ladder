package domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static domain.player.Players.MIN_PLAYER_SIZE_MESSAGE;
import static domain.player.Players.PLAYER_DUPLICATED_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayersTest {

    @DisplayName("사용자들의 이름을 받아 사용자 리스트를 생성한다.")
    @Test
    void convertToPlayer() {
        List<String> names = List.of("아톰", "산초");
        Players players = new Players(names);

        List<Player> result = players.getPlayers();

        assertThat(result).extracting(Player::getName)
                .contains("아톰", "산초");
    }

    @DisplayName("사용자는 최소 2명이어야 한다.")
    @Test
    void checkPlayerSize() {
        List<String> names = List.of("아톰");

        assertThatThrownBy(() -> new Players(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MIN_PLAYER_SIZE_MESSAGE);
    }

    @DisplayName("중복된 사용자는 허용하지 않는다.")
    @Test
    void checkDuplicated() {
        List<String> names = List.of("아톰", "산초", "산초");

        assertThatThrownBy(() -> new Players(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PLAYER_DUPLICATED_MESSAGE);
    }
}
