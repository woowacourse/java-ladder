package laddergame.domain.ladder;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import laddergame.domain.ladder.Line;
import laddergame.domain.ladder.Point;
import laddergame.exception.LadderGameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {


    @DisplayName("겹치는 포인트를 가지는 Line을 생성할 수 없다.")
    @Test
    void createByOverlapped() {
        // given
        final List<Point> points = List.of(Point.EXIST, Point.EXIST, Point.EMPTY);

        // when & then
        assertThatThrownBy(() -> new Line(points))
                .isInstanceOf(LadderGameException.class)
                .hasMessage("[ERROR] 포인트가 겹치는 라인을 생성할 수 없습니다.");
    }

    @DisplayName("겹치는 포인트가 없으면 Line을 생성할 수 있다.")
    @Test
    void create() {
        // given
        final List<Point> points = List.of(Point.EXIST, Point.EMPTY, Point.EXIST);

        // when & then
        assertThatCode(() -> new Line(points))
                .doesNotThrowAnyException();
    }
}
