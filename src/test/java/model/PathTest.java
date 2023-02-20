package model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayNameGeneration(ReplaceUnderscores.class)
class PathTest {

    @ParameterizedTest
    @CsvSource(value = {"PASSABLE:true:UN_PASSABLE", "PASSABLE:false:UN_PASSABLE",
            "UN_PASSABLE:true:PASSABLE", "UN_PASSABLE:false:UN_PASSABLE"}, delimiter = ':')
    void calculatePath_메소드는_좌측_Path와_Generator가_주어지면_Path를_반환한다(Path otherPath,
            boolean passable, Path expected) {
        Path actual = Path.calculatePath(otherPath, passable);

        assertThat(actual).isSameAs(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"false:UN_PASSABLE", "true:PASSABLE"}, delimiter = ':')
    void calculatePath_메소드는_Generator가_주어지면_Path를_반환한다(boolean passable, Path expected) {
        Path actual = Path.calculatePath(passable);

        assertThat(actual).isSameAs(expected);
    }

    @Test
    void isMultiplePassable_메소드는_자신과_주어진_Path를_이어서_건널_수_있다면_true를_반환한다() {
        boolean actual = Path.PASSABLE.isMultiplePassable(Path.PASSABLE);

        assertThat(actual).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"PASSABLE:UN_PASSABLE", "UN_PASSABLE:PASSABLE",
            "UN_PASSABLE:UN_PASSABLE"}, delimiter = ':')
    void isMultiplePassable_메소드는_자신과_주어진_Path를_이어서_건널_수_없다면_false를_반환한다(Path leftPath,
            Path rightPath) {
        boolean actual = leftPath.isMultiplePassable(rightPath);

        assertThat(actual).isFalse();
    }
}
