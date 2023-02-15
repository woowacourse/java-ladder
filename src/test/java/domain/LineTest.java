package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.FootholdGenerator;
import utils.RandomFootholdGenerator;

public class LineTest {
    FootholdGenerator randomFootholdGenerator = new RandomFootholdGenerator();

    @Test
    @DisplayName("Line은 사람 수 -1만큼의 길이로 생성된다.")
    void create_line_by_player_numbers() {
        // given
        int numberOfPlayer = 3;
        int expectedLineNumber = numberOfPlayer - 1;

        // when
        Line line = new Line(numberOfPlayer, randomFootholdGenerator);

        // then
        assertThat(line.getPoints().size()).isEqualTo(expectedLineNumber);
    }
}
