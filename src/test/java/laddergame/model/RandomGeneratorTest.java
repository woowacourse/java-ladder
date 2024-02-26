package laddergame.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RandomGeneratorTest {
    @DisplayName("수량을 입력받아 랜덤으로 생성된 불린값 리스트를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,4", "2,5", "3,10", "4,1", "10,6", "100,5"})
    void generate(int height, int count) {
        RandomGenerator randomGenerator = new RandomGenerator();
        List<List<Boolean>> result = randomGenerator.generateBooleans(height, count);

        assertThat(result).hasSize(height);
        assertThat(result.get(0)).hasSize(count);
    }
}
