package laddergame.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import laddergame.domain.Ladder;
import laddergame.domain.LadderHeight;
import laddergame.domain.Line;
import laddergame.domain.Names;
import laddergame.domain.Point;
import laddergame.dto.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderGameTest {


    @DisplayName("사다리 게임이 생성된다.")
    @Test
    void create() {
        // given
        final List<String> input = List.of("pobi", "honux", "jk");

        final Names names = new Names(input);
        final LadderHeight height = new LadderHeight(5);

        final LadderGame ladderGame = new LadderGame((i, j) -> new Ladder(List.of(
                new Line(List.of(Point.EXIST, Point.EMPTY)),
                new Line(List.of(Point.EXIST, Point.EMPTY)),
                new Line(List.of(Point.EXIST, Point.EMPTY)),
                new Line(List.of(Point.EXIST, Point.EMPTY)),
                new Line(List.of(Point.EXIST, Point.EMPTY))
        )));

        // when
        final Result result = ladderGame.createLadder(names, height);

        // then
        assertThat(result.names()).isEqualTo(input);
        assertThat(result.ladder()).hasSize(5)
                .isEqualTo(List.of(
                        List.of(true, false),
                        List.of(true, false),
                        List.of(true, false),
                        List.of(true, false),
                        List.of(true, false)
                ));
    }
}
