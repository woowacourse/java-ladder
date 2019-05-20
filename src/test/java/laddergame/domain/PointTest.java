package laddergame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {
    @Test
    void 해당_지점에서_왼쪽_지점으로_가는지_테스트() {
        /* Given */
        Point point1 = Point.LEFT;

        /* Then */
        assertThat(point1.move(2)).isEqualTo(1);
    }

    @Test
    void 해당_지점에서_오른쪽_지점으로_가는지_테스트() {
        /* Given */
        Point point1 = Point.RIGHT;

        /* Then */
        assertThat(point1.move(2)).isEqualTo(3);
    }

    @Test
    void 해당_지점에서_직진_지점으로_가는지_테스트() {
        /* Given */
        Point point1 = Point.STRAIGHT;

        /* Then */
        assertThat(point1.move(2)).isEqualTo(2);
    }
}