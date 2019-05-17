package ladderGame.model.ladder;

import ladderGame.dto.DrawnLadder;
import ladderGame.dto.DrawnLadderRow;
import ladderGame.model.ladder.Ladder;
import ladderGame.model.ladder.LadderRow;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderTest {
    private final static int ROWS = 2;
    private final static int COLUMNS = 3;

    @Test
    void canDraw_그릴수있는위치() {

        Ladder ladder = new Ladder(Arrays.asList(
                new LadderRow(Arrays.asList(false, false, false)),
                new LadderRow(Arrays.asList(false, false, false))
        ));

        assertThat(ladder.canDraw(1, 1)).isTrue();
    }

    @Test
    void canDraw_이미_그려진_위치() {
        Ladder ladder = new Ladder(Arrays.asList(
                new LadderRow(Arrays.asList(false, false, false)),
                new LadderRow(Arrays.asList(false, true, false))
        ));

        assertThat(ladder.canDraw(1, 1)).isFalse();
    }

    @Test
    void canDraw_그려진_위치_옆위치() {
        List<List<LadderRow>> inputs = Arrays.asList(
                Arrays.asList(
                        new LadderRow(Arrays.asList(false, false, false)),
                        new LadderRow(Arrays.asList(true, false, false))
                ),
                Arrays.asList(
                        new LadderRow(Arrays.asList(false, false, false)),
                        new LadderRow(Arrays.asList(false, false, true))
                )
        );

        for (List<LadderRow> input : inputs) {
            Ladder ladder = new Ladder(input);

            assertThat(ladder.canDraw(1, 1)).isFalse();
        }
    }

    @Test
    void canDraw_범위를_넘어선_위치() {
        Ladder ladder = new Ladder(Arrays.asList(
                new LadderRow(Arrays.asList(false, false, false)),
                new LadderRow(Arrays.asList(false, true, false))
        ));

        List<List<Integer>> inputs = Arrays.asList(
                Arrays.asList(-1, 1),
                Arrays.asList(ROWS, 1),
                Arrays.asList(1, -1),
                Arrays.asList(1, COLUMNS)
        );

        for (List<Integer> input : inputs) {
            assertThrows(IndexOutOfBoundsException.class, () -> ladder.canDraw(input.get(0), input.get(1)));
        }
    }

    @Test
    void Draw_올바른_위치() {

        List<List<Integer>> inputs = Arrays.asList(
                Arrays.asList(0, 0),
                Arrays.asList(0, COLUMNS - 1),
                Arrays.asList(ROWS - 1, 0),
                Arrays.asList(ROWS - 1, COLUMNS - 1)
        );
        List<DrawnLadder> outputs = Arrays.asList(
                new DrawnLadder(Arrays.asList(
                        new DrawnLadderRow(Arrays.asList(true, false, false)),
                        new DrawnLadderRow(Arrays.asList(false, false, false)))),

                new DrawnLadder(Arrays.asList(
                        new DrawnLadderRow(Arrays.asList(false, false, true)),
                        new DrawnLadderRow(Arrays.asList(false, false, false)))),

                new DrawnLadder(Arrays.asList(
                        new DrawnLadderRow(Arrays.asList(false, false, false)),
                        new DrawnLadderRow(Arrays.asList(true, false, false)))),

                new DrawnLadder(Arrays.asList(
                        new DrawnLadderRow(Arrays.asList(false, false, false)),
                        new DrawnLadderRow(Arrays.asList(false, false, true))))
        );

        for (int i = 0; i < inputs.size(); i++) {
            Ladder ladder = new Ladder(Arrays.asList(
                    new LadderRow(Arrays.asList(false, false, false)),
                    new LadderRow(Arrays.asList(false, false, false))
            ));
            List<Integer> input = inputs.get(i);
            DrawnLadder output = outputs.get(i);

            ladder.draw(input.get(0), input.get(1));
            assertThat(ladder.drawn()).isEqualTo(output);
        }
    }

    @Test
    void countBridges() {
        Ladder ladder = new Ladder(Arrays.asList(
                new LadderRow(Arrays.asList(false, true, false)),
                new LadderRow(Arrays.asList(true, true, true))
        ));

        assertThat(ladder.countBridges()).isEqualTo(4);
    }
}
