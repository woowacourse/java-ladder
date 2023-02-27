package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Map;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    Ladder ladder;

    @BeforeEach
    void init() {
        Players players = new Players(List.of("pobi", "honux", "crong", "jk"));
        Results results = new Results(List.of("꽝", "5000", "꽝", "3000"));
        List<Line> customizedLines = List.of(
                new Line(List.of(TRUE, FALSE, TRUE)),
                new Line(List.of(FALSE, TRUE, FALSE)),
                new Line(List.of(TRUE, FALSE, FALSE)),
                new Line(List.of(FALSE, TRUE, FALSE)),
                new Line(List.of(TRUE, FALSE, TRUE))
        );
        ladder = new Ladder(players, results, new Lines(customizedLines));
    }

    @DisplayName("단일 사용자의 결과 출력")
    @ParameterizedTest
    @CsvSource({
            "pobi,꽝",
            "honux,3000",
            "crong,꽝",
            "jk,5000",
    })
    void single_result_test(String name, String result) {
        assertThat(ladder.calculateResult(new Player(name)))
                .isEqualTo(new Result(result));
    }

    @DisplayName("모든 사용자의 결과 출력")
    @Test
    void all_result_test() {
        Map<Player, Result> data = Map.ofEntries(
                Map.entry(new Player("pobi"), new Result("꽝")),
                Map.entry(new Player("honux"), new Result("3000")),
                Map.entry(new Player("crong"), new Result("꽝")),
                Map.entry(new Player("jk"), new Result("5000"))
        );
        CalculatedResults resultMap = ladder.getTotalResults();
        assertThat(resultMap.getResultMap()).isEqualTo(data);
    }
}
