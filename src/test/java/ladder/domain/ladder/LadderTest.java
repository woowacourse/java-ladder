package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import java.util.List;
import ladder.domain.generator.BooleanGenerator;
import ladder.domain.generator.RandomBooleanGenerator;
import ladder.mock.MockBooleanGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    @DisplayName("사다리 생성자 테스트")
    void testConstruct() {
        BooleanGenerator booleanGenerator = new RandomBooleanGenerator();
        Ladder ladder = new Ladder(4, 5, booleanGenerator);

        assertThat(ladder).extracting("playerCount")
                .isEqualTo(4);
        assertThat(ladder).extracting("height")
                .isEqualTo(5);
    }

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
