package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * @author heebg
 * @version 1.0 2019-05-23
 */
public class PointGenerateTest {
    @Test
    void setRandom_true입력_확인() {
        PointGenerate pointGenerate = PointGenerateFactory.getInstance().create(PointGenerateStatus.RANDOM);
        Point point = pointGenerate.generatePoint(Point.RIGHT);
        assertThat(point).isEqualTo(Point.LEFT);
    }
}
