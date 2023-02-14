package domain;

import static org.assertj.core.api.Assertions.assertThat;

import domain.numbergenerator.TestNumberGenerator;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @DisplayName("사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.")
    @Test
    void createLineTest() {
        Line line = new Line(4, new TestNumberGenerator(Lists.newArrayList(1, 1, 1)));
        assertThat(line.getPoints()).containsExactly(true, false, true);
    }

    @DisplayName("라인이 겹치지 않으면 사다리가 정상적으로 생성된다.")
    @Test
    void createLineTest2() {
        Line line = new Line(4, new TestNumberGenerator(Lists.newArrayList(1, 0, 0)));
        assertThat(line.getPoints()).containsExactly(true, false, false);
    }
}
