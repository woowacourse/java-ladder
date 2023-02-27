package domain.player;

import domain.ladder.Direction;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    @ParameterizedTest
    @CsvSource(value = {"gray:0", "encho:1", "pobi:2", "ann:3"}, delimiter = ':')
    @DisplayName("이름의 길이가 1~5인 경우, 예외가 발생하지 않는다.")
    void validateNameLength_Success(String name, int position) {
        assertThatNoException().isThrownBy(() -> new Player(name, position));
    }

    @ParameterizedTest
    @ValueSource(strings = {"gray1234", ""})
    @DisplayName("이름의 길이가 1~5가 아닌 경우, 예외가 발생한다.")
    void validateNameLength_Fail(String name) {
        int mockPosition = 0;

        assertThatThrownBy(() -> new Player(name, mockPosition))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참가자 이름의 길이는 1이상 5이하만 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {" gray", "ann ", "po bi", " "})
    @DisplayName("이름에 공백이 있는 경우 예외가 발생한다.")
    void validateNameWithSpace_Fail(String name) {
        int mockPosition = 0;

        assertThatThrownBy(() -> new Player(name, mockPosition))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참가자 이름에는 공백이 들어갈 수 없습니다.");
    }

    @Test
    @DisplayName("참가자가 오른쪽으로 이동하는 경우 position 값이 1 증가한다.")
    void movePlayerToRight() {
        int initialPosition = 0;
        Player player = new Player("gray", initialPosition);

        player.move(Direction.RIGHT);

        assertThat(player.getPosition().getValue()).isEqualTo(initialPosition + 1);
    }

    @Test
    @DisplayName("참가자가 왼쪽으로 이동하는 경우 position 값이 1 감소한다.")
    void movePlayerToLeft() {
        int initialPosition = 1;
        Player player = new Player("gray", initialPosition);

        player.move(Direction.LEFT);

        assertThat(player.getPosition().getValue()).isEqualTo(initialPosition - 1);
    }

    @Test
    @DisplayName("참가자가 아래로 내려가는 경우 position 값은 유지된다.")
    void movePlayerToStraight() {
        int initialPosition = 0;
        Player player = new Player("gray", initialPosition);

        player.move(Direction.STRAIGHT);

        assertThat(player.getPosition().getValue()).isEqualTo(initialPosition );
    }

}
