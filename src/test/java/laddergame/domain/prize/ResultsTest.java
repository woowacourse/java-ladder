package laddergame.domain.prize;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static laddergame.domain.prize.ResultsFixture.ethan;
import static laddergame.domain.prize.ResultsFixture.results;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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
        final Result result = results.findIndividualResultByName("ethan");

        // then
        assertAll(
                () -> assertThat(result.getName()).isEqualTo(ethan.getName()),
                () -> assertThat(result.getPrize()).isEqualTo("1000")
        );
    }
}
