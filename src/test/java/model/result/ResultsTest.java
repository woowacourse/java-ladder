package model.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static model.result.Results.NOT_ALLOWED_RESULTS_SIZE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultsTest {

    @Test
    @DisplayName("사용자의 수와 결과의 개수가 같지 않을 시 예외가 발생한다.")
    void validateResultsSize() {
        assertThatThrownBy(() -> new Results(List.of("꽝", "5000"), 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_ALLOWED_RESULTS_SIZE);
    }

}
