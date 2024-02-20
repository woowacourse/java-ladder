package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineGeneratorTest {
    @DisplayName("정해진 수만큼 라인의 너비를 가지는 라인을 생성한다.")
    @Test
    void lineGenerateTest() {
        //given
        int width = 5;
        Line line = LineGenerator.generate(5);
        List<Direction> directionsInfo = line.getDirectionsInfo();

        //when, then
        assertThat(directionsInfo).hasSize(width);
    }

}
