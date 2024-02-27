package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PathTest {

    @DisplayName("시작 라인 번호, 끝 라인 번호를 입력하면 Path 인스턴스를 생성한다.")
    @Test
    void Path_인스턴스_생성() {
        // Given
        final int startLineNumber = 1;
        final int endLineNumber = 2;

        // When
        Path path = Path.of(startLineNumber, endLineNumber);

        // Then
        assertThat(path).isNotNull();
    }
}
