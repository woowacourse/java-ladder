package laddergame.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    @Test
    @DisplayName("Player가 오른쪽으로 움직일 수 있다.")
    void whenMoveRight_thenSuccess() {
        // given
        final Player player = Player.of("에단", 1);

        // when
        player.moveRight();

        // then
        assertThat(player.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("Player가 왼쪽으로 움직일 수 있다.")
    void whenMoveLeft_thenSuccess() {
        // given
        final Player player = Player.of("에단", 1);

        // when
        player.moveLeft();

        // then
        assertThat(player.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"0, false", "1, true"})
    @DisplayName("Player가 왼쪽으로 움직일 수 있는지 확인한다.")
    void whenCanMoveLeft_thenReturnMovable(final int position, final boolean result) {
        // given
        final Player ethan = Player.of("에단", position);

        // when & then
        assertThat(ethan.canMoveLeft()).isEqualTo(result);
    }
}
