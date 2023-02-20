package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderServiceTest {
    List<Line> customizedLines;
    People people;
    Ladder ladder;
    Results results;

    @BeforeEach
    void init() {
        customizedLines = List.of(
                new Line(List.of(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE)),
                new Line(List.of(Boolean.FALSE, Boolean.TRUE, Boolean.FALSE)),
                new Line(List.of(Boolean.TRUE, Boolean.FALSE, Boolean.FALSE)),
                new Line(List.of(Boolean.FALSE, Boolean.TRUE, Boolean.FALSE)),
                new Line(List.of(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE))
        );
        people = new People("pobi,honux,crong,jk");
        ladder = new Ladder(
                people,
                5,
                (width, height) -> customizedLines
        );
        results = new Results("꽝,5000,꽝,3000", people);
    }

    @ParameterizedTest
    @CsvSource({
            "pobi,꽝",
            "honux,3000",
            "crong,꽝",
            "jk,5000",
    })
    void single_result_test(String name, String result) {
        LadderService ladderService = new LadderService(ladder, people, results);
        assertThat(ladderService.getSingleResult(name)).isEqualTo(new Result(result));
    }


}
