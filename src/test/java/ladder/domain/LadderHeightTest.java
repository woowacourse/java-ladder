package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderHeightTest {
    @Test
    void null값() {
        assertThrows(NullPointerException.class, () -> {
            new LadderHeight(null);
        });
    }

    @Test
    void 입력_없음() {
        assertThrows(NullPointerException.class, () -> {
            new LadderHeight("");
        });
    }

    @Test
    void 정수가_아닌_입력() {
        assertThrows(IllegalArgumentException.class, () -> {
            new LadderHeight("-1");
        });
    }

    @Test
    void 높이가_0_이하인_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            new LadderHeight("-2");
        });
    }
}