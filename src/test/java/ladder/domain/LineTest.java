package ladder.domain;

import ladder.util.RandomBooleanListGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    @DisplayName("라인에는 사람의 수 - 1 만큼 좌표가 있다.")
    void createLine() {
        // given
        int personCount = 5;

        // when
        Line line = new Line(personCount, new RandomBooleanListGenerator());
        int pointsSize = line.getPoints().size();

        // then
        assertThat(pointsSize).isEqualTo(personCount - 1);
    }

}
