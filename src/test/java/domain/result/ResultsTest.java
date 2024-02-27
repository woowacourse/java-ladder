package domain.result;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultsTest {

    @Test
    @DisplayName("결과를 받아 올바르게 일급 컬렉션을 생성한다.")
    void validCreationTest() {
        List<String> results = List.of("1000", "꽝");
        assertDoesNotThrow(() -> new Results(results));
    }

    @Test
    @DisplayName("범위를 넘어가는 경우, 예외를 발생한다.")
    void getIndexOutOfBoundTest() {
        // given
        Results results = new Results(List.of("1000", "꽝"));
        // when
        Assertions.assertThatThrownBy(() -> results.get(2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("주어진 인덱스가 범위를 벗어납니다.");
    }
}
