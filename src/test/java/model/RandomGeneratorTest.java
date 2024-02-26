package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomGeneratorTest {

    @DisplayName("입력받은 수량과 같은 크기의 불린값 리스트를 반환한다.")
    @Test
    void generate() {
        int given = 3;
        RandomGenerator randomGenerator = new RandomGenerator();
        List<Boolean> result = randomGenerator.generate(given);

        assertThat(result).hasSize(given);
    }
}
