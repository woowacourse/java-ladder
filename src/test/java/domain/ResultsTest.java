package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultsTest {

    @DisplayName("Result의 개수가 Name의 개수보다 많으면 예외를 던진다.")
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
}
