package laddergame.domain;

import laddergame.domain.generator.RandomLineGenerator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LineTest {
    @Test
    void LineGenerator에서_Line객체_받아오기_테스트() {
        assertThat(new RandomLineGenerator().makeLine(5)).hasSameClassAs(new Line(Arrays.asList(true)));

    }
}
