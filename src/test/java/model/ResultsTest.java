package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class ResultsTest {

    @DisplayName("위치에 따라 결과를 알 수 있다.")
    @Test
    void reward() {
        Results results = new Results(List.of("꽝", "5000", "꽝", "3000"));
        assertAll(
                () -> assertThat(results.getResult(0)).isEqualTo("꽝"),
                () -> assertThat(results.getResult(1)).isEqualTo("5000"),
                () -> assertThat(results.getResult(2)).isEqualTo("꽝"),
                () -> assertThat(results.getResult(3)).isEqualTo("3000")
        );
    }
}
