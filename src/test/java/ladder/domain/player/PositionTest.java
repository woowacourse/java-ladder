package ladder.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    @Test
    @DisplayName("참여자는 자신의 위치 정보를 가진다.")
    void testConstruct() {
        Position position = new Position(0);
        assertThat(position).isEqualTo(new Position(0));
    }

    @Test
    @DisplayName("참여자의 위치가 0보다 작다면 예외가 발생한다.")
    void invalidPosition() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
