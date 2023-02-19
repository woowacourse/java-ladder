package domain.ladder;

import domain.value.Direction;
import domain.value.Position;
import domain.value.Width;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("Line 은")
public class LineTest {

    private final ScaffoldGenerator scaffoldGenerator = () -> Scaffold.EXIST;

    @Test
    void 가로길이와_발판생성기를_통해_생성된다() {
        // when & then
        assertDoesNotThrow(() ->
                Line.create(Width.of(3), scaffoldGenerator)
        );
    }

    @ParameterizedTest(name = "Line 은 Width 만큼의 길이를 가진다")
    @ValueSource(ints = {1, 2, 3})
    void Line_은_Width_만큼의_길이를_가진다(final int width) {
        // when
        Line line = Line.create(Width.of(width), scaffoldGenerator);

        // then
        assertThat(line.size()).isEqualTo(width);
    }

    @Test
    void 발판의_개수는_1개_이상이어야_한다() {
        // when & then
        assertThatThrownBy(() ->
                Line.create(Width.of(0), scaffoldGenerator)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Line_은_존재하는_발판을_연속으로_가지고_생성되지_않는다() {
        // given
        ScaffoldGenerator onlyReturnExistGenerator = () -> Scaffold.EXIST;

        // when
        Line line = Line.create(Width.of(10), onlyReturnExistGenerator);

        // then
        List<Scaffold> scaffolds = line.getScaffolds();
        Deque<Scaffold> scaffoldDeque = new ArrayDeque<>(scaffolds);
        scaffolds.forEach(it -> {
            Scaffold beforeScaffold = scaffoldDeque.removeFirst();
            if (beforeScaffold == scaffoldDeque.peekFirst()) {
                assertThat(beforeScaffold).isEqualTo(Scaffold.EXIST);
            }
        });
    }

    @Test
    void Line_에_속한_발판은_존재하지_않는_상태는_연속으로_가질_수_있다() {
        // given
        ScaffoldGenerator onlyReturnNoneGenerator = () -> Scaffold.NONE;

        // when & then
        assertDoesNotThrow(() ->
                Line.create(Width.of(100), onlyReturnNoneGenerator)
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
        ScaffoldGenerator generator = new ScaffoldGenerator() {
            private final List<Scaffold> scaffolds =
                    // 모양:  |     |-----|     |     |-----|
                    List.of(Scaffold.NONE, Scaffold.EXIST, Scaffold.NONE, Scaffold.NONE, Scaffold.EXIST);
            private int index = 0;

            @Override
            public Scaffold generate() {
                return scaffolds.get(index++);
            }
        };

        Line line = Line.create(Width.of(5), generator);

        // when & then
        assertThat(line.directionOfScaffoldExist(Position.of(0)))
                .isEqualTo(Direction.NONE);
        assertThat(line.directionOfScaffoldExist(Position.of(1)))
                .isEqualTo(Direction.RIGHT);
        assertThat(line.directionOfScaffoldExist(Position.of(2)))
                .isEqualTo(Direction.LEFT);
        assertThat(line.directionOfScaffoldExist(Position.of(3)))
                .isEqualTo(Direction.NONE);
        assertThat(line.directionOfScaffoldExist(Position.of(4)))
                .isEqualTo(Direction.RIGHT);
        assertThat(line.directionOfScaffoldExist(Position.of(5)))
                .isEqualTo(Direction.LEFT);
    }

    @Test
    void directionOfScaffoldExist_로_주어지는_위치가_0보다_작거나_전체_Scaffold_수보다_큰_경우_예외가_발생한다() {
        // given
        ScaffoldGenerator generator = new ScaffoldGenerator() {
            private final List<Scaffold> scaffolds =
                    // 모양:  |     |-----|     |     |-----|
                    List.of(Scaffold.NONE, Scaffold.EXIST, Scaffold.NONE, Scaffold.NONE, Scaffold.EXIST);
            private int index = 0;

            @Override
            public Scaffold generate() {
                return scaffolds.get(index++);
            }
        };

        Line line = Line.create(Width.of(5), generator);
        // when & then
        assertThatThrownBy(() ->
                line.directionOfScaffoldExist(Position.of(-1))
        ).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->
                line.directionOfScaffoldExist(Position.of(6))
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
