package laddergame.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlayerGeneratorTest {
    @Test
    void 제대로_player리스트_반환하는지_테스트() {
        List<Player> players = Arrays.asList(new Player(new PlayerName("a")), new Player(new PlayerName("b")), new Player(new PlayerName("c")));

        assertThat(PlayersGenerator.createPlayers("a,b,c")).isEqualTo(new PlayerGroup(players));
    }

    @Test
    void 정상적인_이름입력값을_입력했을때_PlayerGroup을_리턴하는지_테스트() {
        String input = "a,b,c";
        List<Player> players = Arrays.asList(new Player(new PlayerName("a")), new Player(new PlayerName("b")), new Player(new PlayerName("c")));

        assertThat(PlayersGenerator.createPlayers(input)).isEqualTo(new PlayerGroup(players));
    }
}
