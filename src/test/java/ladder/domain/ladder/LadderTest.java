package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import java.util.List;
import ladder.domain.ladder.generator.RandomRungGenerator;
import ladder.domain.ladder.generator.RungGenerator;
import ladder.mock.MockRungGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    @DisplayName("사다리 생성 테스트")
    void testConstruct() {
        RungGenerator rungGenerator = new RandomRungGenerator();

        assertThatCode(() -> Ladder.of(3, 4, rungGenerator))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("사다리를 생성한다.")
    void testGenerateLadder() {
        int height = 3;
        int playerCount = 4;
        List<Rung> rungs = List.of(
                Rung.EXIST, Rung.EMPTY, Rung.EXIST,
                Rung.EMPTY, Rung.EXIST, Rung.EMPTY,
                Rung.EXIST, Rung.EMPTY, Rung.EMPTY);

        Ladder ladder = Ladder.of(height, playerCount, new MockRungGenerator(rungs));
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

    @Test
    @DisplayName("사다리의 높이가 범위를 벗어날 경우 예외를 발생한다")
    void testValidateHeightRange() {
        int height = 0;
        RungGenerator rungGenerator = new RandomRungGenerator();
        assertThatThrownBy(() -> Ladder.of(height, 4, rungGenerator))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시작 인덱스가 범위를 벗어날 경우 예외를 발생한다")
    void testValidateIndexRange() {
        RungGenerator rungGenerator = new RandomRungGenerator();
        Ladder ladder = Ladder.of(3, 4, rungGenerator);
        assertThatThrownBy(() -> ladder.findEndIndex(4))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
