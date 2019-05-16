package ladderGame;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderRowTest {

    @Test
    void canDraw_그릴수있는위치() {
        LadderRow ladderRow = new LadderRow(Arrays.asList(false));

        assertThat(ladderRow.canDraw(0)).isTrue();
    }

    @Test
    void canDraw_이미_그려진_위치() {
        LadderRow ladderRow = new LadderRow(Arrays.asList(false, false, true, false));

        assertThat(ladderRow.canDraw(2)).isFalse();
    }

    @Test
    void canDraw_그려진_위치_옆위치() {
        List<List<Boolean>> inputs = Arrays.asList(
                Arrays.asList(true, false, false),
                Arrays.asList(false, false, true)
        );

        for (List<Boolean> input : inputs) {
            LadderRow ladderRow = new LadderRow(input);
            assertThat(ladderRow.canDraw(1)).isFalse();
        }
    }

    @Test
    void canDraw_범위를_넘어선_위치() {
        List<Boolean> bridges = Arrays.asList(false, false, false);
        LadderRow ladderRow = new LadderRow(bridges);
        List<Integer> inputs = Arrays.asList(-1, bridges.size());


        for (Integer input : inputs) {
            assertThrows(IndexOutOfBoundsException.class, () -> ladderRow.canDraw(input));
        }
    }

    @Test
    void Draw_올바른_위치() {
        List<Boolean> bridges = Arrays.asList(false, false, false);
        List<Integer> inputs = Arrays.asList(0, bridges.size() - 1);
        List<DrawnLadderRow> outputs = Arrays.asList(
                new DrawnLadderRow(Arrays.asList(true, false, false)),
                new DrawnLadderRow(Arrays.asList(false, false, true))
        );


        for (int i = 0; i < inputs.size(); i++) {
            LadderRow ladderRow = new LadderRow(bridges);
            Integer input = inputs.get(i);
            DrawnLadderRow output = outputs.get(i);

            ladderRow.draw(input);
            assertThat(ladderRow.drawn()).isEqualTo(output);
        }
    }
}
