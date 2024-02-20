package domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {
    private PointGenerator pointGenerator = new PickedPointGenerator();
    private static final int PERSON_COUNT = 3;

    @DisplayName("주어진 line들로 사다리를 만든다.")
    @Test
    void createLadder() {
        //given
        final int personCount = PERSON_COUNT;
        Line line = Line.create(personCount, pointGenerator);
        List<Line> lines = List.of(line);
        //when
        final Ladder ladder = new Ladder(lines);
        //then
        Assertions.assertThat(ladder.getLines()).isEqualTo(lines);
    }
}