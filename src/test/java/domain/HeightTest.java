package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

class HeightTest {
    @DisplayName("생성자 테스트")
    @Test
    void create() {
        new Height(1);
    }

    @DisplayName("높이가 정수로 들어오는지 확인")
    @Test
    void checkIntegerSuccess() {
        assertThatNoException().isThrownBy(() -> new Height(1));
    }

    @DisplayName("높이가 숫자가 0이하 일 때 에러")
    @Test
    void nonDigitFail2() {
        Assertions.assertThatThrownBy(() -> new Height(0)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("높이의 값과 비교 기능 확인")
    @Test
    void countOfHeight() {
        Height height = new Height(1);
        assertThat(height.isSameHeight(1)).isFalse();

    }
}
