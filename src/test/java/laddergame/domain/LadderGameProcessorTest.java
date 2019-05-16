package laddergame.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class LadderGameProcessorTest {
    @Test
    void 스위치_매써드_테스트() {
        List<Player> inputs = Arrays.asList(new Player("a"), new Player("b"), new Player("c"), new Player("d"));

        LadderGameProcessor processor = new LadderGameProcessor(inputs);
        List<Boolean> instructions = Arrays.asList(true, false, true);

        assertThat(processor.switchPosition(instructions)).isEqualTo(Arrays.asList(new Player("b"), new Player("a"), new Player("d"), new Player("c")));

    }
}
