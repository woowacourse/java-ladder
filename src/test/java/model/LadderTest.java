package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @DisplayName("사다리 높이와 사람 수, RandomGenerator을 입력받아 사다리 줄을 설정한다.")
    @Test
    void addLadderLine() {
        int height = 2;
        int peopleCount = 3;
        RandomGenerator randomGenerator = new RandomGenerator();
        Ladder ladder = new Ladder();
        ladder.generateLine(height, peopleCount, randomGenerator);
        List<Line> result = ladder.getLines();

        assertThat(result).hasSize(height);
    }
}
