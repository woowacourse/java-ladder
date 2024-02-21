import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomGeneratorTest {

    @DisplayName("수량을 입력받아 랜덤으로 생성된 불린값 리스트를 반환한다.")
    @Test
    void generate() {
        int given = 3;
        RandomGenerator randomGenerator = new RandomGenerator();
        List<Boolean> result = randomGenerator.generate(given);

        assertThat(result).hasSize(given);
    }
}
