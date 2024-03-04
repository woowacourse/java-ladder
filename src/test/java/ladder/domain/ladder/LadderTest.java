package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.line.Line;
import ladder.domain.line.LineGenerator;
import ladder.domain.line.RandomLineGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderTest {

    @DisplayName("라인의 수가 1~50이 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 51})
    void newLadderByByOutOfSize(int count) {
        //given
        List<Line> lines = generateLines(count);

        //when, then
        assertThatThrownBy(() -> new Ladder(lines))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 라인은 1~50개 까지만 등록 가능합니다.");
    }

    @DisplayName("사다리의 모든 라인의 너비가 동일하지 않은 경우 예외가 발생한다.")
    @Test
    void newLadderByConsistentLineSize() {
        //given
        LineGenerator lineGenerator = new RandomLineGenerator();

        Line lineA = lineGenerator.generateLine(2);
        Line lineB = lineGenerator.generateLine(3);

        //when, then
        assertThatThrownBy(() -> new Ladder(List.of(lineA, lineB)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 사다리의 모든 라인의 너비는 동일해야 합니다.");
    }

    @DisplayName("사다리의 높이(라인 수)를 반환한다.")
    @Test
    void getHeight() {
        //given
        int numberOfLines = 2;
        List<Line> lines = generateLines(numberOfLines);
        Ladder ladder = new Ladder(lines);

        //when
        int returnedHeight = ladder.getHeight();

        //then
        assertThat(returnedHeight).isEqualTo(numberOfLines);
    }

    @DisplayName("사다리의 넓이(라인의 방향 수)를 반환한다.")
    @Test
    void getWidth() {
        //given
        int numberOfDirections = 2;
        LineGenerator lineGenerator = new RandomLineGenerator();
        Line line = lineGenerator.generateLine(numberOfDirections);

        Ladder ladder = new Ladder(List.of(line));

        //when
        int returnedWidth = ladder.getWidth();

        //then
        assertThat(returnedWidth).isEqualTo(numberOfDirections);
    }

    private List<Line> generateLines(int count) {
        List<Line> lines = new ArrayList<>();
        LineGenerator lineGenerator = new RandomLineGenerator();
        for (int i = 0; i < count; i++) {
            lines.add(lineGenerator.generateLine(2));
        }

        return lines;
    }
}

