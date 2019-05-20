package ladderGame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @Test
    void 처음_포인트_생성() {
        assertThat(Point.pointFirst(true).move()).isEqualTo(1);
    }

    @Test
    void 다음_포인트_생성() {
        assertThat(Point.pointFirst(true).nextPoint(true).move()).isEqualTo(-1);
        assertThat(Point.pointFirst(true).nextPoint(false).move()).isEqualTo(-1);
        assertThat(Point.pointFirst(false).nextPoint(true).move()).isEqualTo(1);
        assertThat(Point.pointFirst(false).nextPoint(false).move()).isEqualTo(0);
    }

    @Test
    void 마지막_포인트_생성() {
        assertThat(Point.pointFirst(true).nextPointLast().move()).isEqualTo(-1);
        assertThat(Point.pointFirst(false).nextPointLast().move()).isEqualTo(0);
    }
}
