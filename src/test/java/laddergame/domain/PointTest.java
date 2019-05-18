package laddergame.domain;

import laddergame.domain.rule.AlwaysCreateRule;
import laddergame.domain.rule.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PointTest {
    Rule rule;

    @BeforeEach
    void setUp() {
        rule = new AlwaysCreateRule();
    }

    @Test
    void 첫번째_포인트_생성() {
        assertThat(Point.first(rule)).isEqualTo(new Point(0, false, true));
    }

    @Test
    void 오른쪽으로_갈_수_있는_포인트에서_다음_포인트_생성() {
        Point point = new Point(1,false,true);

        assertThat(point.next(rule)).isEqualTo(new Point(2, true, false));
    }

    @Test
    void 오른쪽으로_갈_수_없는_포인트에서_다음_포인트_생성() {
        Point point = new Point(1,false,false);

        assertThat(point.next(rule)).isEqualTo(new Point(2, false, true));
    }

    @Test
    void 오른쪽으로_갈_수_있는_포인트에서_마지막_포인트_생성() {
        Point point = new Point(2,false,true);

        assertThat(point.last()).isEqualTo(new Point(3, true, false));
    }

    @Test
    void 오른쪽으로_갈_수_없는_포인트에서_마지막_포인트_생성() {
        Point point = new Point(2,false,false);

        assertThat(point.last()).isEqualTo(new Point(3, false, false));
    }

    @Test
    void 왼쪽으로_이동() {
        Point point = new Point(2,true,false);

        assertThat(point.move()).isEqualTo(1);
    }

    @Test
    void 오른쪽으로_이동() {
        Point point = new Point(2,false,true);

        assertThat(point.move()).isEqualTo(3);
    }

    @Test
    void 직진() {
        Point point = new Point(2,false,false);

        assertThat(point.move()).isEqualTo(2);
    }

    @Test
    void 양쪽으로_이동_가능한_포인트_생성_불가능() {
        assertThrows(IllegalArgumentException.class, () ->
                new Point(1,true, true));
    }
}
