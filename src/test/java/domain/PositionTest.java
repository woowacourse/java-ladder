package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PositionTest {

    @Test
    void 현재_위치의_왼쪽을_알_수_있다() {
        Position position = new Position(1);

        assertThat(position.left().getPosition()).isEqualTo(0);
    }

    @Test
    void 현재_위치의_오른쪽을_알_수_있다() {
        Position position = new Position(1);

        assertThat(position.right().getPosition()).isEqualTo(2);
    }

    @ParameterizedTest
    @CsvSource({"-1,false", "0,true", "2,true", "3,false"})
    void 위치가_특정_범위_사이에_있는지_알_수_있다(int position, boolean isInRange) {
        Position currentPosition = new Position(position);

        assertThat(currentPosition.isInBetween(0, 3)).isEqualTo(isInRange);
    }

    @ParameterizedTest
    @CsvSource({"LEFT,0", "RIGHT,2", "STAY,1"})
    void 어떤_방향으로_움직인다(Direction direction, int expectedPosition) {
        Position position = new Position(1);

        assertThat(position.moveTo(direction)).isEqualTo(new Position(expectedPosition));
    }
}
