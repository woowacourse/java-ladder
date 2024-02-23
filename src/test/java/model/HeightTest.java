package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HeightTest {

    @DisplayName("높이가 음수인 경우 예외를 발생시킨다.")
    @Test
    public void positiveHeightNotThrowException() {
        Assertions.assertThatCode(() -> new Height(1))
                .doesNotThrowAnyException();
    }

    @DisplayName("높이가 음수인 경우 예외를 발생시킨다.")
    @Test
    public void negativeHeightThrowException() {
        Assertions.assertThatThrownBy(() -> new Height(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최대 사다리의 높이는 양수가 되어야 합니다.");
    }
}
