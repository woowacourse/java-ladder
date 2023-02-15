package domain.service;

import domain.model.Ladder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderMakerTest {

    @Test
    void ladderMake() {
        LadderMaker ladderMaker = new LadderMaker(new RandomBooleanGenerator());
        int height = 5;
        int lineCount = 5;
        Ladder ladder = ladderMaker.make(height, lineCount);
        assertThat(ladder.getHeight()).isEqualTo(height);
        assertThat(ladder.getLineCount()).isEqualTo(lineCount);
    }
}
