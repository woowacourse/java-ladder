package ladder.domain.player;

import ladder.domain.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    @ParameterizedTest
    @CsvSource(value = {"LEFT, 2", "RIGHT, 4", "CENTER, 3"})
    @DisplayName("참여자는 이동 방향에 따라 이동할 수 있다.")
    void move(Direction direction, int expected) {
        Player player = new Player("pobi", 3);
        player.moveTo(direction);

        assertThat(player.getPosition()).isEqualTo(expected);
    }
}
