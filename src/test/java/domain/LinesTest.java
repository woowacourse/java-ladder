package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.ExistFootholdGenerator;
import util.NonExistFootholdGenerator;

public class LinesTest {
    @Test
    @DisplayName("Lines는 4명의 플레이어와 5의 높이가 주어졌을 때, 생성을 확인한다.")
    void make_lines() {
        // given
        int numberOfPlayer = 4;
        int height = 5;
        int expectedLadderWidth = numberOfPlayer - 1;

        // when
        Lines lines = new Lines(numberOfPlayer, height);

        // then
        assertThat(lines.getLines().get(0).getFootholds().size()).isEqualTo(expectedLadderWidth);
        assertThat(lines.getLines().size()).isEqualTo(height);
    }

    @Test
    @DisplayName("Lines에서 해당하는 번호의 Line을 가져올 수 있다.")
    void returns_selected_position_of_lines() {
        // given
        Line emptyLine = new Line(4, new ExistFootholdGenerator());
        Line notEmptyLine = new Line(4, new NonExistFootholdGenerator());
        Lines lines = new Lines(List.of(emptyLine, notEmptyLine, emptyLine));

        // when
        List<Boolean> selectedNotEmptyLine = lines.findSelectedLine(1);

        // then
        assertThat(selectedNotEmptyLine).containsExactly(false, false, false);

    }
}
