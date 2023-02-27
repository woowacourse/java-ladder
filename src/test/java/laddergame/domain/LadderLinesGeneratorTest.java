package laddergame.domain;

import static laddergame.TestDummy.TEST_BOOLEAN_GENERATOR;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderLinesGeneratorTest {
    @DisplayName("라인 사이즈는 세로 길이와 같다.")
    @Test
    void returnsLinesSizeIsHeight() {
        //given
        final Width width_2 = new Width(2);
        final Height height_5 = new Height(5);
        LadderLinesGenerator ladderLinesGenerator = new LadderLinesGenerator(TEST_BOOLEAN_GENERATOR);

        //when
        final List<Line> lines = ladderLinesGenerator.createLines(width_2, height_5);

        //then
        assertThat(lines).hasSize(5);
    }
}