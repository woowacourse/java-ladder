package laddergame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        assertThatCode(() -> {
            Height height = new Height(3);
            new Ladder(height, 2, new RandomStickGenerator());
        })
                .doesNotThrowAnyException();
    }

    @DisplayName("사다리는 높이 만큼의 라인을 갖는다.")
    @Test
    void ladderHasLines() {
        int height = 3;
        Height height1 = new Height(height);
        Ladder ladder = new Ladder(height1, 9, new RandomStickGenerator());
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

        assertThat(ladder.climb(new Column(0)).getValue()).isEqualTo(0);
        assertThat(ladder.climb(new Column(1)).getValue()).isEqualTo(3);
        assertThat(ladder.climb(new Column(2)).getValue()).isEqualTo(1);
        assertThat(ladder.climb(new Column(3)).getValue()).isEqualTo(2);
    }

    private Ladder createLadder() {
        List<Stick> sticks = List.of(
                Stick.NOT_FILLED,
                Stick.FILLED,
                Stick.NOT_FILLED,
                Stick.NOT_FILLED,
                Stick.NOT_FILLED,
                Stick.FILLED
        );

        Height height = new Height(2);
        return new Ladder(height, 4, new SimpleStickGenerator(sticks));
    }
}
