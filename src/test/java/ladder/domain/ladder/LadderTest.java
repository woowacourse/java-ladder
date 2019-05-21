package ladder.domain.ladder;

import ladder.domain.rule.RandomPointLadderRule;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderTest {
    private int countPerson;
    private int ladderHeight;
    private Ladder ladder;

    @BeforeEach
    void setup() {
        countPerson = 3;
        ladderHeight = 5;
        ladder = LadderGenerator.generate(countPerson, ladderHeight, new RandomPointLadderRule());
    }

    @Test
    void 사다리생성확인() {
        assertThat(ladder.getLines().size()).isEqualTo(ladderHeight);
    }

    @Test
    void 사다리생성오류() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Ladder(null);
        });
    }

    @Test
    void 라인너비주입확인() {
        for (Line line : ladder.getLines()) {
            assertThat(line.getPointDTO().size()).isEqualTo(countPerson);
        }
    }

    @Test
    void 최소높이테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Ladder(Arrays.asList());
        });
    }

    @Test
    void 도착점찾기모두True() {
        Ladder ladder = LadderGenerator.generate(3, 3, new ForcedTrueRule());
        assertThat(ladder.getEndPoint(0)).isEqualTo(1);
    }

    @Test
    void 도착점찾기모두교차() {
        Ladder ladder = LadderGenerator.generate(4, 3, new ForcedRule());
        assertThat(ladder.getEndPoint(0)).isEqualTo(3);
        assertThat(ladder.getEndPoint(1)).isEqualTo(1);
        assertThat(ladder.getEndPoint(2)).isEqualTo(2);
    }
}

