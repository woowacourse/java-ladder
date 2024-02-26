package laddergame.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.entry;

import java.util.List;

import laddergame.domain.Result;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.LadderHeight;
import laddergame.domain.ladder.Line;
import laddergame.domain.move.LeftStrategy;
import laddergame.domain.move.RightStrategy;
import laddergame.domain.move.Trace;
import laddergame.domain.player.Player;
import laddergame.domain.player.Players;
import laddergame.domain.point.Point;
import laddergame.domain.point.RandomPointGenerator;
import laddergame.domain.target.Target;
import laddergame.domain.target.Targets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderGameTest {


    @DisplayName("사다리 게임이 초기화 된다.")
    @Test
    void create() {
        // given
        final List<String> input = List.of("pobi", "honux", "crong", "jk");

        final Players names = new Players(input);
        final LadderHeight height = new LadderHeight(5);

        final LadderGame ladderGame = new LadderGame(() -> Point.EXIST);

        // when
        final Ladder ladder = ladderGame.createLadder(names, height);

        // then
        assertThat(ladder.getLines()).hasSize(5)
                .extracting("points")
                .containsExactly(
                        List.of(Point.EXIST, Point.EMPTY, Point.EXIST),
                        List.of(Point.EXIST, Point.EMPTY, Point.EXIST),
                        List.of(Point.EXIST, Point.EMPTY, Point.EXIST),
                        List.of(Point.EXIST, Point.EMPTY, Point.EXIST),
                        List.of(Point.EXIST, Point.EMPTY, Point.EXIST));
    }

    @DisplayName("사다리게임 결과를 반환한다.")
    @Test
    void testLadderGame() {
        // given
        Players players = new Players(List.of("pobi", "honux", "crong", "jk"));
        Targets targets = new Targets(List.of("꽝","5000","꽝","3000"));
        List<Line> lines = List.of(
                new Line(List.of(Point.EXIST, Point.EMPTY, Point.EXIST)),
                new Line(List.of(Point.EMPTY, Point.EXIST, Point.EMPTY)),
                new Line(List.of(Point.EXIST, Point.EMPTY, Point.EMPTY)),
                new Line(List.of(Point.EMPTY, Point.EXIST, Point.EMPTY)),
                new Line(List.of(Point.EXIST, Point.EMPTY, Point.EXIST)));

        Ladder ladder = new Ladder(lines);
        LadderGame ladderGame = new LadderGame(new RandomPointGenerator());

        // when
        Result result = ladderGame.start(players, targets, ladder);

        // then
        assertThat(result.getResult()).contains(entry(new Player("pobi"), new Target("꽝")),
                entry(new Player("honux"), new Target("3000")),
                entry(new Player("crong"), new Target("꽝")),
                entry(new Player("jk"), new Target("5000")));
    }
}
