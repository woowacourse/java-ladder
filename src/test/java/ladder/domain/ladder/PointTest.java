package ladder.domain.ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class PointTest {
    Point point;

    @BeforeEach
    public void setup() {
        point = new Point(1, true, false);
    }

    @Test
    public void 포인트생성확인() {
        assertThat(point).isEqualTo(new Point(1, true, true));
    }

    @Test
    public void 다음포인트포지션얻기() {
        assertThat(point.nextPointPosition()).isEqualTo(0);
    }

}
