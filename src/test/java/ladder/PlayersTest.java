package ladder;

import ladder.model.Players;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {
    String[] names;

    @BeforeEach
    void setup() {
        names = new String[]{"bmo", "pobi"};
    }

    @Test
    void Players에_포함된_이름일_때_검증() {
        Players players = new Players(names);
        assertThat(players.isContains("bmo")).isTrue();
    }

    @Test
    void Players에_포함되지_않은_이름일_때_검증() {
        Players players = new Players(names);
        assertThat(players.isContains("crong")).isFalse();
    }
}