package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@SuppressWarnings({"NonAsciiCharacters"})
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RowGeneratorTest {

    private final ConnectionJudgement alwaysConnected = new MockConnectionJudgement(true);
    private final ConnectionJudgement alwaysDisConnected = new MockConnectionJudgement(false);

    @Test
    void generate_메서드를_호출하면_포인트가_최대한_연결된_사다리가_생성() {

        List<Point> points = RowGenerator.generate(5, alwaysConnected);
        assertAll(
                () -> assertThat(points)
                        .hasSize(5),
                () -> assertThat(points.get(0))
                        .isEqualTo(Point.RIGHT),
                () -> assertThat(points.get(1))
                        .isEqualTo(Point.LEFT),
                () -> assertThat(points.get(2))
                        .isEqualTo(Point.RIGHT),
                () -> assertThat(points.get(3))
                        .isEqualTo(Point.LEFT),
                () -> assertThat(points.get(4))
                        .isEqualTo(Point.NONE)
        );
    }

    @Test
    void generate_메서드를_호출하면_포인트가_전혀_연결되지_않은_사다리가_생성() {
        List<Point> points = RowGenerator.generate(3, alwaysDisConnected);
        assertAll(
                () -> assertThat(points)
                        .hasSize(3),
                () -> assertThat(points.get(0))
                        .isEqualTo(Point.NONE),
                () -> assertThat(points.get(1))
                        .isEqualTo(Point.NONE),
                () -> assertThat(points.get(2))
                        .isEqualTo(Point.NONE)
        );
    }
}
