package laddergame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import laddergame.domain.game.player.Player;
import laddergame.domain.game.player.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Player는")
class PlayerTest {

    @DisplayName("생성된다.")
    @Test
    void create() {
        assertDoesNotThrow(() -> new Player(PersonalName.valueOf("hihi"), 0));
    }

    @DisplayName("위치를 가져올 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 3, 2, 4, 5, 11})
    void getPosition(int value) {
        Player player = new Player(PersonalName.valueOf("name"), value);
        Position position = player.getPosition();

        assertThat(position.getValue()).isEqualTo(value);
    }

    @DisplayName("오른쪽으로 움직일 수 있다.")
    @Test
    void moveRight() {
        Player player = new Player(PersonalName.valueOf("hihi"), 0);

        player.moveRight();

        Position position = player.getPosition();
        assertThat(position.getValue()).isEqualTo(1);
    }

    @DisplayName("왼쪽으로 움질일 수 있다.")
    @Test
    void moveLeft() {
        Player player = new Player(PersonalName.valueOf("hihi"), 2);

        player.moveLeft();

        Position position = player.getPosition();
        assertThat(position.getValue()).isEqualTo(1);
    }

    @DisplayName("이미 맨 왼쪽인데 왼쪽으로 움직이려 하면 예외를 던진다.")
    @Test
    void throwExceptionAlreadyStartOfTheLine() {
        Player player = new Player(PersonalName.valueOf("hihi"), 0);
        assertThatThrownBy(() -> player.moveLeft())
                .isInstanceOf(IllegalArgumentException.class);
    }
}