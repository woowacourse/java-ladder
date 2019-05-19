package laddergame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LineGeneratorTest {
    @Test
    void ladder의_규칙에_맞는지_라인_테스트() {
        Line line = LineGenerator.makeLine(5);
        boolean preValue = false;

        for (int i = 0; i < line.getWidth(); preValue = line.getHandle(i), i++) {
            isPreValue(line, preValue, i);
        }
    }

    private void isPreValue(Line line, boolean preValue, int i) {
        if (preValue) {
            assertThat(line.getHandle(i)).isFalse();
        }
    }
}
