package model;

import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultsTest {
    @Test
    @DisplayName("Results 객체 생성 성공 테스트")
    void createResultsTest() {
        assertThatNoException().isThrownBy(() -> new Results("꽝, 5000, 꽝, 3000"));
    }
}
