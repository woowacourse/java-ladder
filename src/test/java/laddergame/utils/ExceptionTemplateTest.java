package laddergame.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("예외 반복 템플릿")
class ExceptionTemplateTest {
    @DisplayName("한 부분에서 일정한 반복 횟수를 초과하면 예외가 발생한다.")
    @Test
    void throwExceptionWhenRepeatOver20() {
        assertThatThrownBy(() -> ExceptionTemplate.repeatAndPrintCause(this::throwIllegalArgumentException))
                .isInstanceOf(IllegalStateException.class);
    }

    <T> T throwIllegalArgumentException() {
        throw new IllegalArgumentException();
    }
}