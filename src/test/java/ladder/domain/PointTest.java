package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author heebg
 * @version 1.0 2019-05-22
 */
class PointTest {
    Point Tpoint;
    Point Fpoint;

    @BeforeEach
    void setUp() {
        Tpoint = Point.TRUE;
        Fpoint = Point.FALSE;
    }

    @Test
    void create_생성() {
        assertThat(Tpoint).isEqualTo(Point.TRUE);
    }

}