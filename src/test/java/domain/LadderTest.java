package domain;

import org.assertj.core.api.Assertions;
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
@DisplayName("Ladder 는")
public class LadderTest {

    @Test
    void Line_을_받아_생성된다() {
        Scaffold scaffold1 = Scaffold.EXIST;
        Scaffold scaffold2 = Scaffold.NONE;

        Line line = new Line(List.of(scaffold1, scaffold2));

        assertDoesNotThrow(() -> new Ladder(List.of(line)));
    }

    @ParameterizedTest(name = "Line 개수가 높이이다")
    @MethodSource("sameLengthLines")
    void Line_개수가_높이이다(final List<Line> lines) {
        Ladder ladder = new Ladder(lines);

        assertThat(ladder.getHeight()).isEqualTo(lines.size());
    }

    @Test
    void Line_의_개수가_0인_경우_예외가_발생한다() {
        assertThatThrownBy(() ->
                new Ladder(List.of())
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "사다리의 너비는 Line 의 길이와 동일해야 한다")
    @MethodSource("sameLengthLines")
    void 너비가_Line_의_길이와_동일해야_한다(final List<Line> lines) {
        Ladder ladder = new Ladder(lines);

        assertThat(ladder.getWidth()).isEqualTo(lines.get(0).size());
    }

    private static Stream<Arguments> sameLengthLines() {
        List<Scaffold> size1Scaffolds = List.of(Scaffold.EXIST);
        List<Scaffold> size2Scaffolds = List.of(Scaffold.EXIST, Scaffold.NONE);
        List<Scaffold> size3Scaffolds = List.of(Scaffold.EXIST, Scaffold.NONE, Scaffold.EXIST);
        List<Scaffold> size4Scaffolds = List.of(Scaffold.EXIST, Scaffold.NONE, Scaffold.EXIST, Scaffold.NONE);

        Line line1 = new Line(size1Scaffolds);
        Line line2 = new Line(size2Scaffolds);
        Line line3 = new Line(size3Scaffolds);
        Line line4 = new Line(size4Scaffolds);

        return Stream.of(
                Arguments.of(List.of(line1, line1)),
                Arguments.of(List.of(line2, line2, line2)),
                Arguments.of(List.of(line3, line3, line3, line3)),
                Arguments.of(List.of(line4, line4, line4, line4, line4)),
                Arguments.of(List.of(line2))
        );
    }

    @ParameterizedTest(name = "사다리에 속한 Line 은 모두 길이가 같아야 한다")
    @MethodSource("differentSizeLines")
    void Ladder_에_속한_Line_은_모두_길이가_같아야_한다(final List<Line> lines) {
        Assertions.assertThatThrownBy(() ->
                new Ladder(lines)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> differentSizeLines() {
        List<Scaffold> size1Scaffolds = List.of(Scaffold.EXIST);
        List<Scaffold> size2Scaffolds = List.of(Scaffold.EXIST, Scaffold.NONE);
        List<Scaffold> size3Scaffolds = List.of(Scaffold.EXIST, Scaffold.NONE, Scaffold.EXIST);
        List<Scaffold> size4Scaffolds = List.of(Scaffold.EXIST, Scaffold.NONE, Scaffold.EXIST, Scaffold.NONE);

        Line line1 = new Line(size1Scaffolds);
        Line line2 = new Line(size2Scaffolds);
        Line line3 = new Line(size3Scaffolds);
        Line line4 = new Line(size4Scaffolds);

        return Stream.of(
                Arguments.of(List.of(line2, line1)),
                Arguments.of(List.of(line1, line2)),
                Arguments.of(List.of(line1, line1, line2)),
                Arguments.of(List.of(line3, line3, line3, line4))
        );
    }
}
