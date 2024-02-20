package laddergame.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("랜덤")
class RandomBooleanGeneratorTest {
    @Test
    @DisplayName("랜덤값이 0 또는 1을 반환한다.")
    public void testRandomBoolean() {
        //given
        RandomBooleanGenerator generator = RandomBooleanGenerator.getGenerator();

        //when & then
        assertThat(generator.generate())
                .isBetween(0, 1);
    }
}