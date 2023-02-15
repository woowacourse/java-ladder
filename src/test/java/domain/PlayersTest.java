package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayersTest {

    @DisplayName("참여자가 20명을 넘을 수 없다.")
    @Test
    void playerSizeNotMoreThan20() {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            players.add(new Player("test"));
        }
        assertThatThrownBy(() -> {
            new Players(players);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참여자가 0명 이하일 수 없다.")
    @ValueSource(ints = {0, -1})
    @ParameterizedTest
    void playerSizeNotLessThan1() {
        List<Player> players = Collections.emptyList();
        assertThatThrownBy(() -> {
            new Players(players);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
