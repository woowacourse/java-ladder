package laddergame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Player는")
class PlayerTest {

    @DisplayName("생성된다.")
    @Test
    void create() {
        assertDoesNotThrow(() -> new Player(new PersonalName("hihi"), 0));
    }

    @DisplayName("위치를 가져올 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 3, 2, 4, 5, 11})
    void getPosition(int value) {
        Player player = new Player(new PersonalName("name"), value);
        Position position = player.getPosition();

        assertThat(position.getValue()).isEqualTo(value);
    }

    @DisplayName("오른쪽으로 움직일 수 있다.")
    @Test
    void moveRight() {
        Player player = new Player(new PersonalName("hihi"), 0);

        player.moveRight();

        Position position = player.getPosition();
        assertThat(position.getValue()).isEqualTo(1);
    }
}