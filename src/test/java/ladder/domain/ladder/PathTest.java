package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PathTest {
    @ParameterizedTest
    @MethodSource("providePathAvailabilityForTest")
    @DisplayName("boolean을 입력받으면 올바른 타입의 Path를 반환한다.")
    void convertPathAvailabilityTest(final boolean input, final Path expectedPath) {
        // when & then
        assertThat(Path.from(input)).isEqualTo(expectedPath);
    }

    private static Stream<Arguments> providePathAvailabilityForTest() {
        return Stream.of(
                Arguments.of(false, Path.EMPTY),
                Arguments.of(true, Path.EXIST)
        );
    }
}
