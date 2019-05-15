package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
        List<Boolean> lineStates = Arrays.asList(false, false, false);
        assertTrue(line.isMatchLine(lineStates));
    }

    @Test
    void 라인_생성자를_통한_배열_생성() {
        LadderLine line = new LadderLine(3);
        List<Boolean> lineStates = Arrays.asList(false, false, false);
        assertTrue(line.isMatchLine(lineStates));
    }

    @Test
    void 라인_첫번째_상태값_확인하기() {
        LadderLine line = new LadderLine(3);
        Assertions.assertFalse(line.isMatchLineState(0));
    }

    @Test
    void 랜덤값_확인하기_true_입력() {
        assertFalse(LadderLine.setNextState(true));
    }

    @Test
    void 랜덤값_확인하기_false_입력() {
        for (int i = 0; i < 3; i++) {
            System.out.println(LadderLine.setNextState(false));
        }
    }
}
