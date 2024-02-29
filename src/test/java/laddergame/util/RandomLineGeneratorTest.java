package laddergame.util;

import laddergame.domain.Rung;
import laddergame.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("랜덤")
class RandomLineGeneratorTest {
    @Test
    @DisplayName("주어진 횟수만큼 다리가 생성되는지 확인한다.")
    public void testRandomBuildStrategy() {
        //given
        RandomLinesGenerator randomLinesGenerator =
                new RandomLinesGenerator();
        final int count = 4;

        //when
        Line canBuildBridges = randomLinesGenerator.generate(count);

        //then
        assertEquals(canBuildBridges.getLine().size(), count);
    }

    @Test
    @DisplayName("다리가 연속적으로 생성되지 않는지 검증한다.")
    public void testSequenceBridges() {
        //given
        RandomLinesGenerator randomLinesGenerator =
                new RandomLinesGenerator();
        final int count = 4;

        //when
        Line canBuildBridges = randomLinesGenerator.generate(count);

        //then
        IntStream.range(0, canBuildBridges.getLine().size() - 1)
                .filter(i -> canBuildBridges.getLine().get(i).equals(Rung.BRIDGE))
                .forEach(i -> assertEquals(canBuildBridges.getLine().get(i + 1), Rung.EMPTY));
    }
}
