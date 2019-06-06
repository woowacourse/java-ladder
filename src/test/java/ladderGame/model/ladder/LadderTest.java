package ladderGame.model.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LadderTest {
    // |---|
    @Test
    void 크기1by1인_사다리에서_하나_draw() {

        RandomBridgeGenerator randomBridgeGenerator = mock(RandomBridgeGenerator.class);
        when(randomBridgeGenerator.generateRandomBridgeCount()).thenReturn(1);
        when(randomBridgeGenerator.generateRandomBridgeLocation()).thenReturn(new Location(0, 0));

        Ladder ladder = new Ladder(randomBridgeGenerator, 1, 2);

        assertThat(ladder.getDirection(0, 0)).isEqualTo(Direction.RIGHT);
    }

    // |---|---|   |
    @Test
    void 크기1by2인_사다리에서_두개_모두_draw() {
        RandomBridgeGenerator randomBridgeGenerator = mock(RandomBridgeGenerator.class);
        when(randomBridgeGenerator.generateRandomBridgeCount()).thenReturn(2);
        when(randomBridgeGenerator.generateRandomBridgeLocation())
                .thenReturn(new Location(0, 0))
                .thenReturn(new Location(0, 1))
                .thenReturn(new Location(0, 2));

        Ladder ladder = new Ladder(randomBridgeGenerator, 1, 4);
        assertThat(ladder.getDirection(0, 1)).isEqualTo(Direction.LEFT);
    }

    // |   |   |---|---|
    @Test
    void 크기1by4인_사다리에서_네개_중_두개를_연속되게_draw() {
        RandomBridgeGenerator randomBridgeGenerator = mock(RandomBridgeGenerator.class);
        when(randomBridgeGenerator.generateRandomBridgeCount()).thenReturn(2);
        when(randomBridgeGenerator.generateRandomBridgeLocation())
                .thenReturn(new Location(0, 2))
                .thenReturn(new Location(0, 3))
                .thenReturn(new Location(0, 0));

        Ladder ladder = new Ladder(randomBridgeGenerator, 1, 5);

        assertThat(ladder.getDirection(0, 4)).isEqualTo(Direction.STRAIGHT);
    }

    // |   |   |
    @Test
    void 크기1by2인_사다리에서_다리_없을_때_결과값() {
        RandomBridgeGenerator randomBridgeGenerator = mock(RandomBridgeGenerator.class);
        when(randomBridgeGenerator.generateRandomBridgeCount()).thenReturn(0);

        Ladder ladder = new Ladder(randomBridgeGenerator, 1, 3);

        assertThat(ladder.getArrivialIndex(0)).isEqualTo(0);
        assertThat(ladder.getArrivialIndex(1)).isEqualTo(1);
        assertThat(ladder.getArrivialIndex(2)).isEqualTo(2);
    }

    // |   |---|
    @Test
    void 크기1by2인_사다리에서_다리_하나_일때_결과값() {
        RandomBridgeGenerator randomBridgeGenerator = mock(RandomBridgeGenerator.class);
        when(randomBridgeGenerator.generateRandomBridgeCount()).thenReturn(1);
        when(randomBridgeGenerator.generateRandomBridgeLocation()).thenReturn(new Location(0, 1));

        Ladder ladder = new Ladder(randomBridgeGenerator, 1, 3);


        assertThat(ladder.getArrivialIndex(0)).isEqualTo(0);
        assertThat(ladder.getArrivialIndex(1)).isEqualTo(2);
        assertThat(ladder.getArrivialIndex(2)).isEqualTo(1);
    }

    // |   |---|
    // |---|   |
    @Test
    void 크기2by2인_사다리에서_다리_두개_일때_결과값() {
        RandomBridgeGenerator randomBridgeGenerator = mock(RandomBridgeGenerator.class);
        when(randomBridgeGenerator.generateRandomBridgeCount()).thenReturn(2);
        when(randomBridgeGenerator.generateRandomBridgeLocation())
                .thenReturn(new Location(0, 1))
                .thenReturn(new Location(1, 0));

        Ladder ladder = new Ladder(randomBridgeGenerator, 2, 3);


        assertThat(ladder.getArrivialIndex(0)).isEqualTo(1);
        assertThat(ladder.getArrivialIndex(1)).isEqualTo(2);
        assertThat(ladder.getArrivialIndex(2)).isEqualTo(0);
    }

    // |   |---|   |
    // |---|   |   |
    // |---|   |---|
    @Test
    void 크기3by3인_사다리에서_다리_네개_일때_결과값() {
        RandomBridgeGenerator randomBridgeGenerator = mock(RandomBridgeGenerator.class);
        when(randomBridgeGenerator.generateRandomBridgeCount()).thenReturn(4);
        when(randomBridgeGenerator.generateRandomBridgeLocation())
                .thenReturn(new Location(0, 1))
                .thenReturn(new Location(1, 0))
                .thenReturn(new Location(2, 0))
                .thenReturn(new Location(2, 2));

        Ladder ladder = new Ladder(randomBridgeGenerator, 3, 4);

        assertThat(ladder.getArrivialIndex(0)).isEqualTo(0);
        assertThat(ladder.getArrivialIndex(1)).isEqualTo(3);
        assertThat(ladder.getArrivialIndex(2)).isEqualTo(1);
        assertThat(ladder.getArrivialIndex(3)).isEqualTo(2);
    }

    // |   |---|   |
    // |---|   |   |
    // |---|   |---|
    @Test
    void 크기3by3인_사다리에서_다리_네개_일때_getBridgeNumber() {
        RandomBridgeGenerator randomBridgeGenerator = mock(RandomBridgeGenerator.class);
        when(randomBridgeGenerator.generateRandomBridgeCount()).thenReturn(4);
        when(randomBridgeGenerator.generateRandomBridgeLocation())
                .thenReturn(new Location(0, 1))
                .thenReturn(new Location(1, 0))
                .thenReturn(new Location(2, 0))
                .thenReturn(new Location(2, 2));

        Ladder ladder = new Ladder(randomBridgeGenerator, 3, 4);
        assertThat(ladder.getBridgeNumber()).isEqualTo(4);
    }

}
