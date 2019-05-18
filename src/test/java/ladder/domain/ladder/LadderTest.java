package ladder.domain.ladder;

import ladder.domain.rule.LadderRule;
import ladder.domain.rule.RandomPointLadderRule;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderTest {
    int countPerson;
    int ladderHeight;
    Ladder ladder;

    @BeforeEach
    public void setup() {
        countPerson = 3;
        ladderHeight = 5;
        ladder = LadderGenerator.generate(countPerson, ladderHeight, new RandomPointLadderRule());
    }

    @Test
    public void 사다리생성확인() {
        assertThat(ladder.getLines().size()).isEqualTo(ladderHeight);
    }

    @Test
    public void 라인너비주입확인() {
        for (Line line : ladder.getLines()) {
            assertThat(line.getPointDTO().size()).isEqualTo(countPerson);
        }
    }

    @Test
    public void 최소높이테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Ladder(Arrays.asList());
        });
    }

    @Test
    public void 도착점찾기모두True() {
        Ladder ladder = LadderGenerator.generate(3, 3, new ForcedTrueRule());
        assertThat(ladder.getEndPoint(0)).isEqualTo(1);
    }

    @Test
    public void 도착점찾기모두교차() {
        Ladder ladder = LadderGenerator.generate(4, 3, new ForcedRule());
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
        return num != 5;
    }
}
