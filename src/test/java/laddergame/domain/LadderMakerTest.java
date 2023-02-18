package laddergame.domain;

import laddergame.util.RandomBooleanGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

class LadderMakerTest {

    @Test
    @DisplayName("사다리 생성 테스트")
    void makeLadderTest() {
        int playerCount = 4;
        LadderHeight ladderHeight = new LadderHeight(5);
        LadderMaker randomLadderMaker = new LadderMaker(new RandomBooleanGenerator());
        Ladder ladder = randomLadderMaker.make(playerCount, ladderHeight);

        int expectedLadderSize = 5;
        int expectedLineSize = 3;
        assertSoftly(softly -> {
            softly.assertThat(ladder.getLadder()).hasSize(expectedLadderSize);
            softly.assertThat(ladder.getLadder().get(0).getLine()).hasSize(expectedLineSize);
        });
    }

}
