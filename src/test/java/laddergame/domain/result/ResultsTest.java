package laddergame.domain.result;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultsTest {


    @DisplayName("결과의 수가 원하는 수량이 아닐시 예외를 발생시킨다.")
    @Test
    void validateSize() {
        // given
        final List<String> results = List.of("꽝", "3000", "2000", "꽝");
        final int size = 3;

        // when & then
        assertThatThrownBy(() -> new Results(results, size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 결과 수를 " + size + "개 입력해주세요.");
    }
}
