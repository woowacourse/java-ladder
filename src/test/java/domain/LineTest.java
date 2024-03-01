package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {
    @Test
    @DisplayName("올바른 Point로 Line이 잘 생성되는지 확인")
    void normal() {
        Assertions.assertThatNoException()
                .isThrownBy(
                        () -> new Line(true, false, false, true, false));
    }

    @Test
    @DisplayName("|-----|-----| 인 Point로 Line이 생성되지 않는지 확인")
    void leftContinueOrRightContinue() {
        Assertions.assertThatThrownBy(
                        () -> new Line(true, true, false))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("|-----|-----| 연결 감지!");
    }

}
