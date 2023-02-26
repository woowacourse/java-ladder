package model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayNameGeneration(ReplaceUnderscores.class)
class DirectionTest {

    @ParameterizedTest
    @CsvSource(value = {"LEFT:0", "RIGHT:2", "NONE:1"}, delimiter = ':')
    void move_메소드는_Direction에_따라_position에_offset을_적용해_반환한다(Direction direction, int expected) {
        int actual = direction.move(1);

        assertThat(actual).isSameAs(expected);
    }
}
