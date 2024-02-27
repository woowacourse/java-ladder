package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultsTest {

    @DisplayName("Results에서 result들을 조회할 수 있다.")
    @Test
    void create() {
        Results results = new Results();

        Assertions.assertThatCode(() -> results.getResults())
                .doesNotThrowAnyException();
    }
}
