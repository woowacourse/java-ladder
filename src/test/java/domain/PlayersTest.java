package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        List<String> names = List.of("아톰", "산초");

        assertThatCode(() -> new Players(names))
                .doesNotThrowAnyException();
    }

    @DisplayName("사용자들의 이름을 받아 사용자 리스트로 변환한다.")
    @Test
    void mapToPlayer() {
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
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 사용자는 허용하지 않는다.")
    @Test
    void checkDuplicated() {
        List<String> names = List.of("아톰", "산초", "산초");

        assertThatThrownBy(() -> new Players(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주어진 이름을 가진 사용자의 위치를 알아낼 수 있다.")
    @Test
    void getPlayerColumn() {
        List<String> names = List.of("산초", "아톰", "망쵸");
        Players players = new Players(names);

        int column = players.findPlayerColumn("아톰");

        assertThat(column).isEqualTo(1);
    }

    @DisplayName("주어진 이름의 사용자가 존재하지 않으면 사용자의 위치를 알아낼 수 없다,.")
    @Test
    void notFoundPlayer() {
        List<String> names = List.of("산초", "아톰", "망쵸");
        Players players = new Players(names);

        assertThatThrownBy(() -> players.findPlayerColumn("네오"))
                .isInstanceOf(NoSuchElementException.class);
    }
}
