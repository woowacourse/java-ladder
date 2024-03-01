package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {
    @Test
    @DisplayName("올바른 Point로 Line이 잘 생성되는지 확인")
    void normal() {
        // |-----|     |     |-----|
        Line line = new Line(true, false, false, true, false);
        int length = line.length();
        Assertions.assertThat(length)
                .isEqualTo(5);
        // |     |     |     |-----|
        Line line2 = new Line(false, false, false, true, false);
        int length2 = line.length();
        Assertions.assertThat(length2)
                .isEqualTo(5);
    }

    @Test
    @DisplayName("|-----|-----| 인 Point로 Line이 생성되지 않는지 확인")
    void leftContinueOrRightContinue() {
        Assertions.assertThatThrownBy(
                        () -> new Line(true, true, false))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("|-----|-----| 연결 감지!");
    }

    @Test
    @DisplayName("|-----|----- 인 Point로 Line이 생성되지 않는지 확인")
    void rightAfterEnd() {
        Assertions.assertThatThrownBy(
                        () -> new Line(true, false, true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("오른쪽 끝에선 오른쪽으로 갈 수 없습니다.");
    }
}
