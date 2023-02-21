package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
