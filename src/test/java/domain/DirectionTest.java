package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DirectionTest {

    @DisplayName("다른 방향과 우선순위를 비교할 수 있다.")
    @Test
    void comparePriority() {
        Direction left = Direction.LEFT;
        Direction stay = Direction.STAY;

        assertThat(left.getHigherPriority(stay))
                .isEqualTo(Direction.LEFT);
    }

    @DisplayName("같은 우선순위를 가진 방향과 비교되면, 자기 자신이 반환된다.")
    @Test
    void compareSamePriority() {
        Direction stay1 = Direction.STAY;
        Direction stay2 = Direction.STAY;

        assertThat(stay1.getHigherPriority(stay2))
                .isEqualTo(Direction.STAY);
    }
}
