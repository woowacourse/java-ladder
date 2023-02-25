package domain.player;

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
        List<String> players = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            players.add(String.valueOf(i));
        }
        Assertions.assertThatThrownBy(() -> Players.generate(players))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어가 1명 미만일때 에러 확인")
    @ValueSource(ints = {0, 1})
    @ParameterizedTest
    void create1Player(int count) {
        List<String> players = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            players.add(String.valueOf(i));
        }
        Assertions.assertThatThrownBy(() -> Players.generate(players))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어 이름이 중복일때 에러 확인")
    @Test
    void duplicatePlayerName() {
        List<String> players =
                List.of("aa", "aa");
        Assertions.assertThatThrownBy(() -> Players.generate(players))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
