package laddergame.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.LadderHeight;
import laddergame.domain.ladder.Line;
import laddergame.domain.ladder.Point;
import laddergame.domain.name.Name;
import laddergame.domain.name.Names;
import laddergame.domain.result.Result;
import laddergame.domain.result.Results;
import laddergame.dto.LadderResult;
import org.assertj.core.api.Assertions;
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

    @DisplayName("이름으로 사다리 매칭 결과를 얻을 수 있다.")
    @Test
    void findResultByName() {
        // given
        final Names names = new Names(List.of("pobi", "honux", "jk"));
        final Results results = new Results(List.of("꽝", "3000", "5000"));
        final LadderHeight height = new LadderHeight(5);

        final LadderGame ladderGame = new LadderGame((i, j) -> new Ladder(List.of(
                new Line(List.of(Point.EXIST, Point.EMPTY)),
                new Line(List.of(Point.EXIST, Point.EMPTY)),
                new Line(List.of(Point.EXIST, Point.EMPTY)),
                new Line(List.of(Point.EXIST, Point.EMPTY)),
                new Line(List.of(Point.EXIST, Point.EMPTY))
        )));

        ladderGame.createLadder(names, results, height);

        Name name = new Name("pobi");

        // when
        Result result = ladderGame.findResultByName(name);

        // then
        Assertions.assertThat(result).isEqualTo(new Result("3000"));
    }
}
