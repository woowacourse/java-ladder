package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.generator.ExistConnectionGenerator;
import domain.generator.ConnectionGenerator;
import domain.generator.NonExistConnectionGenerator;
import domain.generator.RandomConnectionGenerator;

public class LineTest {
    ConnectionGenerator randomConnectionGenerator = new RandomConnectionGenerator();

    @Test
    @DisplayName("Line은 사람 수 -1만큼의 길이로 생성된다.")
    void create_line_by_player_numbers_minus_one() {
        // given
        int numberOfPlayer = 3;
        int expectedLineNumber = numberOfPlayer - 1;

        // when
        Line line = new Line(numberOfPlayer, randomConnectionGenerator);

        // then
        assertThat(line.getConnections().size()).isEqualTo(expectedLineNumber);
    }

    @Test
    @DisplayName("사다리의 가로 줄은 연속으로 생성될 수 없다.")
    void can_not_have_consecutive_connection() {
        // given
        int numberOfPlayer = 4;

        // when
        Line line = new Line(numberOfPlayer, new ExistConnectionGenerator());

        // then
        assertThat(line.getConnections()).containsExactly(true, false, true);
     }

    @Test
    @DisplayName("사다리의 가로 줄은 존재하지 않아도 생성될 수 있다.")
    void can_generate_without_connection() {
        // given
        int numberOfPlayer = 4;

        // when
        Line line = new Line(numberOfPlayer, new NonExistConnectionGenerator());

        // then
        assertThat(line.getConnections()).containsExactly(false, false, false);
    }
}
