package laddergame.service;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.LadderHeight;
import laddergame.domain.ladder.Line;
import laddergame.domain.player.Players;
import laddergame.domain.point.Point;
import laddergame.domain.point.RandomPointGenerator;
import laddergame.domain.result.Result;
import laddergame.domain.target.Targets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.entry;

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
        final Players players = new Players(List.of("pobi", "honux", "crong", "jk"));
        final Targets targets = new Targets(List.of("꽝","5000","꽝","3000"), 4);
        final List<Line> lines = List.of(
                new Line(List.of(Point.EXIST, Point.EMPTY, Point.EXIST)),
                new Line(List.of(Point.EMPTY, Point.EXIST, Point.EMPTY)),
                new Line(List.of(Point.EXIST, Point.EMPTY, Point.EMPTY)),
                new Line(List.of(Point.EMPTY, Point.EXIST, Point.EMPTY)),
                new Line(List.of(Point.EXIST, Point.EMPTY, Point.EXIST)));

        final Ladder ladder = new Ladder(lines);
        final LadderGame ladderGame = new LadderGame(new RandomPointGenerator());

        // when
        final Result result = ladderGame.start(players, ladder, targets);

        // then
        assertThat(result.getResult()).contains(entry("pobi", "꽝"),
                entry("honux", "3000"),
                entry("crong", "꽝"),
                entry("jk", "5000"));
    }
}
