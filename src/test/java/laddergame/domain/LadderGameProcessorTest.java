package laddergame.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class LadderGameProcessorTest {
    @Test
    void 스위치_매써드_테스트() {
        List<Player> inputs = Arrays.asList(new Player(new PlayerName("a")), new Player(new PlayerName("b")), new Player(new PlayerName("c")), new Player(new PlayerName("d")));

        GameProcessor processor = new GameProcessor(inputs);
        List<Line> ladder = Arrays.asList(
                new Line(Arrays.asList(true, false, true)),
                new Line(Arrays.asList(false, false, true))
        );

        assertThat(processor.processGame(ladder)).isEqualTo(Arrays.asList(new Player(new PlayerName("b")), new Player(new PlayerName("a")), new Player(new PlayerName("c")), new Player(new PlayerName("d"))));

    }
}
