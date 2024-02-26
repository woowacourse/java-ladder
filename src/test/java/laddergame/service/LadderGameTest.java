package laddergame.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.LadderHeight;
import laddergame.domain.ladder.Line;
import laddergame.domain.ladder.Point;
import laddergame.domain.name.Names;
import laddergame.domain.result.Results;
import laddergame.dto.LadderResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderGameTest {


    @DisplayName("사다리 게임이 생성된다.")
    @Test
    void create() {
        // given
        final List<String> inputNames = List.of("pobi", "honux", "jk");
        final List<String> inputResults = List.of("꽝", "3000", "5000");

        final Names names = new Names(inputNames);
        final Results results = new Results(inputResults);
        final LadderHeight height = new LadderHeight(5);

        final LadderGame ladderGame = new LadderGame((i, j) -> new Ladder(List.of(
                new Line(List.of(Point.EXIST, Point.EMPTY)),
                new Line(List.of(Point.EXIST, Point.EMPTY)),
                new Line(List.of(Point.EXIST, Point.EMPTY)),
                new Line(List.of(Point.EXIST, Point.EMPTY)),
                new Line(List.of(Point.EXIST, Point.EMPTY))
        )));

        // when
        final LadderResult ladderResult = ladderGame.createLadder(names, results, height);

        // then
        assertThat(ladderResult.names()).isEqualTo(inputNames);
        assertThat(ladderResult.results()).isEqualTo(inputResults);
        assertThat(ladderResult.ladder()).hasSize(5)
                .isEqualTo(List.of(
                        List.of(true, false),
                        List.of(true, false),
                        List.of(true, false),
                        List.of(true, false),
                        List.of(true, false)
                ));
    }

}
