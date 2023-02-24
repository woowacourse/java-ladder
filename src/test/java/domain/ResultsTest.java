package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultsTest {

    @DisplayName("이름의 길이와 같은 갯수의 결과가 입력되면 정상적으로 생성된다.")
    @Test
    void create_success() {
        assertDoesNotThrow(() -> new Results(List.of(new Result("당첨"), new Result("꽝")), 2));
    }

    @DisplayName("입력된 이름의 수와 다른 갯수의 결과가 입력되면 예외를 반환한다..")
    @Test
    void create_fail_with_wrong_number_of_results() {
        assertThatThrownBy(() -> new Results(List.of(new Result("당첨"), new Result("꽝")), 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참가자의 수와 결과의 수는 같아야 합니다.");
    }
}