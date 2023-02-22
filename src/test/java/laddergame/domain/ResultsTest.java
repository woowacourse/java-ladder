package laddergame.domain;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultsTest {
    
    @Test
    @DisplayName("결과들이 List<String>으로 주어지면 결과값이 반환된다.")
    void givenListString_thenReturnResults() {
        // given
        final List<String> resultNames = List.of("꽝", "1000", "5000", "10000");

        // when
        final Results results = new Results(resultNames, resultNames.size());

        // then
        assertThat(results)
                .extracting("results")
                .asInstanceOf(InstanceOfAssertFactories.list(Result.class))
                .extracting("result")
                .isEqualTo(resultNames);
    }

}
