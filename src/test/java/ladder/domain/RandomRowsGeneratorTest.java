package ladder.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomRowsGeneratorTest {
    @ParameterizedTest(name = "너비: {0}, 높이: {1}이면 높이가 {2}인 사다리 생성된다.")
    @CsvSource({"2,2,2", "2,3,3", "3,5,5"})
    public void Rows_생성_success(int width, int height, int expected) {
        List<Row> rows = new RandomRowsGenerator()
                .generateRows(new Width(width), new Height(height))
                .getRows();

        assertThat(rows).hasSize(expected);
    }
}