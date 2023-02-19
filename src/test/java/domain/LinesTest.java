package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LinesTest {

    @ParameterizedTest
    @CsvSource({"4, 5", "3, 3", "5, 3"})
    @DisplayName("n명의 플레이어와 m의 높이가 주어졌을 때, Lines 생성을 확인한다.")
    void returns_lines(int numberOfPlayers, int height) {
        // given
        int expectedLadderWidth = numberOfPlayers - 1;

        // when
        Lines lines = new Lines(numberOfPlayers, height);

        // then
        assertThat(lines.getLines().get(0).getConnections().size()).isEqualTo(expectedLadderWidth);
        assertThat(lines.getLines().size()).isEqualTo(height);
    }
}
