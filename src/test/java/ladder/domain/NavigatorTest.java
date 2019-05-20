package ladder.domain;

import ladder.domain.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NavigatorTest {

    @Test
    void navigate_다리없음() {
        DrawnLadder drawnLadder = new DrawnLadder(Arrays.asList(
                new DrawnHorizontalLine(Arrays.asList(Direction.NONE, Direction.NONE, Direction.NONE)),
                new DrawnHorizontalLine(Arrays.asList(Direction.NONE, Direction.NONE, Direction.NONE))));

        Position first = drawnLadder.createFirstColumnPosition();
        List<Position> inputs = Arrays.asList(first.plus(0), first.plus(1), first.plus(2));
        List<Position> outputs = Arrays.asList(first.plus(0), first.plus(1), first.plus(2));

        for (int i = 0; i < inputs.size(); i++) {
            Position input = inputs.get(i);
            Position output = outputs.get(i);

            assertThat(Navigator.navigate(drawnLadder, input)).isEqualTo(output);
        }
    }

    @Test
    void navigate_다리있음() {
        DrawnLadder drawnLadder = new DrawnLadder(Arrays.asList(
                new DrawnHorizontalLine(Arrays.asList(Direction.RIGHT, Direction.LEFT, Direction.NONE)),
                new DrawnHorizontalLine(Arrays.asList(Direction.NONE, Direction.RIGHT, Direction.LEFT)),
                new DrawnHorizontalLine(Arrays.asList(Direction.NONE, Direction.NONE, Direction.NONE))));
        Position first = drawnLadder.createFirstColumnPosition();
        List<Position> inputs = Arrays.asList(first.plus(0), first.plus(1), first.plus(2));
        List<Position> outputs = Arrays.asList(first.plus(2), first.plus(0), first.plus(1));

        for (int i = 0; i < inputs.size(); i++) {
            Position input = inputs.get(i);
            Position output = outputs.get(i);
            assertThat(Navigator.navigate(drawnLadder, input)).isEqualTo(output);
        }
    }

    @Test
    void navigate_다리많이있음() {
        //        |     |     |     |-----|
        //        |     |-----|     |-----|
        //        |-----|     |-----|     |
        //        |     |-----|     |-----|
        //        |-----|     |     |-----|
        //        |     |     |-----|     |
        DrawnLadder drawnLadder = new DrawnLadder(Arrays.asList(
                new DrawnHorizontalLine(Arrays.asList(Direction.NONE, Direction.NONE, Direction.NONE, Direction.RIGHT, Direction.LEFT)),
                new DrawnHorizontalLine(Arrays.asList(Direction.NONE, Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT)),
                new DrawnHorizontalLine(Arrays.asList(Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT, Direction.NONE)),
                new DrawnHorizontalLine(Arrays.asList(Direction.NONE, Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT)),
                new DrawnHorizontalLine(Arrays.asList(Direction.RIGHT, Direction.LEFT, Direction.NONE, Direction.RIGHT, Direction.LEFT)),
                new DrawnHorizontalLine(Arrays.asList(Direction.NONE, Direction.NONE, Direction.RIGHT, Direction.LEFT, Direction.NONE)))
        );

        Position first = drawnLadder.createFirstColumnPosition();
        List<Position> inputs = Arrays.asList(first.plus(0), first.plus(1), first.plus(2), first.plus(3), first.plus(4));
        List<Position> outputs = Arrays.asList(first.plus(3), first.plus(2), first.plus(1), first.plus(0), first.plus(4));

        for (int i = 0; i < inputs.size(); i++) {
            Position input = inputs.get(i);
            Position output = outputs.get(i);

            assertThat(Navigator.navigate(drawnLadder, input)).isEqualTo(output);
        }
    }
}