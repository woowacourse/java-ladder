package laddergame.domain;

import laddergame.domain.ladder.Line;
import laddergame.domain.ladder.LineSize;
import laddergame.domain.player.Players;
import laddergame.domain.bridge.Bridge;
import laddergame.domain.result.Trace;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {


    @DisplayName("중복되지 않은 라인을 생성한다.")
    @Test
    void create() {
        // given
        final LineSize lineSize = new LineSize(new Players(List.of("pobi", "zeze", "crong", "jk")));

        // when
        final Line line = Line.create(lineSize, () -> Bridge.EXIST);

        //then
        final List<Bridge> expectedLine = List.of(Bridge.EXIST, Bridge.EMPTY, Bridge.EXIST);

        assertThat(line).extracting("bridges")
                .isEqualTo(expectedLine);
    }

    @DisplayName("오른쪽방향으로 이동한다.")
    @Test
    void testMoveRight() {
        // given
        final Line line = new Line(List.of(Bridge.EXIST, Bridge.EMPTY, Bridge.EXIST));
        final Trace trace = new Trace(0);

        // when
        Trace next = line.move(trace);

        // then
        assertThat(next.getPosition()).isEqualTo(1);
    }

    @DisplayName("왼쪽방향으로 이동한다.")
    @Test
    void testMoveLeft() {
        // given
        final Line line = new Line(List.of(Bridge.EXIST, Bridge.EMPTY, Bridge.EXIST));
        final Trace trace = new Trace(3);

        // when
        final Trace next = line.move(trace);

        // then
        assertThat(next.getPosition()).isEqualTo(2);
    }

    @DisplayName("이동할 수 없으면 제자리에 있는다.")
    @Test
    void testNotMove() {
        // given
        final Line line = new Line(List.of(Bridge.EMPTY, Bridge.EMPTY, Bridge.EMPTY));
        final Trace trace = new Trace(1);

        // when
        final Trace next = line.move(trace);

        // then
        assertThat(next.getPosition()).isEqualTo(1);
    }
}
