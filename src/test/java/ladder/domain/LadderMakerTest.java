package ladder.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import ladder.util.RandomBooleanGenerator;

class LadderMakerTest {
    @RepeatedTest(100)
    @DisplayName("사다리에 가로 줄이 하나도 없는 경우는 없다.")
    void ladderTest() {
        Ladder ladder = LadderMaker.makeLadder(2, 1, new RandomBooleanGenerator());

        assertThat(
            ladder.getLadder()
                .stream()
                .allMatch(
                    footBars -> footBars.getFootBars().stream().allMatch(footBar -> footBar == Boolean.TRUE))).isTrue();
    }

}
