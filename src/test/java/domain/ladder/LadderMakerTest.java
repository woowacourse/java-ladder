package domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderMakerTest {

    @Test
    @DisplayName("사다리 높이 만큼 Line을 생성한다.")
    void createLinesWithHeight() {
        List<Line> ladder = new LadderMaker(5, new Height(10)).getLines();
        assertThat(ladder.size()).isEqualTo(10);
    }

}