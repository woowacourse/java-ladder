package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class RandomDigitsGeneratorTest {

    @Test
    @DisplayName("randomDigitsGenerator 생성 확인")
    void randomDigitsGenerator(){
        new RandomDigitsGenerator();
    }

    @RepeatedTest(50)
    @DisplayName("랜덤값 생성이 올바르게(0 or 1) 되고 있는지 확인")
    void generate() {
        RandomDigitsGenerator generator = new RandomDigitsGenerator();

        Assertions.assertThat(generator.generate())
                .matches(value -> value == 1 || value == 0);
    }
}
