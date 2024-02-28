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
        final Path path = Path.of(startLineNumber, endLineNumber);

        // Then
        assertThat(path).isNotNull();
    }

    @DisplayName("입력된 LineNumber가 본인의 번호에 포함되면 true를 반환한다.")
    @Test
    void LineNumber_본인_번호인지_포함_체크() {
        // Given
        final Path path = Path.of(2, 3);
        final LineNumber inputLineNumber = new LineNumber(3);

        // When
        final boolean hasPath = path.hasPath(inputLineNumber);

        // Then
        assertThat(hasPath).isTrue();
    }
}
