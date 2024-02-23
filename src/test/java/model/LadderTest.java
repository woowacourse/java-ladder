package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderTest {
    @DisplayName("사다리 높이와 사람수, RandomGenerator을 입력받아 사다리 줄을 설정한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 10, 100})
    void addLadderLine(int givenHeight) {
        int peopleCount = 3;
        RandomGenerator randomGenerator = new RandomGenerator();
        Ladder ladder = new Ladder();
        ladder.generateLine(givenHeight, peopleCount, randomGenerator);
        List<Line> result = ladder.getLines();

        assertThat(result).hasSize(givenHeight);
    }
}
