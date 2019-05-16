package laddergame.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlayerGeneratorTest {
    @Test
    void 제대로_player리스트_반환하는지_테스트() {
        assertThat(PlayersGenerator.createPlayers("a,b,c")).isEqualTo(Arrays.asList(new Player("a"), new Player("b"), new Player("c")));
    }
}
