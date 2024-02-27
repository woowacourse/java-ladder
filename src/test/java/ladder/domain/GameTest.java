package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("게임")
public class GameTest {
    @Test
    @DisplayName("")
    void generateResultTest() {
        // given
        Ladder ladder = new Ladder(List.of(
                new Line(List.of(true, false, true)),
                new Line(List.of(false, true, false)),
                new Line(List.of(true, false, true))
        ));
        Game game = new Game(ladder);
        List<Integer> expected = List.of(3, 1, 2, 0);

        // when
        List<Integer> result = game.calculateResult();

        // then
        assertThat(result).isEqualTo(expected);
    }
}
