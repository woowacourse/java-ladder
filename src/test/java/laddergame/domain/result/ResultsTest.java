package laddergame.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultsTest {

    @ParameterizedTest
    @ValueSource(strings = {"꽝,꽝,당첨", "꽝,꽝,꽝,당첨", "꽝,꽝,꽝,꽝,꽝,당첨", "꽝,꽝,꽝,꽝,꽝,꽝,당첨"})
    @DisplayName("실행 결과의 수가 참여자 수와 다르면, 예외가 발생한다.")
    void throws_exception_if_size_of_the_results_differs_from_number_of_the_participants(String resultNames) {
        int participantsCount = 5;

        assertThatThrownBy(() -> new Results(resultNames, participantsCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @CsvSource(value = {"꽝,꽝:2", "꽝,꽝,꽝:3", "꽝,꽝,꽝,꽝:4", "꽝,꽝,꽝,꽝,꽝:5"}, delimiter = ':')
    @DisplayName("모든 실행 결과가 동일하면, 예외가 발생한다.")
    void throws_exception_if_all_results_are_identical(String resultNames, int participantsCount) {
        assertThatThrownBy(() -> new Results(resultNames, participantsCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
