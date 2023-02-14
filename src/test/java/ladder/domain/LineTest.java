package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    void 라인은_주어진_사람보다_하나_적은_좌표값을_가진다() {
        Line line = new Line(5);

        Assertions.assertThat(line.toUnmodifiablePoints())
                .hasSize(4);
    }
}
