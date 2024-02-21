package formatter;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LineFormatterTest {
    private static Stream<Arguments> generateLineTestData() {
        return Stream.of(
                Arguments.of(Arrays.asList(true, false, true), "    |-----|     |-----|"),
                Arguments.of(Arrays.asList(false, true, false), "    |     |-----|     |"),
                Arguments.of(Arrays.asList(true, false, false), "    |-----|     |     |"),
                Arguments.of(Arrays.asList(false, false, true), "    |     |     |-----|")
        );
    }

    @ParameterizedTest(name = "사다리 라인을 형식에 맞추어 반환한다.")
    @MethodSource("generateLineTestData")
    void formatLine(List<Boolean> line, String expected) {
        String formattedLine = LineFormatter.format(line);
        assertThat(formattedLine).isEqualTo(expected);
    }
}