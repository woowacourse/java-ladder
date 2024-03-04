package ladder.domain.line;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomLineGeneratorTest {

    @DisplayName("정해진 방향 수로 라인을 생성한다.")
    @Test
    void generateLine() {
        //given
        int numberOfDirections = 10;
        LineGenerator lineGenerator = new RandomLineGenerator();
        Line line = lineGenerator.generateLine(numberOfDirections);

        //when
        int size = line.getSize();

        //then
        assertThat(size).isEqualTo(numberOfDirections);
    }
}
