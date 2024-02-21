package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @DisplayName("현재 생성된 Point의 갯수를 리턴하는 기능")
    @Test
    public void getPointCount() {
        assertThat(new Line(5).getPointCount())
                .isEqualTo(0);
    }

    @DisplayName("랜덤값이 true일 경우 RIGHT, LEFT Direction을 가진 Point를 생성한다.")
    @Test
    public void generateHorizon() {
        Line line = new Line(2);
        int index = line.generateHorizon(1);
        assertThat(line.getPoints()).isEqualTo(List.of(new Point(Direction.RIGHT), new Point(Direction.LEFT)));
    }

    @DisplayName("랜덤값이 false일 경우 DOWN Direction을 가진 Point를 생성한다.")
    @Test
    public void generateVertical() {
        Line line = new Line(2);
        int index = line.generateVertical(1);
        assertThat(line.getPoints()).isEqualTo(List.of(new Point(Direction.DOWN)));
    }
}
