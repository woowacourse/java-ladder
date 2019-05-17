package laddergame.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LIneGeneratorTest {
    @Test
    void ladder의_규칙에_맞는지_라인_테스트() {
        List<Boolean> line = LineGenerator.makeLine(5);
        boolean preValue = false;

        for (int i = 0; i < line.size(); i++) {
            if (preValue) {
                assertThat(line.get(i)).isFalse();
            }
            preValue = line.get(i);
        }
    }
}
