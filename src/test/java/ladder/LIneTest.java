package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LIneTest {
    private Line line;

    @BeforeEach
    void setUp() {
        line = new Line(4);
    }

    @Test
    void isFalse() {
        assertThat(line.isFalse(false)).isTrue();
    }
}
