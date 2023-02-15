package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import utils.LadderRowGenerator;

public class LineGeneratorTest {

    @Test
    @DisplayName("이전 사다리가 true면 false")
    void lineGenerateTest() {
        LadderRow line = new LadderRow(List.of(true, true, true));
        LadderRow newLine = LadderRowGenerator.generate(line);

        assertThat(newLine.getLines()).containsExactly(false, false, false);
    }

//    [true, true, false]
}
