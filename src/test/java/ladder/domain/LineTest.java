package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    public void isConnected() {
        Line line = new Line(Arrays.asList(true, false));

        assertThat(line.isConnected(0)).isTrue();
        assertThat(line.isConnected(1)).isFalse();
    }
}
