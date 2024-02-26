package ladder.domain.resource.ladder;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import ladder.domain.resource.direction.DirectionGeneratorImpl;
import ladder.domain.resource.line.Line;
import ladder.domain.resource.line.LineGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @DisplayName("사다리의 모든 라인의 너비가 동일하지 않은 경우 예외가 발생한다.")
    @Test
    void newLadderTest() {
        //given
        LineGenerator lineGenerator = new LineGenerator(new DirectionGeneratorImpl());
        Line lineA = lineGenerator.generate(2);
        Line lineB = lineGenerator.generate(3);

        //when, then
        assertThatThrownBy(() -> new Ladder(List.of(lineA, lineB)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 사다리의 모든 라인의 너비는 동일해야 합니다.");
    }
}
