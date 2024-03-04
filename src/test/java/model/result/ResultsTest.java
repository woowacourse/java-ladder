package model.result;

import model.position.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static model.result.Results.NOT_ALLOWED_RESULTS_SIZE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class ResultsTest {

    @Test
    @DisplayName("사용자의 수와 결과의 개수가 같지 않을 시 예외가 발생한다.")
    void validateResultsSize() {
        assertThatThrownBy(() -> new Results(List.of("꽝", "5000"), 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_ALLOWED_RESULTS_SIZE);
    }

    @DisplayName("위치에 따라 결과를 알 수 있다.")
    @Test
    void getResult() {
        Results results = new Results(List.of("꽝", "5000", "꽝", "3000"), 4);
        assertAll(
                () -> assertThat(results.getResult(Position.valueOf(0))).isEqualTo(new Result("꽝")),
                () -> assertThat(results.getResult(Position.valueOf(1))).isEqualTo(new Result("5000")),
                () -> assertThat(results.getResult(Position.valueOf(2))).isEqualTo(new Result("꽝")),
                () -> assertThat(results.getResult(Position.valueOf(3))).isEqualTo(new Result("3000"))
        );
    }

}
