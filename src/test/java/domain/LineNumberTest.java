package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineNumberTest {

    @DisplayName("라인 번호를 입력하면 인스턴스를 생성한다.")
    @Test
    void 라인_번호_인스턴스_생성() {
        // Given
        final int inputLineNumber = 1;

        // When
        LineNumber lineNumber = new LineNumber(inputLineNumber);

        // Then
        assertThat(lineNumber).isNotNull();
    }

    @DisplayName("유효하지 않은 라인 번호를 입력하면 예외를 발생시킨다.")
    @ValueSource(ints = {-1, 0})
    @ParameterizedTest
    void 유효하지_않은_라인_번호_예외_발생(final int inputLineNumber) {
        // When & Then
        assertThatThrownBy(() -> new LineNumber(inputLineNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 라인 번호입니다.");
    }

    @DisplayName("입력된 정수와 일치하면 true를 반환한다.")
    @Test
    void 정수_일치_체크() {
        // Given
        LineNumber lineNumber = new LineNumber(5);

        // When
        boolean isEqual = lineNumber.isEqual(5);

        // Then
        assertThat(isEqual).isTrue();
    }
}
