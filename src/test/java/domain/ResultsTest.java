package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultsTest {
    @Test
    @DisplayName("실행 결과는 사람 이름 수와 정확하게 일치해야 한다.")
    void isResultCountMatchNamesCount() {
        List<String> rawNames = Arrays.asList("pobi", "crong", "honux");
        Names names = new Names(rawNames);
        List<String> results = Arrays.asList("꽝", "5000", "꽝", "3000");

        assertThatThrownBy(() -> new Results(results, names.size()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행 결과의 개수가 사람 이름의 개수와 일치하지 않습니다.");
    }

    @Test
    @DisplayName("전체 실행 결과를 반환한다.")
    void getAllResults() {
        Results results = new Results(Arrays.asList("꽝", "5000", "꽝", "3000"), 4);
        List<String> allResults = results.getAll();

        assertThat(allResults).containsExactly("꽝", "5000", "꽝", "3000");
    }

    @Test
    @DisplayName("특정 위치의 실행 결과를 반환한다.")
    void getResultByIndex() {
        Results results = new Results(Arrays.asList("꽝", "5000", "꽝", "3000"), 4);
        String result = results.resultOf(1);

        assertThat(result).isEqualTo("5000");
    }

    @Test
    @DisplayName("실행 결과의 총 개수를 반환한다.")
    void getResultSize() {
        Results results = new Results(Arrays.asList("꽝", "5000", "꽝", "3000"), 4);
        int size = results.size();

        assertThat(size).isEqualTo(4);
    }

    @Test
    @DisplayName("사람 이름과 실행 결과를 매칭한다.")
    void matchNamesWithResults() {
        Results results = new Results(Arrays.asList("꽝", "5000", "꽝", "3000"), 4);
        List<String> namesAfterMove = Arrays.asList("pobi", "crong", "honux", "jk");

        assertThat(results.matchNamesWithResults(namesAfterMove)).containsExactlyInAnyOrderEntriesOf(
                Map.of("pobi", "꽝", "crong", "5000", "honux", "꽝", "jk", "3000"));
    }
}
