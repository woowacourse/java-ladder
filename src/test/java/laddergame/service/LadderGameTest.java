package laddergame.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
import laddergame.dto.MatchingResult;
import laddergame.exception.LadderGameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderGameTest {

    @DisplayName("참가자와 결과 수가 다르면 사다리를 생성할 수 없다.")
    @Test
    void validateSize() {
        // given
        final List<String> inputNames = List.of("pobi", "honux", "jk");
        final List<String> inputResults = List.of("꽝", "3000", "5000", "2000");

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

        // when & then
        assertThatThrownBy(() -> ladderGame.createLadder(names, results, height))
                .isInstanceOf(LadderGameException.class)
                .hasMessage("[ERROR] 참가자와 결과 수가 같아야합니다.");
    }

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
        assertThat(result).isEqualTo(new Result("3000"));
    }

    @DisplayName("존재하지 않는 이름의 결과를 받을 수 없다.")
    @Test
    void isNotExistName() {
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

        Name name = new Name("zeze");

        // when & then
        assertThatThrownBy(() -> ladderGame.findResultByName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 존재하지 않는 이름입니다.");
    }

    @DisplayName("all 입력시 전체 결과를 받을 수 있다.")
    @Test
    void findAll() {
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

        // when
        List<MatchingResult> matchingResults = ladderGame.findResultAll();

        // then
        assertThat(matchingResults)
                .isEqualTo(List.of(new MatchingResult("pobi", "3000"),
                        new MatchingResult("honux", "꽝"),
                        new MatchingResult("jk", "5000")));

    }
}
