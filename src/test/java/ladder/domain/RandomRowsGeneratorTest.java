package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RandomRowsGeneratorTest {
    @Test
    public void 랜덤_Row_생성() {
        assertThat(new RandomRowsGenerator().generateValidRow(3).getRow()).hasSize(3);

    }

    @Test
    public void 랜덤_Row_생성2() {
        assertThat(new RandomRowsGenerator().generateValidRow(4).getRow()).hasSize(4);
    }

    @Test
    public void 랜덤_Rows_생성() {
        List<Row> rows = new RandomRowsGenerator().generateRows(new Width(2), new Height(2)).getRows();
        assertThat(rows).hasSize(2);
    }
}