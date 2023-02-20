package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultTest {

    @DisplayName("결과에 공백을 입력할 경우 예외가 발생한다.")
    @Test
    void result_test() {
        assertThatThrownBy(() -> new Result(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("결과는 공백일 수 없습니다.");
    }
}
