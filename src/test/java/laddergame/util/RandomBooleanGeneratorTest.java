package laddergame.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("랜덤")
class RandomBooleanGeneratorTest {
    @Test
    @DisplayName("랜덤값이 true 또는 false를 반환한다.")
    public void testRandomBoolean() {
        //given
        RandomBooleanGenerator generator = RandomBooleanGenerator.getGenerator();
        List<Boolean> expectValue = List.of(true, false);

        //when & then
        assertThat(generator.generate())
                .isIn(expectValue);
    }
}