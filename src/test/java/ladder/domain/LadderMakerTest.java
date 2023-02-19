package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderMakerTest {

    @Test
    @DisplayName("주어진 사다리 속성대로 사다리가 생성된다.")
    void makeLadderTest() {
        LadderProperty ladderProperty = new LadderProperty(3, 4);
        LadderMaker ladderMaker = new LadderMaker(ladderProperty);

        Ladder ladder = ladderMaker.generate();
        List<Line> lines = ladder.getLines();
        List<ConnectionStatus> lineStatus = lines.get(0).getLineStatus();

        assertThat(lines.size()).isEqualTo(4);
        assertThat(lineStatus.size()).isEqualTo(3);
    }
}
