package ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class RowTest {
    Row row;

    @BeforeEach
    void setUp() {
        row = new Row(Arrays.asList(1, 1, 0));
    }

    @Test
    void 이동_왼쪽() {
        int result = row.judgeMove(1);
        assertThat(result).isEqualTo(-1);
    }

    @Test
    void 이동_오른쪽() {
        int result = row.judgeMove(0);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 정지() {
        int result = row.judgeMove(2);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 두번_긋기() {
        assertThat(row.checkDoubleDraw()).isFalse();
    }
}
