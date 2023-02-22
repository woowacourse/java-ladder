package ladder.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.error.ErrorMessage;

class ResultsTest {
    @Test
    @DisplayName("실행 결과 수는 참여자 수와 같아야 한다.")
    void createResultsFailTest() {
        List<String> results = createResultsBySize(5);

        assertThatThrownBy(() -> new Results(results, 4))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.INVALID_NUMBER_OF_RESULTS.getMessage());
    }

    public List<String> createResultsBySize(int size) {
        List<String> results = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            results.add(String.valueOf(i));
        }

        return results;
    }
}
