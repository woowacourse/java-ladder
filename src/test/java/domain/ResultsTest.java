package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultsTest {

    @DisplayName("실행 결과들을 주면 객체가 잘 생성된다.")
    @Test
    void createResults() {
        //given
        final List<String> values = List.of("꽝", "3000");

        //when
        final Results results = Results.from(values);

        //then
        assertAll(
                () -> assertThat(results.getBy(0).value()).isEqualTo(values.get(0)),
                () -> assertThat(results.getBy(1).value()).isEqualTo(values.get(1))
        );
    }

    @DisplayName("실행 결과들을 모두 반환한다.")
    @Test
    void returnResultsAll() {
        //given
        final List<String> values = List.of("꽝", "3000");
        final Results results = Results.from(values);

        //when
        final List<String> valuesGot = results.getValues();

        //then
        assertThat(valuesGot).containsExactlyElementsOf(values);
    }
}
