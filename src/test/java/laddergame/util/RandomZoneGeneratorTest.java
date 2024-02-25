package laddergame.util;

import laddergame.domain.Zone;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("랜덤")
class RandomZoneGeneratorTest {
    @Test
    @DisplayName("랜덤값이 Zone.BRIDGE 또는 Zone.EMPTY 를 반환한다.")
    public void testRandomBoolean() {
        //given
        RandomZoneGenerator generator = new RandomZoneGenerator();
        List<Zone> expectValue = List.of(Zone.BRIDGE, Zone.EMPTY);

        //when & then
        assertThat(generator.generate())
                .isIn(expectValue);
    }
}
