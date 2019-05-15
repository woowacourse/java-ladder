package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    private Line line;
    private int point1;
    private int point2;

    @BeforeEach
    public void setUp() {
        line = new Line(5);
        point1 = 1;
        point2 = 4;
    }

    @Test
    public void 사다리_연결가능_여부() {
        assertThat(line.isAvailableToConnect(point1)).isTrue();
    }

    @Test
    public void 사다리_연결가능_여부_맨끝좌표_입력() {
        assertThat(line.isAvailableToConnect(point2)).isFalse();
    }

    @Test
    public void 사다리_잘_그리는지_확인() {
        assertThat(line.isConnected(point1)).isFalse();
        line.connect(point1, 4);
        assertThat(line.isConnected(point1)).isTrue();
    }

    @Test
    void 사다리_그리지_말아야_할_때_안_그리는지_확인() {
        assertThat(line.isConnected(point1)).isFalse();
        line.connect(point1, 3);
        assertThat(line.isConnected(point1)).isFalse();
    }
}
