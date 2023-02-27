package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class LineTest {

    @Test
    @DisplayName("position 값이 들어오고 이상없이 오른쪽으로 이동한다.")
    void moveTest_left() {
        // given
        int position = 0;
        Line line = new Line(List.of(Step.EXIST, Step.EMPTY, Step.EMPTY));

        // when
        int result = line.move(position);

        // then
        assertThat(result).isEqualTo(position + 1);
    }

    @Test
    @DisplayName("왼쪽으로 이동한다.")
    void moveTest_right() {
        // given
        int position = 3;
        Line line = new Line(List.of(Step.EXIST, Step.EMPTY, Step.EXIST));

        // when
        int result = line.move(position);

        // then
        assertThat(result).isEqualTo(position - 1);
     }
}
