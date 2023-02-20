package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    @DisplayName("Height 수 만큼 Point 생성")
    void createPointSuccess() {
        Line line = Line.fromHeight(new Height(30));

        assertThat(line.getPoints())
                .hasSize(30);
    }

    @Test
    @DisplayName("지정한 위치에 방향 변경 확인")
    void changePointDirectionAtSuccess() {
        Line line = Line.fromHeight(new Height(5));
        Direction rightDown = Direction.RIGHT_DOWN;

        line.changePointDirectionAt(rightDown, 0);

        assertThat(line.getPoints().get(0).matchDirection(rightDown))
                .isTrue();
    }

    @Test
    @DisplayName("지정한 위치의 방향이 직진방향인지 확인")
    void isPointDirectionStraightSuccess() {
        Line line = Line.fromHeight(new Height(5));
        Direction rightDown = Direction.RIGHT_DOWN;

        line.changePointDirectionAt(rightDown, 0);
        boolean existAt = line.isPointDirectionStraight(0);

        assertThat(existAt).isFalse();
    }

}
