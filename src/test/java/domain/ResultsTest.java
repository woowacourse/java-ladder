package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultsTest {

    @Test
    @DisplayName("입력받은 결과의 수는 참여자 수와 같아야 한다.")
    void validateResultCount() {
        assertThatThrownBy(() -> new Results(List.of("꽝", "당첨1", "당첨2", "당첨3"), 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 결과의 수는 참여자 수와 같아야 합니다.");
    }

    @Test
    @DisplayName("플레이어의 인덱스와 일치하는 결과 반환 확인")
    void findResultByIndex() {
        Results results = new Results(List.of("꽝", "당첨1", "당첨2", "당첨3"), 4);
        assertThat(results.getResultByIndex(2)).isEqualTo("당첨2");
    }

    @Test
    @DisplayName("결과 수 반환 확인")
    void getResultSize() {
        Results results = new Results(List.of("꽝", "당첨1", "당첨2", "당첨3"), 4);
        assertThat(results.getSize()).isEqualTo(4);
    }

    @Test
    @DisplayName("결과 문자 최대 길이 구하기")
    void findMaxResultLength() {
        Results results = new Results(List.of("꽝", "당첨1", "당첨2222", "당첨333333"), 4);
        assertThat(results.findMaxResultLength()).isEqualTo(8);
    }
}
