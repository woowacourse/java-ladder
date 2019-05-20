package ladderGame.model.ladder;

import ladderGame.model.ladder.Ladder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderTest {
    // |---|
    @Test
    void 크기1by1인_사다리에서_하나_draw() {
        Ladder ladder = new Ladder(1,1);
        ladder.draw(0,0);

        assertThat(ladder.getPoint(0,0)).isEqualTo(true);
    }
    // |---|---|
    @Test
    void 크기1by2인_사다리에서_두개_모두_draw() {
        Ladder ladder = new Ladder(1, 2);
        ladder.draw(0,0);
        ladder.draw( 0,1);

        assertThat(ladder.getPoint(0,1)).isEqualTo(false);
    }
    // |---|---|---|
    @Test
    void 크기1by3인_사다리에서_세개_모두_draw() {
        Ladder ladder = new Ladder(1, 3);
        ladder.draw(0,0);
        ladder.draw( 0,2);
        ladder.draw(0,1);

        assertThat(ladder.getPoint(0,0)).isEqualTo(true);
        assertThat(ladder.getPoint(0,1)).isEqualTo(false);
        assertThat(ladder.getPoint(0,2)).isEqualTo(true);
    }

    // |   |   |---|---|
    @Test
    void 크기1by4인_사다리에서_네개_중_두개를_연속되게_draw() {
        Ladder ladder = new Ladder(1, 4);
        ladder.draw(0,2 );
        ladder.draw(0,3);

        assertThat(ladder.getPoint(0,2)).isEqualTo(true);
        assertThat(ladder.getPoint(0,3)).isEqualTo(false);
    }
    // |   |   |
    @Test
    void 크기1by2인_사다리에서_다리_없을_때_결과값() {
        Ladder ladder = new Ladder(1,2);

        assertThat(ladder.getArrivialIndex(0)).isEqualTo(0);
        assertThat(ladder.getArrivialIndex(1)).isEqualTo(1);
        assertThat(ladder.getArrivialIndex(2)).isEqualTo(2);
    }

    // |   |---|
    @Test
    void 크기1by2인_사다리에서_다리_하나_일때_결과값() {
        Ladder ladder = new Ladder(1,2);
        ladder.draw(0,1);

        assertThat(ladder.getArrivialIndex(0)).isEqualTo(0);
        assertThat(ladder.getArrivialIndex(1)).isEqualTo(2);
        assertThat(ladder.getArrivialIndex(2)).isEqualTo(1);
    }

    // |   |---|
    // |---|   |
    @Test
    void 크기2by2인_사다리에서_다리_두개_일때_결과값() {
        Ladder ladder = new Ladder(2,2);
        ladder.draw(0,1);
        ladder.draw(1, 0);

        assertThat(ladder.getArrivialIndex(0)).isEqualTo(1);
        assertThat(ladder.getArrivialIndex(1)).isEqualTo(2);
        assertThat(ladder.getArrivialIndex(2)).isEqualTo(0);
    }

    @Test
    void 크기3by3인_사다리에서_다리_네개_일떼_결과값() {
        Ladder ladder = new Ladder(3,3);
        ladder.draw(0,1);
        ladder.draw(1,0);
        ladder.draw(2,0);
        ladder.draw(2,2);

        assertThat(ladder.getArrivialIndex(0)).isEqualTo(0);
        assertThat(ladder.getArrivialIndex(1)).isEqualTo(3);
        assertThat(ladder.getArrivialIndex(2)).isEqualTo(1);
        assertThat(ladder.getArrivialIndex(3)).isEqualTo(2);
    }

}
