package ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RowTest {

    Row row;

    @BeforeEach
    void setUp() {
        row = new Row(Arrays.asList(1, 1, 0));
    }

    @Test
    void 좌측_이동() {
        int result = row.judegeMove(1);
        assertThat(result).isEqualTo(-1);
    }

    @Test
    void 우측_이동() {
        int result = row.judegeMove(0);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 정지() {
        int result = row.judegeMove(2);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 두번_긋기_확인() {
        assertThat(row.checkDoubleDraw()).isFalse();
    }
}
