package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        List<String> names = List.of("아톰", "산초");

        Players players = new Players(names);
    }

    @DisplayName("사람들의 이름을 받아 사람 리스트로 변환한다.")
    @Test
    void mapToPlayer() {
        List<String> names = List.of("아톰", "산초");

        Players players = new Players(names);

        List<Player> result = players.getPlayers();

        assertThat(result)
                .containsExactly(new Player("아톰"), new Player("산초"));
    }

    @DisplayName("사용자는 최소 2명이어야 한다.")
    @Test
    void checkPlayerSize() {
        List<String> names = List.of("아톰");

        assertThatThrownBy(() -> new Players(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 사용자는 허용하지 않는다.")
    @Test
    void checkDuplicated() {
        List<String> names = List.of("아톰", "산초", "산초");

        assertThatThrownBy(() -> new Players(names))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
