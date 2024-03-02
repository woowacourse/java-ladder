package model.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static model.result.Result.NOT_ALLOWED_NULL_EMPTY_RESULT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class ResultTest {

    @DisplayName("결과가 null이거나 공백인 경우 예외가 발생한다.")
    @Test
    void validateResultNullAndBlank() {
        assertAll(
                () -> assertThatThrownBy(() -> new Result(" ")).isInstanceOf(IllegalArgumentException.class).hasMessage(NOT_ALLOWED_NULL_EMPTY_RESULT),
                () -> assertThatThrownBy(() -> new Result(null)).isInstanceOf(IllegalArgumentException.class).hasMessage(NOT_ALLOWED_NULL_EMPTY_RESULT)
        );
    }

}
