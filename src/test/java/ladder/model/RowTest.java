package ladder.model;

import ladder.model.generator.RowGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RowTest {

    Row row;

    @BeforeEach
    void setUp() {
        row = Row.of(RowGenerator.makeDirections(Arrays.asList(true, false, false)));
    }

    @Test
    void 좌측_이동() {
        int result = row.move(1);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 우측_이동() {
        int result = row.move(0);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 정지() {
        int result = row.move(2);
        assertThat(result).isEqualTo(2);
    }
}
