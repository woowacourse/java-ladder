package ladder.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @Test
    void initTestA() {
        Ladder ladderA = new Ladder(10, 6, new Always());
        for (Level l : ladderA.getLevels()) {
            assertThat(new Level(ladderA.getWidth() - 1, new Always()).getVerticalLines()).isEqualTo(l.getVerticalLines());
        }
    }

    @Test
    void initTestN() {
        Ladder ladderN = new Ladder(12, 7, new Never());
        for (Level l : ladderN.getLevels()) {
            assertThat(new Level(ladderN.getWidth() - 1, new Never()).getVerticalLines()).isEqualTo(l.getVerticalLines());
        }
    }

    @Test
    void initTestO() {
        Ladder ladderO = new Ladder(7, 123, new OddOnly());
        for (Level l : ladderO.getLevels()) {
            assertThat(new Level(ladderO.getWidth() - 1, new OddOnly()).getVerticalLines()).isEqualTo(l.getVerticalLines());
        }
    }

    @Test
    void initTestE() {
        Ladder ladderE = new Ladder(116, 2, new EvenOnly());
        for (Level l : ladderE.getLevels()) {
            assertThat(new Level(ladderE.getWidth() - 1, new EvenOnly()).getVerticalLines()).isEqualTo(l.getVerticalLines());
        }
    }

    @Test
    void applyTest() {

    }
}