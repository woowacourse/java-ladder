package domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class LadderTest {

    @Test
    @DisplayName("사다리가 정상적인 높이로 생성되는가")
    void ladder_created_in_correct_height() {
        int width = 3, height = 1;
        Ladder ladder = new Ladder(width, height, () -> Bridge.EXIST);

        List<Line> lines = ladder.getLines();

        assertThat(lines.size()).isEqualTo(height);
    }
}
