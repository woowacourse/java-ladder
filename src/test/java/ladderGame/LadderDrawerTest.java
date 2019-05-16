package ladderGame;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderDrawerTest {
    private int ROWS = 7;
    private int COLUMNS = 5;
    private LadderFactory ladderFactory = new LadderFactory(new LadderRowFactory());

    @Test
    public void draw_특정개수() {
        int k = 10;
        Ladder ladder = ladderFactory.newInstance(ROWS, COLUMNS);
        LadderDrawer ladderDrawer = new LadderDrawer();

        ladderDrawer.draw(ladder, k);

        assertThat(ladder.countBridges()).isEqualTo(k);
    }
}