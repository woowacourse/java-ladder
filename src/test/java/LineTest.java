import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("Line 은")
public class LineTest {

    @Test
    void 발판들을_받아_생성된다() {
        // given
        Scaffold scaffold1 = Scaffold.NONE;
        Scaffold scaffold2 = Scaffold.EXIST;
        Scaffold scaffold3 = Scaffold.NONE;

        // when & then
        assertDoesNotThrow(() ->
                new Line(List.of(scaffold1, scaffold2, scaffold3))
        );
    }

    @ParameterizedTest
    @MethodSource("scaffolds")
    void 발판은_입력받은_숫자만큼의_크기를_가진다(final List<Scaffold> scaffolds) {
        // when
        Line line = new Line(scaffolds);

        // then
        assertThat(line.size()).isEqualTo(scaffolds.size());
    }

    private static Stream<Arguments> scaffolds() { // argument source method
        return Stream.of(
                Arguments.of(List.of(Scaffold.NONE, Scaffold.EXIST, Scaffold.NONE, Scaffold.EXIST)),
                Arguments.of(List.of(Scaffold.EXIST, Scaffold.EXIST, Scaffold.EXIST)),
                Arguments.of(List.of(Scaffold.NONE, Scaffold.NONE)),
                Arguments.of(List.of(Scaffold.EXIST)),
                Arguments.of(List.of())
        );
    }
}
