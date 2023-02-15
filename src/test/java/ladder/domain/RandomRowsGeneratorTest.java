package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomRowsGeneratorTest {
    @Test
    public void 랜덤_Row_생성() {
        assertThat(new RandomRowsGenerator().generateValidRow(3).getPoints()).hasSize(3);

    }

    @Test
    public void 랜덤_Row_생성2() {
        assertThat(new RandomRowsGenerator().generateValidRow(4).getPoints()).hasSize(4);
    }

    @Test
    public void 랜덤_Rows_생성() {
        List<Row> rows = new RandomRowsGenerator().generateRows(2, 2).getRows();
        assertThat(rows).hasSize(2);
    }
}