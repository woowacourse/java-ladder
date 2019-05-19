package ladder.domain.generator;

import ladder.domain.Direction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionsRandomGeneratorTest {
    List<Direction> actual;

    @BeforeEach
    void setUp() {
         actual = new DirectionsRandomGenerator(3).generate();
    }

    @Test
    void size_검사() {
        assertThat(actual.size()).isEqualTo(3);
    }
}