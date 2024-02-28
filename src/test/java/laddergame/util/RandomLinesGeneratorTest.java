package laddergame.util;

import laddergame.domain.Line;
import laddergame.domain.Lines;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("랜덤")
class RandomLinesGeneratorTest {
    @Test
    @DisplayName("주어진 횟수만큼 다리가 생성되는지 확인한다.")
    public void testRandomBuildStrategy() {
        //given
        RandomLinesGenerator randomLinesGenerator =
                new RandomLinesGenerator();
        final int count = 4;

        //when
        Lines canBuildBridges = randomLinesGenerator.generate(count);

        //then
        assertEquals(canBuildBridges.getLines().size(), count);
    }

    @Test
    @DisplayName("다리가 연속적으로 생성되지 않는지 검증한다.")
    public void testSequenceBridges() {
        //given
        RandomLinesGenerator randomLinesGenerator =
                new RandomLinesGenerator();
        final int count = 4;

        //when
        Lines canBuildBridges = randomLinesGenerator.generate(count);

        //then
        IntStream.range(0, canBuildBridges.getLines().size() - 1)
                .filter(i -> canBuildBridges.getLines().get(i).equals(Line.BRIDGE))
                .forEach(i -> assertEquals(canBuildBridges.getLines().get(i + 1), Line.EMPTY));
    }
}
