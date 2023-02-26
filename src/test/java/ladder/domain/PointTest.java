package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@SuppressWarnings({"NonAsciiCharacters"})
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PointTest {

    private final ConnectionJudgement alwaysConnected = new MockConnectionJudgement(true);
    private final ConnectionJudgement alwaysDisConnected = new MockConnectionJudgement(false);

    @Test
    void move_메서드를_이용해서_왼쪽으로_이동() {
        assertThat(Point.LEFT.move(Position.valueOf(1)))
                .isEqualTo(Position.valueOf(0));
    }

    @Test
    void move_메서드를_이용해서_오른쪽으로_이동() {
        assertThat(Point.RIGHT.move(Position.valueOf(0)))
                .isEqualTo(Position.valueOf(1));
    }

    @Test
    void move_메서드를_이용해서_이동하지_않음() {
        assertThat(Point.NONE.move(Position.valueOf(0)))
                .isEqualTo(Position.valueOf(0));
    }

    @Test
    void 현재_연결되지_않은_상태에서_다음_포인트를_구함() {
        assertAll(
                () -> assertThat(Point.NONE.next(alwaysConnected))
                        .isEqualTo(Point.RIGHT),
                () -> assertThat(Point.NONE.next(alwaysDisConnected))
                        .isEqualTo(Point.NONE)
        );
    }

    @Test
    void 현재_왼쪽으로_연결된_상태에서_다음_포인트를_구함() {
        assertAll(
                () -> assertThat(Point.LEFT.next(alwaysConnected))
                        .isEqualTo(Point.RIGHT),
                () -> assertThat(Point.LEFT.next(alwaysDisConnected))
                        .isEqualTo(Point.NONE)
        );
    }

    @Test
    void 현재_오른쪽으로_연결된_상태에서_다음_포인트를_구함() {
        assertAll(
                () -> assertThat(Point.RIGHT.next(alwaysConnected))
                        .isEqualTo(Point.LEFT),
                () -> assertThat(Point.RIGHT.next(alwaysDisConnected))
                        .isEqualTo(Point.LEFT)
        );
    }

    @Test
    void 오른쪽으로_연결되었는지_확인() {
        assertAll(
                () -> assertThat(Point.RIGHT.isRightConnected())
                        .isTrue(),
                () -> assertThat(Point.LEFT.isRightConnected())
                        .isFalse(),
                () -> assertThat(Point.NONE.isRightConnected())
                        .isFalse()
        );
    }
}
