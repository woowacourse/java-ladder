package view.formatter;

import static org.assertj.core.api.Assertions.assertThat;

import dto.LineDto;
import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LineDtoFormatterTest {
    private static Stream<Arguments> generateLineTestData() {
        return Stream.of(
                Arguments.of(new LineDto(Arrays.asList(true, false, true)), "    |-----|     |-----|"),
                Arguments.of(new LineDto(Arrays.asList(false, true, false)), "    |     |-----|     |"),
                Arguments.of(new LineDto(Arrays.asList(true, false, false)), "    |-----|     |     |"),
                Arguments.of(new LineDto(Arrays.asList(false, false, true)), "    |     |     |-----|")
        );
    }

    @ParameterizedTest(name = "사다리 라인을 형식에 맞추어 반환한다.")
    @MethodSource("generateLineTestData")
    void formatLine(LineDto lineDto, String expected) {
        String formattedLine = LineDtoFormatter.format(lineDto);
        assertThat(formattedLine).isEqualTo(expected);
    }
}
