package laddergame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.entry;

import java.util.List;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.LadderHeight;
import laddergame.domain.ladder.Line;
import laddergame.domain.ladder.LineSize;
import laddergame.domain.move.LeftStrategy;
import laddergame.domain.move.RightStrategy;
import laddergame.domain.move.Trace;
import laddergame.domain.player.Player;
import laddergame.domain.player.Players;
import laddergame.domain.point.Point;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderTest {

    @DisplayName("사다리높이만큼 라인을 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void create(int value) {
        // given
        final LadderHeight height = new LadderHeight(value);
        final LineSize lineSize = new LineSize(new Players(List.of("pobi", "zeze", "crong", "jk")));

        // when
        Ladder ladder = Ladder.create(lineSize, height, () -> Point.EXIST);

        // then
        assertThat(ladder.getLines()).hasSize(value);
    }

    @DisplayName("사다리게임 결과를 반환한다.")
    @Test
    void test() {
        // given
        Players names = new Players(List.of("pobi", "honux", "crong", "jk"));
        List<Line> lines = List.of(
                new Line(List.of(Point.EXIST, Point.EMPTY, Point.EXIST)),
                new Line(List.of(Point.EMPTY, Point.EXIST, Point.EMPTY)),
                new Line(List.of(Point.EXIST, Point.EMPTY, Point.EMPTY)),
                new Line(List.of(Point.EMPTY, Point.EXIST, Point.EMPTY)),
                new Line(List.of(Point.EXIST, Point.EMPTY, Point.EXIST)));

        Ladder ladder = new Ladder(lines);
        // when
        Result result = ladder.start(names);

        // then
        assertThat(result.getResult()).contains(entry(new Player("pobi"), new Trace(0, new LeftStrategy())),
                entry(new Player("honux"), new Trace(2, new RightStrategy())),
                entry(new Player("crong"), new Trace(2, new LeftStrategy())),
                entry(new Player("jk"), new Trace(0, new RightStrategy())));
    }
}
