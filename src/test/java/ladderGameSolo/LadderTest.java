package ladderGameSolo;

import ladderGameSolo.domain.Ladder;
import ladderGameSolo.domain.Line;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    private List<Line> lines;
    private Ladder ladder;

    @BeforeEach
    void setUp() {
        lines = new ArrayList<>();
        lines.add(new Line(4));
        lines.add(new Line(4));
        lines.add(new Line(4));

        ladder = new Ladder(3,4);
    }

    @Test
    void 라인_사이즈() {
        assertThat(ladder.getLineSize()).isEqualTo(3);
    }

    @Test
    void 다음_인덱스_주기() {
         assertThat(ladder.getNextLine(3,2)).isEqualTo(2);
    }
}
