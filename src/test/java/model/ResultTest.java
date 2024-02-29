package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

    @DisplayName("공백이나 비어있지 않은 문자열은 예외가 발생하지 않는다.")
    @Test
    void validateResult() {
        Assertions.assertThatCode(() -> new Result("꽝"))
                .doesNotThrowAnyException();
    }

    @DisplayName("공백이나 빈 문자열이 들어가면 예외가 발생한다.")
    @Test
    void EmptyAndBlankResult() {
        Assertions.assertThatThrownBy(() -> new Result(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
