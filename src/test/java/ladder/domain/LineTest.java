package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    void 그리는_경우() {
        Line line1 = new Line(new ArrayList<>(Collections.singletonList(false)), new AlwaysTrueCreateLine());
        line1.updateRowLines();
        assertThat(line1.getRowLines()).isEqualTo(new ArrayList<>(Arrays.asList(false, true)));
    }

    @Test
    void 그리지_않는_경우() {
        Line line2 = new Line(new ArrayList<>(Collections.singletonList(true)), new AlwaysTrueCreateLine());
        line2.updateRowLines();
        assertThat(line2.getRowLines()).isEqualTo(new ArrayList<>(Arrays.asList(true, false)));
    }
}