package domain.ladder;

import domain.value.Direction;
import domain.value.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("Line 은")
public class LineTest {

    @Test
    void Scaffold_List_를_통해_생성된다() {
        // when & then
        assertThatCode(() ->
                new Line(List.of(Scaffold.NONE, Scaffold.EXIST))
        ).doesNotThrowAnyException();
    }

    @Test
    void 발판의_개수는_1개_이상이어야_한다() {
        // when & then
        assertThatThrownBy(() ->
                new Line(List.of())
        ).isInstanceOf(IllegalArgumentException.class);
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
    @ParameterizedTest(name = "directionOfScaffoldExist()는 주어진 위치로부터 Scaffold 가 존재하는 방향을 반환한다")
    @CsvSource(value = {
            "0 -> NONE",
            "1 -> RIGHT",
            "2 -> LEFT",
            "3 -> NONE",
            "4 -> RIGHT",
            "5 -> LEFT",
    }, delimiterString = " -> ")
    void directionOfScaffoldExist_는_주어진_위치로부터_Scaffold_가_존재하는_방향을_반환한다(final int position, final Direction direction) {
        // given
        Line line = new Line(List.of(Scaffold.NONE, Scaffold.EXIST, Scaffold.NONE, Scaffold.NONE, Scaffold.EXIST));

        // when & then
        assertThat(line.directionOfScaffoldExist(Position.of(position)))
                .isEqualTo(direction);
    }

    @Test
    void directionOfScaffoldExist_로_주어지는_위치가_0보다_작거나_전체_Scaffold_수보다_큰_경우_예외가_발생한다() {
        // given
        Line line = new Line(List.of(Scaffold.NONE, Scaffold.EXIST, Scaffold.NONE, Scaffold.NONE, Scaffold.EXIST));
        Position underRangePosition = Position.of(-1);
        Position upRangePosition = Position.of(line.size() + 1);

        // when & then
        assertThatThrownBy(() ->
                line.directionOfScaffoldExist(underRangePosition)
        ).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->
                line.directionOfScaffoldExist(upRangePosition)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
