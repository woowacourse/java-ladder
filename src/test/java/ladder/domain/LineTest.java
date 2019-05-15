package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    private Line line;
    private Point point1;
    private Point point2;

    @BeforeEach
    public void setUp() {
        line = new Line(5);
        point1 = new Point(1,5);
        point2 = new Point(4,5);
    }

    @Test
    public void 사다리_연결가능_여부() {
        assertThat(line.isAvailableToConnect(point1)).isTrue();
    }

    @Test
    public void 사다리_연결가능_여부_맨끝좌표_입력() {
        assertThat(line.isAvailableToConnect(point2)).isFalse();
    }
}
