package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ResultsTest {

    Results results;

    @BeforeEach
    void init() {
        results = new Results(List.of("a1", "a2", "a3"));
    }

    @DisplayName("유효 범위를 초과하면 예외가 발생한다.")
    @Test
    void invalidColumnRangeTest() {
        assertThatThrownBy(() -> results.getFinalResult(Column.of(3)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효 범위를 초과한 column입니다.");
    }

    @DisplayName("해당 column에 해당하는 Result를 찾아온다.")
    @ParameterizedTest
    @CsvSource({
            "0,a1",
            "1,a2",
            "2,a3"
    })
    void name(int column, String result) {
        assertThat(results.getFinalResult(Column.of(column))).isEqualTo(new Result(result));
    }
}
