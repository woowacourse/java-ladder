package ladderGame.model.ladder;

import ladderGame.model.ladder.direction.Direction;
import ladderGame.model.ladder.direction.DirectionGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderTest {
    // |---|
    @Test
    void 크기1by1인_사다리에서_하나_draw() {
        DirectionGenerator testDirectionGenerator = new TestRightDirectionGenerator();
        Ladder ladder = new Ladder(testDirectionGenerator, 1, 2);

        assertThat(ladder.getDirection(0, 0)).isEqualTo(Direction.RIGHT);
    }

    // |   |   |
    @Test
    void 크기1by2인_사다리에서_다리_없을_때_결과값() {
        DirectionGenerator testDirectionGenerator = new TestStraightDirectionGenerator();
        Ladder ladder = new Ladder(testDirectionGenerator, 1, 3);

        assertThat(ladder.getArrivialIndex(0)).isEqualTo(0);
        assertThat(ladder.getArrivialIndex(1)).isEqualTo(1);
        assertThat(ladder.getArrivialIndex(2)).isEqualTo(2);
    }

    // |---|   |
    @Test
    void 크기1by2인_사다리에서_다리_하나_일때_결과값() {
        DirectionGenerator testDirectionGenerator = new TestRightDirectionGenerator();
        Ladder ladder = new Ladder(testDirectionGenerator, 1, 3);

        assertThat(ladder.getArrivialIndex(0)).isEqualTo(1);
        assertThat(ladder.getArrivialIndex(1)).isEqualTo(0);
        assertThat(ladder.getArrivialIndex(2)).isEqualTo(2);
    }

    // |---|   |
    // |---|   |
    @Test
    void 크기2by2인_사다리에서_다리_두개_일때_결과값() {
        DirectionGenerator testDirectionGenerator = new TestRightDirectionGenerator();
        Ladder ladder = new Ladder(testDirectionGenerator, 2, 3);

        assertThat(ladder.getArrivialIndex(0)).isEqualTo(0);
        assertThat(ladder.getArrivialIndex(1)).isEqualTo(1);
        assertThat(ladder.getArrivialIndex(2)).isEqualTo(2);
    }

    // |---|   |---|
    // |---|   |---|
    // |---|   |---|
    @Test
    void 크기3by3인_사다리에서_다리_네개_일때_결과값() {
        DirectionGenerator testDirectionGenerator = new TestRightDirectionGenerator();
        Ladder ladder = new Ladder(testDirectionGenerator, 3, 4);

        assertThat(ladder.getArrivialIndex(0)).isEqualTo(1);
        assertThat(ladder.getArrivialIndex(1)).isEqualTo(0);
        assertThat(ladder.getArrivialIndex(2)).isEqualTo(3);
        assertThat(ladder.getArrivialIndex(3)).isEqualTo(2);
    }

    // |---|   |---|
    // |---|   |---|
    // |---|   |---|
    @Test
    void 크기3by3인_사다리에서_다리_네개_일때_getBridgeNumber() {
        DirectionGenerator testDirectionGenerator = new TestRightDirectionGenerator();
        Ladder ladder = new Ladder(testDirectionGenerator, 3, 4);
        assertThat(ladder.getBridgeNumber()).isEqualTo(6);
    }

}
