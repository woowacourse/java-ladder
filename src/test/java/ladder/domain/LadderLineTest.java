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
    void 랜덤값_확인하기_true_입력() {
        assertFalse(LadderLine.setNextState(true));
    }

    @Test
    void 랜덤값_확인하기_false_입력() {
        for (int i = 0; i < 3; i++) {
            System.out.println(LadderLine.setNextState(false));
        }
    }

    @Test
    void 라인_결과_출력() {
        System.out.println(new LadderLine(5));
    }

    @Test
    void 포지션_찾기() {
        LadderLine ladderLine = new LadderLine(5);
        System.out.println(ladderLine);
        System.out.println(ladderLine.getNextPosition(1));
    }
}
