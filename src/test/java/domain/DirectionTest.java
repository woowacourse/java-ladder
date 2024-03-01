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
    @DisplayName("첫 방향은 왼쪽이 될 수 없다")
    void generateFirst() {
        TrueGenerator trueGenerator = new TrueGenerator();

        assertThat(Direction.generateFirst(trueGenerator.next())).isNotEqualTo(Direction.LEFT);
    }

    @Test
    void generateLast() {
    }

    @Test
    void next() {
    }
}
