package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

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
}
