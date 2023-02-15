package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DirectionTest {

    @Test
    @DisplayName("방향에 따라 이동할 특정 값을 가진다.")
    void directionHasMoveValue() {
        final List<Integer> moves = Arrays.stream(Direction.values())
                .map(Direction::getMove)
                .collect(Collectors.toList());

        assertThat(moves).containsExactly(-1, 0, 1);
    }
}
