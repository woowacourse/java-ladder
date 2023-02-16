package domain.service;

import domain.model.Ladder;
import domain.vo.Height;
import domain.vo.LineCount;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderMakerTest {

    @Test
    void ladderMake() {
        LadderMaker ladderMaker = new LadderMaker(new RandomBooleanGenerator());
        Height height = new Height(5);
        LineCount lineCount = new LineCount(5);
        Ladder ladder = ladderMaker.make(height, lineCount);
        assertThat(ladder.getHeight()).isEqualTo(height);
        assertThat(ladder.getLineCount()).isEqualTo(lineCount);
    }
}
