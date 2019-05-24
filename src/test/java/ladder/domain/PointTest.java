package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author heebg
 * @version 1.0 2019-05-22
 */
class PointTest {
    Point Rpoint;
    Point Lpoint;
    Point Spoint;

    @BeforeEach
    void setUp() {
        Rpoint = Point.RIGHT;
        Lpoint = Point.LEFT;
        Spoint = Point.STRAIGHT;
    }

    @Test
    void create_생성() {
        assertThat(Rpoint).isEqualTo(Point.RIGHT);
    }

}