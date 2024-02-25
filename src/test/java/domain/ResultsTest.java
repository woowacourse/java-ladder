package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultsTest {

    @DisplayName("실행 결과의 수가 사용자 수와 맞지 않을 경우 예외 처리")
    @Test
    void validateResultLength() {
        assertThatThrownBy(() -> new Results("a,b,c", 4))
                .isInstanceOf(IllegalArgumentException.class);
    }

}