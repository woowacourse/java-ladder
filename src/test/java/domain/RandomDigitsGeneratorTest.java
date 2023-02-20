package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class RandomDigitsGeneratorTest {
    @RepeatedTest(50)
    @DisplayName("랜덤 생성기는 0과 1만 생성한다.")
    void generate() {
        RandomDigitsGenerator generator = new RandomDigitsGenerator();

        Assertions.assertThat(generator.generate())
                .matches(value -> value == 1 || value == 0);
    }

}
