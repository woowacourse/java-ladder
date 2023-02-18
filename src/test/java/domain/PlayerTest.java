package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.ArrayList;
import java.util.List;


class PlayerTest {

    @DisplayName("플레이어가 12명 초과일때 에러 확인")
    @Test
    void create12Players() {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            players.add(new Player(String.valueOf(i)));
        }
        Assertions.assertThatThrownBy(() -> new Players(players))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어가 1명 미만일때 에러 확인")
    @ValueSource(ints = {0, 1})
    @ParameterizedTest
    void create1Player(int count) {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            players.add(new Player(String.valueOf(i)));
        }
        Assertions.assertThatThrownBy(() -> new Players(players))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어 이름이 중복일때 에러 확인")
    @Test
    void duplicatePlayerName() {
        List<Player> players = List.of(new Player("aa"), new Player("aa"));
        Assertions.assertThatThrownBy(() -> new Players(players))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
