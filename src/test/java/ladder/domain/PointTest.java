package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class PointTest {
    @Test
    void 랜덤값_확인하기_true_입력() {
        assertFalse(Point.setNextState(true));
    }

    @Test
    void 랜덤값_확인하기_false_입력() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Point.setNextState(false));
        }
    }
}
