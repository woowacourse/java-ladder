package laddergame.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlayerGeneratorTest {
    @Test
    void 제대로_player리스트_반환하는지_테스트() {
        /*List<String> names = Arrays.asList("a", "b", "c");
        assertThat(PlayerGenerator.createPlayer(names)).isEqualTo(Arrays.asList(new Player("a"), new Player("b"), new Player("c")));*/

        assertThat(PlayerGenerator.createPlayer("a,b,c")).isEqualTo(Arrays.asList(new Player("a"), new Player("b"), new Player("c")));
    }
}
