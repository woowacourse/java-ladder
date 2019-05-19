package laddergame.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LineTest {
    @Test
    void LineGenerator에서_Line객체_받아오기_테스트() {
        assertThat(LineGenerator.makeLine(5)).hasSameClassAs(new Line(Arrays.asList(true)));

    }
}
