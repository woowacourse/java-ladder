package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.BooleanGenerator;
import util.RandomBooleanGenerator;

@DisplayName("라인 제네레이터는")
class LineGeneratorTest {

    @Test
    @DisplayName(" 다리의 폭을 받아 다리 한층을 만들어 준다.")
    void generateLine() {
        //given
        int width = 5;
        BooleanGenerator generator = new RandomBooleanGenerator();

        //when
        Line line = LineGenerator.build(5, generator);

        //then
        assertThat(line.getWidth()).isEqualTo(width);

    }
}
