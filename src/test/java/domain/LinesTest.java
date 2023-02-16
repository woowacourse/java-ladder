package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
