package laddergame.domain;

import laddergame.domain.ladder.Line;
import laddergame.domain.move.LeftStrategy;
import laddergame.domain.move.RightStrategy;
import laddergame.domain.move.Trace;
import laddergame.domain.point.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TraceTest {

    @DisplayName("오른쪽방향으로 이동한다.")
    @Test
    void testMoveRight() {
        // given
        Line line = new Line(List.of(Point.EMPTY, Point.EXIST, Point.EMPTY));
        Trace trace = new Trace(0, new RightStrategy());

        // when
        Trace next = trace.next(line);

        // then
        assertThat(next.getPosition()).isEqualTo(1);
        assertThat(next.getMovableStrategy()).isInstanceOf(RightStrategy.class);
    }

    @DisplayName("왼쪽방향으로 이동한다.")
    @Test
    void testMoveLeft() {
        // given
        Line line = new Line(List.of(Point.EMPTY, Point.EXIST, Point.EMPTY));
        Trace trace = new Trace(2, new LeftStrategy());

        // when
        Trace next = trace.next(line);

        // then
        assertThat(next.getPosition()).isEqualTo(1);
        assertThat(next.getMovableStrategy()).isInstanceOf(LeftStrategy.class);
    }

    @DisplayName("이동할 수 없으면 제자리에 있는다.")
    @Test
    void testNotMove() {
        // given
        Line line = new Line(List.of(Point.EMPTY, Point.EMPTY, Point.EMPTY));
        Trace trace = new Trace(1, new LeftStrategy());

        // when
        Trace next = trace.next(line);

        // then
        assertThat(next.getPosition()).isEqualTo(1);
        assertThat(next.getMovableStrategy()).isInstanceOf(LeftStrategy.class);
    }
}
