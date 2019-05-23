package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * @author heebg
 * @version 1.0 2019-05-23
 */
public class PointConfigureTest {
    @Test
    void setRandom_true입력_확인() {
        Point point = PointConfigure.generateRandom(Point.TRUE);
        assertFalse(point.status());
    }
}
