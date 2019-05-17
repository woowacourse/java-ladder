package ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RowTest {

    Row row;

    @BeforeEach
    void setUp() {
        row = new Row(new int[]{1, 1, 0});
    }

    @Test
    void Row_생성_확인() {
        assertThat(row.getLineSize()).isEqualTo(3);
    }

    @Test
    void 두번_긋기_확인() {
        assertThat(row.checkDoubleDraw()).isFalse();
    }
}
