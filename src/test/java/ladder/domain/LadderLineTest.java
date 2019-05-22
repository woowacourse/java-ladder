package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
    void 라인_첫번째_상태값_확인하기() {
        LadderLine line = new LadderLine(3);
        Assertions.assertFalse(line.isMatchLineState(0));
    }

    @Test
    void 라인_결과_출력() {
        System.out.println(new LadderLine(5));
    }
}
