package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @DisplayName("가지고 있는 Point의 갯수 +1 만큼을 getLastPosition method를 통해 반환한다")
    @Test
    void get_last_position_test() {
        // given
        List<LinePoint> linePoints = List.of(LinePoint.BLOCKED, LinePoint.PASSABLE);
        Line line = new Line(linePoints);

        // when
        int lastPosition = line.getLastPosition();

        // then
        assertThat(lastPosition).isEqualTo(linePoints.size() + 1);
    }


}
