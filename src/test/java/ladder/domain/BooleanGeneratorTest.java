package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BooleanGeneratorTest {

    @DisplayName("랜덤 boolean 값은 true 혹은 false 이다.")
    @Test
    void generateRandomBooleanTest() {
        BooleanGenerator generator = new RandomBooleanGenerator();
        Assertions.assertThat(generator.generate())
            .isExactlyInstanceOf(Boolean.class);
    }
}
