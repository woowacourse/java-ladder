package ladder.domain.ladder;

import ladder.domain.ladder.line.LineDTO;
import ladder.domain.rule.LadderRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderTest {
    int countPerson;
    int ladderHeight;
    List<LineDTO> lines;

    @BeforeEach
    public void setup() {
        countPerson = 3;
        ladderHeight = 5;
        lines = new Ladder(ladderHeight, countPerson).getLineDTO();
    }

    @Test
    public void 사다리생성확인() {
        assertThat(lines.size()).isEqualTo(ladderHeight);
    }

    @Test
    public void 라인너비주입확인() {
        for (int i = 0; i < lines.size(); i++) {
            assertThat(lines.get(i).getPoints().size()).isEqualTo(countPerson);
        }
    }

    @Test
    public void 최소높이테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Ladder(0, 100);
        });
    }

    @Test
    public void 도착점찾기모두True() {
        int i = 0;
        Ladder ladder = new Ladder(5, 2, new ForcedTrueRule());
        assertThat(ladder.getEndPoint(0)).isEqualTo(1);
    }

    @Test
    public void 도착점찾기모두교차() {
        Ladder ladder = new Ladder(3, 4, new ForcedRule());
        assertThat(ladder.getEndPoint(0)).isEqualTo(3);
        assertThat(ladder.getEndPoint(1)).isEqualTo(1);
        assertThat(ladder.getEndPoint(2)).isEqualTo(2);
    }
}

class ForcedRule implements LadderRule {
    static int num = 0;

    @Override
    public boolean isAvailablePoint() {
        num++;
        return num != 3;
    }
}
