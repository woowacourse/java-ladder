package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RandomGeneratorTest {
    @DisplayName("수량을 입력받아 랜덤으로 생성된 불린값 리스트를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 10, 100})
    void generate() {
        int given = 3;
        RandomGenerator randomGenerator = new RandomGenerator();
        List<Boolean> result = randomGenerator.generate(given);

        assertThat(result).hasSize(given);
    }
}
