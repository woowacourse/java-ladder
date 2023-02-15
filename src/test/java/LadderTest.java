import domain.Ladder;
import domain.Line;
import domain.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @Test
    @DisplayName("사다리는 높이를 입력받는다.")
    void ladderTest() {
        int height = 4;
        int personCount = 5;
        Assertions.assertDoesNotThrow(() -> new Ladder(height, personCount));
    }

    @Test
    @DisplayName("사다리의 높이로 음수가 들어오는 경우 예외를 발생시킨다.")
    void ladderHeightNonPositive() {
        int height = -1;
        int personCount = 5;
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Ladder(height, personCount));
    }

    //TODO : containsExactlyElementsOf 동작 확인 필요
    @Test
    @DisplayName("Ladder의 라인을 반환하는 메서드를 테스트")
    void getLinesTest() {
        List<Line> lines = new ArrayList<>();
        lines.add(new Line(List.of(Point.LINKED_POINT, Point.EMPTY_POINT, Point.LINKED_POINT)));
        lines.add(new Line(List.of(Point.LINKED_POINT, Point.EMPTY_POINT, Point.LINKED_POINT)));
        lines.add(new Line(List.of(Point.LINKED_POINT, Point.EMPTY_POINT, Point.LINKED_POINT)));
        Ladder ladder = new Ladder(lines);

        assertThat(ladder.getLines()).containsExactlyElementsOf(lines);
    }
}
