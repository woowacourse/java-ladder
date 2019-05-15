package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LadderLineTest {
    @Test
    void 라인_객체_생성() {
        LadderLine line = new LadderLine(3);
        assertThat(line).isEqualTo(new LadderLine(3));
    }

    @Test
    void 라인_객체_생성_이름수_0이하_예외() {
        assertThrows(IllegalArgumentException.class, () -> {
            new LadderLine(0);
        });
    }

    @Test
    void 라인_배열_생성() {
        LadderLine line = new LadderLine(3);
        List<Boolean> lineStates = Arrays.asList(true, true, true);
        assertTrue(line.isMatchLine(lineStates));
    }

    @Test
    void 라인_생성자를_통한_배열_생성() {
        LadderLine line = new LadderLine(3);
        List<Boolean> lineStates = Arrays.asList(true, true, true);
        assertTrue(line.isMatchLine(lineStates));
    }
}
