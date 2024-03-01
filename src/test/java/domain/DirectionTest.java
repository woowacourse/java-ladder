package domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DirectionTest {

    @Test
    void generate() {
    }

    @Test
    @DisplayName("생성된 첫 방향은 왼쪽이 될 수 없다")
    void generateFirst() {
        TrueGenerator trueGenerator = new TrueGenerator();

        assertThat(Direction.generateFirst(trueGenerator.next())).isNotEqualTo(Direction.LEFT);
    }

    @Test
    @DisplayName("생성된 마지막 방향은 오른쪽이 될 수 없다")
    void generateLast() {
        TrueGenerator trueGenerator = new TrueGenerator();

        assertAll(
                () -> assertThat(Direction.generateLast(Direction.RIGHT)).isNotEqualTo(Direction.RIGHT),
                () -> assertThat(Direction.generateLast(Direction.LEFT)).isNotEqualTo(Direction.RIGHT),
                () -> assertThat(Direction.generateLast(Direction.STRAIGHT)).isNotEqualTo(Direction.RIGHT)
        );
    }

    @Test
    void next() {
    }
}
