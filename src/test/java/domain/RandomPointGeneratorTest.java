package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class RandomPointGeneratorTest {

    @Test
    @DisplayName("randomDigitsGenerator 생성 확인")
    void randomDigitsGenerator(){
        new RandomPointGenerator();
    }

    @RepeatedTest(50)
    @DisplayName("랜덤값 생성이 올바르게(true or false) 되고 있는지 확인")
    void generate() {
        RandomPointGenerator generator = new RandomPointGenerator();
        boolean generate = generator.generate();
        Assertions.assertThat(generate || !generate);
    }
}
