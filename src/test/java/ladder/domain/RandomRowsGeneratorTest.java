package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomRowsGeneratorTest {
    @Test
    public void 랜덤_Row_생성() {
        assertThat(new RandomRowsGenerator().generateRow(3).getPoints()).hasSize(3);

    }

    @Test
    public void 랜덤_Row_생성2() {
        assertThat(new RandomRowsGenerator().generateRow(4).getPoints()).hasSize(4);
    }

    @Test
    public void 랜덤_Rows_생성() {
        assertThat(new RandomRowsGenerator().generateRows(2, 2).getRows()).hasSize(2);
    }
}