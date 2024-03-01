package domain.ladder;

import domain.LineNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.RandomBooleanGenerator;

import java.util.List;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

public class PathsTest {

    @DisplayName("랜덤하게 Boolean값을 생성하는 생성기를 넘기면 Paths 인스턴스를 생성한다.")
    @Test
    void Paths_인스턴스_생성() {
        // Given
        Supplier<Boolean> randomGenerator = new RandomBooleanGenerator();
        int ladderSpaceCount = 7;

        // When
        Paths paths = Paths.init(randomGenerator, ladderSpaceCount);

        // Then
        assertThat(paths).isNotNull();
    }

    @DisplayName("Path들의 상태를 반환한다.")
    @Test
    void Path들_상태_반환() {
        // Given
        int ladderSpaceCount = 7;
        Paths paths = Paths.init(new RandomBooleanGenerator(), ladderSpaceCount);

        // When
        List<PathStatus> pathStatuses = paths.getPathStatuses();

        // Then
        assertThat(pathStatuses).hasSize(ladderSpaceCount);
    }

    @DisplayName("발판이 존재하는 라인인 경우, 반대쪽 라인 까지의 거리를 반환한다.")
    @Test
    void 발판_존재하는_라인이면_반대쪽_라인_까지_거리_반환() {
        // Given
        Paths paths = Paths.init(() -> true, 4);
        LineNumber lineNumber = new LineNumber(2);

        // When
        int otherLineDistance = paths.getOtherLineNumber(lineNumber);

        // Then
        assertThat(otherLineDistance).isEqualTo(-1);
    }
}
