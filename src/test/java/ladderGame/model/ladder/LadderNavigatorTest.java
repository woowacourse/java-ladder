package ladderGame.model.ladder;

import ladderGame.dto.DrawnLadder;
import ladderGame.dto.DrawnLadderRow;
import ladderGame.model.ladder.LadderNavigator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderNavigatorTest {

    @Test
    void navigate_다리없는_사다리() {
        DrawnLadder drawnLadder = new DrawnLadder(Arrays.asList(
                new DrawnLadderRow(Arrays.asList(false, false)),
                new DrawnLadderRow(Arrays.asList(false, false)),
                new DrawnLadderRow(Arrays.asList(false, false))));

        List<Integer> inputs = Arrays.asList(0, 1, 2);
        List<Integer> outputs = Arrays.asList(0, 1, 2);

        for (int i = 0; i < inputs.size(); i++) {
            int input = inputs.get(i);
            int output = outputs.get(i);
            assertThat(LadderNavigator.navigate(drawnLadder, input)).isEqualTo(output);
        }
    }

    @Test
    void navigate_다리있는_사다리() {
        DrawnLadder drawnLadder = new DrawnLadder(Arrays.asList(
                new DrawnLadderRow(Arrays.asList(true, false)),
                new DrawnLadderRow(Arrays.asList(false, true)),
                new DrawnLadderRow(Arrays.asList(false, false))));

        List<Integer> inputs = Arrays.asList(0, 1, 2);
        List<Integer> outputs = Arrays.asList(2, 0, 1);

        for (int i = 0; i < inputs.size(); i++) {
            int input = inputs.get(i);
            int output = outputs.get(i);
            assertThat(LadderNavigator.navigate(drawnLadder, input)).isEqualTo(output);
        }
    }

    @Test
    void navigate_다리많이있는_사다리() {
                //        |     |     |     |-----|
                //        |     |-----|     |-----|
                //        |-----|     |-----|     |
                //        |     |-----|     |-----|
                //        |-----|     |     |-----|
                //        |     |     |-----|     |
        DrawnLadder drawnLadder = new DrawnLadder(Arrays.asList(
                new DrawnLadderRow(Arrays.asList(false, false, false, true)),
                new DrawnLadderRow(Arrays.asList(false, true, false, true)),
                new DrawnLadderRow(Arrays.asList(true, false, true, false)),
                new DrawnLadderRow(Arrays.asList(false, true, false, true)),
                new DrawnLadderRow(Arrays.asList(true, false, false, true)),
                new DrawnLadderRow(Arrays.asList(false, false, true, false))
        ));

        List<Integer> inputs = Arrays.asList(0, 1, 2, 3, 4);
        List<Integer> outputs = Arrays.asList(3, 2, 1, 0, 4);

        for (int i = 0; i < inputs.size(); i++) {
            int input = inputs.get(i);
            int output = outputs.get(i);
            assertThat(LadderNavigator.navigate(drawnLadder, input)).isEqualTo(output);
        }
    }

}