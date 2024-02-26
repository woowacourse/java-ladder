package laddergame.util;

import laddergame.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("랜덤")
class RandomLineGeneratorTest {
    @Test
    @DisplayName("랜덤값이 Zone.BRIDGE 또는 Zone.EMPTY 를 반환한다.")
    public void testRandomBoolean() {
        //given
        RandomLineGenerator generator = new RandomLineGenerator();
        List<Line> expectValue = List.of(Line.BRIDGE, Line.EMPTY);

        //when & then
        assertThat(generator.generate())
                .isIn(expectValue);
    }
}
