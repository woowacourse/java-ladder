package domain;

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
import static org.assertj.core.api.Assertions.assertThatThrownBy;
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

    @ParameterizedTest(name = "발판은 입력받은 숫자만큼의 크기를 가진다")
    @MethodSource("scaffolds")
    void 발판은_입력받은_숫자만큼의_크기를_가진다(final List<Scaffold> scaffolds) {
        // when
        Line line = new Line(scaffolds);

        // then
        assertThat(line.size()).isEqualTo(scaffolds.size());
    }

    private static Stream<Arguments> scaffolds() {
        return Stream.of(
                Arguments.of(List.of(Scaffold.NONE, Scaffold.EXIST, Scaffold.NONE, Scaffold.EXIST)),
                Arguments.of(List.of(Scaffold.EXIST, Scaffold.NONE, Scaffold.EXIST)),
                Arguments.of(List.of(Scaffold.NONE, Scaffold.NONE)),
                Arguments.of(List.of(Scaffold.EXIST))
        );
    }

    @Test
    void 발판의_개수는_1개_이상이어야_한다() {
        // given
        List<Scaffold> scaffolds = List.of();

        // when & then
        assertThatThrownBy(() ->
                new Line(scaffolds)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "domain.Line 에 속한 발판은 존재하는 상태를 연속으로 가질 수 없다")
    @MethodSource("consistExistScaffolds")
    void Line_에_속한_발판은_존재하는_상태를_연속으로_가질_수_없다(final List<Scaffold> scaffolds) {
        // when & then
        assertThatThrownBy(() ->
                new Line(scaffolds)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> consistExistScaffolds() {
        return Stream.of(
                Arguments.of(List.of(Scaffold.EXIST, Scaffold.EXIST, Scaffold.NONE, Scaffold.EXIST)),
                Arguments.of(List.of(Scaffold.EXIST, Scaffold.EXIST, Scaffold.EXIST)),
                Arguments.of(List.of(Scaffold.EXIST, Scaffold.EXIST))
        );
    }

    @Test
    @DisplayName("Line에 속한 발판은 존재하지 않는 상태는 연속으로 가질 수 있다")
    void line_linked_nonlist() {
        // given
        Scaffold nonScaffold = Scaffold.NONE;

        // when & then
        assertDoesNotThrow(() ->
                new Line(List.of(nonScaffold, nonScaffold))
        );
    }
}
