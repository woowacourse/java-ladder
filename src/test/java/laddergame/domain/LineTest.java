package laddergame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import laddergame.domain.ladder.Line;
import laddergame.domain.ladder.LineSize;
import laddergame.domain.result.Trace;
import laddergame.domain.player.Players;
import laddergame.domain.point.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {


    @DisplayName("중복되지 않은 라인을 생성한다.")
    @Test
    void create() {
        // given
        LineSize lineSize = new LineSize(new Players(List.of("pobi", "zeze", "crong", "jk")));

        // when
        Line line = Line.create(lineSize, () -> Point.EXIST);

        //then
        final List<Point> expectedLine = List.of(Point.EXIST, Point.EMPTY, Point.EXIST);

        assertThat(line).extracting("points")
                .isEqualTo(expectedLine);
    }

    @DisplayName("오른쪽방향으로 이동한다.")
    @Test
    void testMoveRight() {
        // given
        Line line = new Line(List.of(Point.EXIST, Point.EMPTY, Point.EXIST));
        Trace trace = new Trace(0);

        // when
        Trace next = line.move(trace);

        // then
        assertThat(next.getPosition()).isEqualTo(1);
    }

    @DisplayName("왼쪽방향으로 이동한다.")
    @Test
    void testMoveLeft() {
        // given
        Line line = new Line(List.of(Point.EXIST, Point.EMPTY, Point.EXIST));
        Trace trace = new Trace(3);

        // when
        Trace next = line.move(trace);

        // then
        assertThat(next.getPosition()).isEqualTo(2);
    }

    @DisplayName("이동할 수 없으면 제자리에 있는다.")
    @Test
    void testNotMove() {
        // given
        Line line = new Line(List.of(Point.EMPTY, Point.EMPTY, Point.EMPTY));
        Trace trace = new Trace(1);

        // when
        Trace next = line.move(trace);

        // then
        assertThat(next.getPosition()).isEqualTo(1);
    }
}
