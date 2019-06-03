package ladder.model.generator;

import ladder.model.Direction;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RowGeneratorTest {

    @Test
    void 연결정보로_true와_false가_주어졌을때_테스트() {
        Direction first = Direction.first(true);
        Direction next = first.next(false);
        assertThat(RowGenerator.makeDirections(Arrays.asList(true, false)))
                .isEqualTo(Arrays.asList(first, next, next.last()));
    }
}
