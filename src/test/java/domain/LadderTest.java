package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        assertThatCode(() -> new Ladder(3, 2))
                .doesNotThrowAnyException();
    }

    @DisplayName("사다리의 높이는 1 이상만 허용한다.")
    @Test
    void checkLadderHeight() {
        assertThatThrownBy(() -> new Ladder(0, 2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사다리는 높이 만큼의 라인을 갖는다.")
    @Test
    void ladderHasLines() {
        int height = 3;
        Ladder ladder = new Ladder(height, 9);
        List<Line> lines = ladder.getLines();

        assertThat(lines).hasSize(height);
    }

    @DisplayName("사다리를 탈 수 있다.")
    @Test
    void climb() {
        // 0 1 2 3
        // | |-| |
        // | | |-|
        // 0 1 2 3
        Ladder ladder = createLadder();

        assertThat(ladder.climb(0)).isEqualTo(0);
        assertThat(ladder.climb(1)).isEqualTo(3);
        assertThat(ladder.climb(2)).isEqualTo(1);
        assertThat(ladder.climb(3)).isEqualTo(2);
    }

    private Ladder createLadder() {
        List<Stick> line1 = List.of(
                Stick.NOT_FILLED,
                Stick.FILLED,
                Stick.NOT_FILLED
        );

        List<Stick> line2 = List.of(
                Stick.NOT_FILLED,
                Stick.NOT_FILLED,
                Stick.FILLED
        );

        return new Ladder(List.of(new Line(line1), new Line(line2)));
    }
}
