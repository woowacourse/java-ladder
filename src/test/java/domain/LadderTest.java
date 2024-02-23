package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class LadderTest {

    @Test
    @DisplayName("사다리가 정상적으로 생성되는가")
    void ladder_created_correctly() {
        int width = 3, height = 1;
        Ladder ladder = new Ladder(width, height);

        List<Line> lines = ladder.getLines();

        assertThat(lines.size()).isEqualTo(height);
    }
}
