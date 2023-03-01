package laddergame.domain;

import static laddergame.TestDummy.TEST_BOOLEAN_GENERATOR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import laddergame.domain.ladder.Height;
import laddergame.domain.ladder.Width;
import laddergame.domain.ladder.line.BooleanGenerator;
import laddergame.domain.ladder.line.LadderLinesGenerator;
import laddergame.domain.ladder.line.Line;
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

    @DisplayName("가로 라인이 겹치면 예외가 발생한다.")
    @Test
    void throwExceptionWhenBothTrue() {
        //given
        BooleanGenerator booleanGenerator = new BooleanGenerator() {
            private final Deque<Boolean> given = new ArrayDeque<>(List.of(true, true, false));

            @Override
            public boolean generate() {
                return given.pollFirst();
            }
        };
        LadderLinesGenerator ladderLinesGenerator = new LadderLinesGenerator(booleanGenerator);
        Width width = new Width(4);
        Height height = new Height(1);
        //when
        //then
        assertThatThrownBy(() -> ladderLinesGenerator.createLines(width, height));
    }
}