package ladder.domain.resource.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.resource.line.Line;
import ladder.domain.resource.line.LineGenerator;
import ladder.domain.resource.line.LineGeneratorImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @DisplayName("비어있는 사다리를 만들 경우 예외가 발생한다.")
    @Test
    void newLadderByEmpty() {
        //given
        List<Line> emptyLines = new ArrayList<>();

        //when, then
        assertThatThrownBy(() -> new Ladder(emptyLines))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 라인이 없어 사다리 생성이 불가능합니다.");
    }

    @DisplayName("비어있는 라인으로 사다리를 만들 경우 예외가 발생한다.")
    @Test
    void newLadderByEmptyLine() {
        //given
        LineGenerator lineGenerator = new LineGeneratorImpl();
        Line line = lineGenerator.generateLine();

        //when
        assertThat(line.isEmpty()).isTrue();

        //then
        assertThatThrownBy(() -> new Ladder(List.of(line)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 방향 정보가 없는 라인으로 사다리 생성이 불가능힙니다.");
    }

    @DisplayName("사다리의 모든 라인의 너비가 동일하지 않은 경우 예외가 발생한다.")
    @Test
    void newLadderByConsistentLineSize() {
        //given
        LineGenerator lineGenerator = new LineGeneratorImpl();

        Line lineA = lineGenerator.generateLine();
        lineGenerator.insertDirectionIntoLine(lineA, 2);

        Line lineB = lineGenerator.generateLine();
        lineGenerator.insertDirectionIntoLine(lineB, 3);

        //when, then
        assertThatThrownBy(() -> new Ladder(List.of(lineA, lineB)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 사다리의 모든 라인의 너비는 동일해야 합니다.");
    }

    @DisplayName("사다리의 높이(세로)를 반환한다.")
    @Test
    void getHeight() {
        //given
        int height = 2;
        LadderGenerator ladderGenerator = new LadderGenerator(new LineGeneratorImpl());
        Ladder ladder = ladderGenerator.generate(height, 2);

        //when
        int returnedHeight = ladder.getHeight();

        //then
        assertThat(returnedHeight).isEqualTo(height);
    }

    @DisplayName("사다리의 넓이(가로)를 반환한다.")
    @Test
    void getWidth() {
        //given
        int width = 2;
        LadderGenerator ladderGenerator = new LadderGenerator(new LineGeneratorImpl());
        Ladder ladder = ladderGenerator.generate(2, width);

        //when
        int returnedWidth = ladder.getWidth();

        //then
        assertThat(returnedWidth).isEqualTo(width);
    }
}

