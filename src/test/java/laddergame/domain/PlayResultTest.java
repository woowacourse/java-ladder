package laddergame.domain;

import laddergame.domain.generator.CustomLineGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayResultTest {
    @Test
    void 플레이어_순서가_올바르게_바뀌는지_테스트() {
        PlayerResult playerResult = new PlayerResult(Arrays.asList(new Player(new PlayerName("a")), new Player(new PlayerName("b"))));
        List<Line> lines = Arrays.asList(new CustomLineGenerator(Arrays.asList(true)).makeLine(2));
        Ladder ladder = new Ladder(lines, lines.size());

        playerResult.playLadder(ladder);

        assertThat(playerResult.getPlayers().get(0)).isEqualTo(new Player(new PlayerName("b")));
        assertThat(playerResult.getPlayers().get(1)).isEqualTo(new Player(new PlayerName("a")));
    }
}
