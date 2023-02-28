package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultsTest {

    @DisplayName("Result의 개수가 Name의 개수와 같지 않으면 예외를 던진다.")
    @Test
    void throws_exception_when_number_of_result_is_over_than_number_of_name() {
        // given
        int numberOfNames = 5;
        String inputResult = "1,2,3,4,5,6";

        // when & then
        assertThatThrownBy(() -> new Results(inputResult, numberOfNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("결과 값들의 개수는 입력된 이름의 개수와 같아야 합니다.");
    }

    @DisplayName("Results는 결과를 입력받은 순서에 따라 가지고 있어야한다.")
    @Test
    void check_results_in_order() {
        // given
        String inputResult = "1,2,3";
        Results results = new Results(inputResult, 3);

        // when
        List<String> expectedResults = results.getResults()
                .stream()
                .map(Result::getValue)
                .collect(Collectors.toList());

        // then
        assertThat(expectedResults).containsExactly("1", "2", "3");
    }
}
