package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.generator.ExistFootholdGenerator;
import domain.generator.FootholdGenerator;
import domain.generator.NonExistFootholdGenerator;
import domain.generator.RandomFootholdGenerator;

public class LineTest {
    FootholdGenerator randomFootholdGenerator = new RandomFootholdGenerator();

    @Test
    @DisplayName("Line은 사람 수 -1만큼의 길이로 생성된다.")
    void create_line_by_player_numbers_minus_one() {
        // given
        int numberOfPlayer = 3;
        int expectedLineNumber = numberOfPlayer - 1;

        // when
        Line line = new Line(numberOfPlayer, randomFootholdGenerator);

        // then
        assertThat(line.getFootholds().size()).isEqualTo(expectedLineNumber);
    }

    @Test
    @DisplayName("발판은 연속으로 생성될 수 없다.")
    void can_not_have_consecutive_foothold() {
        // given
        int numberOfPlayer = 4;

        // when
        Line line = new Line(numberOfPlayer, new ExistFootholdGenerator());

        // then
        assertThat(line.getFootholds()).containsExactly(true, false, true);
     }

    @Test
    @DisplayName("발판은 존재하지 않아도 생성될 수 있다.")
    void can_generate_without_foothold() {
        // given
        int numberOfPlayer = 4;

        // when
        Line line = new Line(numberOfPlayer, new NonExistFootholdGenerator());

        // then
        assertThat(line.getFootholds()).containsExactly(false, false, false);
    }
}
