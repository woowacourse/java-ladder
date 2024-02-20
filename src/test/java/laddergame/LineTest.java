package laddergame;

import static org.assertj.core.api.Assertions.assertThat;

import ladder.BooleanGenerator;
import ladder.Line;
import ladder.RandomBooleanGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {


    @DisplayName("사다리 라인을 생성한다.")
    @Test
    void create() {
        //given
        int personSize = 4;
        BooleanGenerator randomBooleanGenerator = new RandomBooleanGenerator();

        //when
        Line line = new Line(personSize, randomBooleanGenerator);

        //then
        assertThat(line.getSize()).isEqualTo(personSize - 1);
    }
}
