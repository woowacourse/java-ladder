package ladder.domain.ladder;

import ladder.mock.MockBooleanGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

class LadderTest {

    @Test
    @DisplayName("사다리를 생성한다.")
    void testGenerateLadder() {
        List<Boolean> rungExist = List.of(true, false, true, false, true, false, true, false, false);

        Ladder ladder = new Ladder(4, 3, new MockBooleanGenerator(rungExist));
        List<Line> lines = ladder.getLines();

        assertSoftly(softly -> {
            softly.assertThat(lines.get(0).getRungs())
                    .containsExactly(Rung.EXIST, Rung.EMPTY, Rung.EXIST);
            softly.assertThat(lines.get(1).getRungs())
                    .containsExactly(Rung.EMPTY, Rung.EXIST, Rung.EMPTY);
            softly.assertThat(lines.get(2).getRungs())
                    .containsExactly(Rung.EXIST, Rung.EMPTY, Rung.EMPTY);
        });
    }
}
