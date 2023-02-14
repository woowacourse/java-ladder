package domain;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.assertj.core.internal.bytebuddy.ClassFileVersion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import utils.LineGenerator;

public class LineGeneratorTest {

    @Test
    @DisplayName("이전 사다리가 true면 false")
    void lineGenerateTest() {
        Line line = new Line(List.of(true, true, true));
        Line newLine = LineGenerator.generate(line);

        Assertions.assertThat(newLine.getLine()).containsExactly(false, false, false);
    }
}
