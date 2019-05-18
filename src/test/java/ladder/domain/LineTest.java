package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    public void 사다리_연결되는지_확인() {
        Line line = new Line();

        assertThat(line.isConnected(0)).isFalse();

        line.connect(new MockLadderBuildStrategy(), 0);
        assertThat(line.isConnected(0)).isTrue();
    }
}
