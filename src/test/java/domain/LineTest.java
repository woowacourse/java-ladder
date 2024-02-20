package domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {
    private final PointGenerator pointGenerator = new PickedPointGenerator();

    @DisplayName("라인을 생성한다.")
    @Test
    void createLine() {
        //given
        int personCount = 4;
        //when
        Line line = Line.create(personCount, pointGenerator);
        //then
        Assertions.assertThat(line.getPoints()).containsExactly(false, true, false);
    }

}