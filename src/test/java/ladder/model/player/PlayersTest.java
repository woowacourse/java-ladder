package ladder.model.player;

import ladder.model.player.Players;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {
    List<String> names;

    @BeforeEach
    void setup() {
        names = Arrays.stream("bmo,pobi".split(",")).collect(Collectors.toList());
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