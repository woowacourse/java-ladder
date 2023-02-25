package laddergame.domain.prize;

import laddergame.domain.player.Name;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static laddergame.domain.prize.ResultsFixture.coil;
import static laddergame.domain.prize.ResultsFixture.ethan;
import static laddergame.domain.prize.ResultsFixture.junPk;
import static laddergame.domain.prize.ResultsFixture.results;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class ResultsTest {

    private ResultsFixture fixture;

    @BeforeEach
    void setUp() {
        fixture = new ResultsFixture();
    }

    @Test
    @DisplayName("결과가 주어졌을때 개인 조회를 이름으로 하면 결과가 반환된다.")
    void givenResults_whenFindIndividualResultByName_thenReturnResult() {
        // when
        final Name ethanName = new Name("ethan");
        final List<Result> results = ResultsFixture.results.findResults(ethanName);

        // then
        assertAll(
                () -> assertThat(results).hasSize(1),
                () -> assertThat(results).containsExactly(new Result(ethan, new Prize("1000")))
        );
    }

    @Test
    @DisplayName("결과가 주어졌을때 전체 조회를 하면 결과가 반환된다.")
    void givenResults_whenFindAll_thenReturnAllResult() {
        // when
        final List<Result> allResult = results.findResults(new Name("all"));

        // then
        assertAll(
                () -> assertThat(allResult).hasSize(3),
                () -> assertThat(allResult).containsExactly(
                        new Result(ethan, new Prize("1000")),
                        new Result(coil, new Prize("5000")),
                        new Result(junPk, new Prize("10000"))
                )
        );
    }
}
