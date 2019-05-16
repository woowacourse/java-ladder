package laddergame.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @Test
    void 라인이_제대로_추가되는지_확인() {
        Ladder ladder = new Ladder();
        Line line = new Line(Arrays.asList(true, false));

        assertThat(ladder.addLines(line)).isTrue();
    }
}