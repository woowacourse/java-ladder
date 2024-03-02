package domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultsTest {

    @DisplayName("사용자의 수와 동일한 수의 실행 결과는 허용한다.")
    @Test
    void checkSizeOfResults() {
        List<String> resultValues = List.of("1", "2");
        int playerCount = 2;

        assertThatCode(() -> new Results(resultValues, playerCount))
                .doesNotThrowAnyException();
    }

    @DisplayName("사용자의 수와 동일하지 않은 수의 실행 결과는 예외를 발생시킨다.")
    @Test
    void checkSizeOfResultsFail() {
        List<String> resultValues = List.of("1", "2");
        int playerCount = 3;

        assertThatThrownBy(() -> new Results(resultValues, playerCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행 결과의 수는 사용자들의 수와 동일해야 합니다.");
    }
}
