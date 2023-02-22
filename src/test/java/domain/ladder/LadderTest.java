package domain.ladder;

import domain.value.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static domain.ladder.Scaffold.EXIST;
import static domain.ladder.Scaffold.NONE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("Ladder 는")
public class LadderTest {

    private static final ScaffoldGenerator scaffoldGenerator = () -> EXIST;

    @Test
    @DisplayName("Line 을 받아 생성된다")
    void Line_을_받아_생성된다() {
        // given
        Line line = new Line(List.of(EXIST, EXIST));

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
        Line line1 = new Line(List.of(EXIST));
        Line line2 = new Line(List.of(EXIST, EXIST));
        Line line3 = new Line(List.of(EXIST, EXIST, EXIST));
        Line line4 = new Line(List.of(EXIST, EXIST, EXIST, EXIST));

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
        Line line1 = new Line(List.of(EXIST));
        Line line2 = new Line(List.of(EXIST, EXIST));
        Line line3 = new Line(List.of(EXIST, EXIST, EXIST));
        Line line4 = new Line(List.of(EXIST, EXIST, EXIST, EXIST));

        return Stream.of(
                Arguments.of(List.of(line2, line1)),
                Arguments.of(List.of(line1, line2)),
                Arguments.of(List.of(line1, line1, line2)),
                Arguments.of(List.of(line3, line3, line3, line4))
        );
    }

    /**
     * 0     1     2     3
     * |-----|     |-----|
     * |     |-----|     |
     * |-----|     |     |
     * |     |-----|     |
     * |-----|     |-----|
     * 0     1     2     3
     * <p>
     * 0 에서 내려가는 경우 -> 0
     * 1 에서 내려가는 경우 -> 3
     * 2 에서 내려가는 경우 -> 2
     * 3 에서 내려가는 경우 -> 1
     */
    @Test
    void goDown_은_특정_시작_위치로부터_내려갈_수_있으며_사다리를_다_내려갔을때의_위치를_반환한다() {
        // given
        /*
         * |-----|     |-----|
         * |     |-----|     |
         * |-----|     |     |
         * |     |-----|     |
         * |-----|     |-----|
         */
        List<Line> lines = List.of(
                new Line(List.of(EXIST, NONE, EXIST)),
                new Line(List.of(NONE, EXIST, NONE)),
                new Line(List.of(EXIST, NONE, NONE)),
                new Line(List.of(NONE, EXIST, NONE)),
                new Line(List.of(EXIST, NONE, EXIST))
        );
        Ladder ladder = new Ladder(lines);

        // when & then
        assertAll(
                () -> assertThat(ladder.goDown(Position.of(0))).isEqualTo(Position.of(0)),
                () -> assertThat(ladder.goDown(Position.of(1))).isEqualTo(Position.of(3)),
                () -> assertThat(ladder.goDown(Position.of(2))).isEqualTo(Position.of(2)),
                () -> assertThat(ladder.goDown(Position.of(3))).isEqualTo(Position.of(1))
        );
    }
}
