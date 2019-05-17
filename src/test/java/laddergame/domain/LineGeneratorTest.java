package laddergame.domain;

import laddergame.controller.LineGenerator;
import laddergame.controller.rule.AlwaysCreateRule;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LineGeneratorTest {
    @Test
    void Line이_제대로_생성되는지_테스트() {
        assertThat(LineGenerator.lineGenerate(2, new AlwaysCreateRule())).isEqualTo(
                new Line(Arrays.asList(false, true, false)));
    }
}