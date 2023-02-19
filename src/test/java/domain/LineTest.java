package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @DisplayName("사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.")
    @Test
    void createLineTest() {
        Line line = new Line(new TestBooleanGenerator(Lists.newArrayList(true, true, true)), 4);
        assertThat(line.getPoints()).containsExactly(Point.CONNECTION, Point.SEPARATION, Point.CONNECTION);
    }

    @DisplayName("라인이 겹치지 않으면 사다리가 정상적으로 생성된다.")
    @Test
    void createLineTest2() {
        Line line = new Line(new TestBooleanGenerator(Lists.newArrayList(true, false, false)), 4);
        assertThat(line.getPoints()).containsExactly(Point.CONNECTION, Point.SEPARATION, Point.SEPARATION);
    }
}
