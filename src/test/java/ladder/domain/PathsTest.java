package ladder.domain;

import ladder.util.RandomBooleanGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

public class PathsTest {

    @DisplayName("랜덤하게 Boolean값을 생성하는 생성기를 넘기면 Paths 인스턴스를 생성한다.")
    @Test
    void Paths_인스턴스_생성() {
        // Given
        final Supplier<Boolean> randomGenerator = new RandomBooleanGenerator();
        final int ladderSpaceCount = 7;

        // When
        Paths paths = Paths.init(randomGenerator, ladderSpaceCount);

        // Then
        assertThat(paths).isNotNull();
    }
}
