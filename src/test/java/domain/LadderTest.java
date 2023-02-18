package domain;

import domain.value.Direction;
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
    @DisplayName("Line 을 받아 생성된다")
    void Line_을_받아_생성된다() {
        // given
        Scaffold scaffold1 = Scaffold.EXIST;
        Scaffold scaffold2 = Scaffold.NONE;
        Line line = new Line(List.of(scaffold1, scaffold2));

        // when & then
        assertDoesNotThrow(() -> new Ladder(List.of(line)));
    }

    @ParameterizedTest(name = "Line 개수가 높이이다")
    @MethodSource("sameLengthLines")
    void Line_개수가_높이이다(final List<Line> lines) {
        // given
        Ladder ladder = new Ladder(lines);

        // when & then
        assertThat(ladder.getHeight().value()).isEqualTo(lines.size());
    }

    @Test
    void 들어오는_Line_들의_개수가_0인_경우_예외가_발생한다() {
        // when & then
        assertThatThrownBy(() ->
                new Ladder(List.of())
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "사다리의 너비는 Line 의 길이와 동일해야 한다")
    @MethodSource("sameLengthLines")
    void 사다리의_너비는_Line_의_길이와_동일해야_한다(final List<Line> lines) {
        // given
        Ladder ladder = new Ladder(lines);

        // when & then
        assertThat(ladder.getWidth().value()).isEqualTo(lines.get(0).size());
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
    void 사다리에_속한_Line_은_모두_길이가_같아야_한다(final List<Line> lines) {
        // when & then
        assertThatThrownBy(() ->
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

    /**
     * 0     1     2     3     4     5
     * |     |-----|     |     |-----|
     * <p>
     * 위 상황인 경우,
     * 0 -> NONE,
     * 1 -> RIGHT,
     * 2 -> LEFT
     * 3 -> NONE,
     * 4 -> RIGHT,
     * 5 -> LEFT
     */
    @Test
    void directionOfScaffoldExist_는_주어진_위치로부터_Scaffold_가_존재하는_방향을_반환한다() {
        // given
        Line line =
                // 모양:  |     |-----|     |     |-----|
                new Line(List.of(
                        Scaffold.NONE,
                        Scaffold.EXIST,
                        Scaffold.NONE,
                        Scaffold.NONE,
                        Scaffold.EXIST
                ));

        // when & then
        assertThat(line.directionOfScaffoldExist(0))
                .isEqualTo(Direction.NONE);
        assertThat(line.directionOfScaffoldExist(1))
                .isEqualTo(Direction.RIGHT);
        assertThat(line.directionOfScaffoldExist(2))
                .isEqualTo(Direction.LEFT);
        assertThat(line.directionOfScaffoldExist(3))
                .isEqualTo(Direction.NONE);
        assertThat(line.directionOfScaffoldExist(4))
                .isEqualTo(Direction.RIGHT);
        assertThat(line.directionOfScaffoldExist(5))
                .isEqualTo(Direction.LEFT);
    }

    @Test
    void directionOfScaffoldExist_로_주어지는_위치가_0보다_작거나_전체_Scaffold_수보다_큰_경우_예외가_발생한다() {
        // given
        Line line =
                // 모양:  |     |-----|     |     |-----|
                new Line(List.of(
                        Scaffold.NONE,
                        Scaffold.EXIST,
                        Scaffold.NONE,
                        Scaffold.NONE,
                        Scaffold.EXIST
                ));

        // when & then
        assertThatThrownBy(() ->
                line.directionOfScaffoldExist(-1)
        ).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->
                line.directionOfScaffoldExist(-6)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
