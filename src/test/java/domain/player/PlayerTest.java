package domain.player;

import domain.player.Player;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {

    @DisplayName("참가자 이름이 1글자 이상 5글자 이하이면 참가자 객체가 잘 생성된다..")
    @ParameterizedTest
    @ValueSource(strings = {"a", "aaa12"})
    void validNameLength(String playerName) {
        //when & then
        Assertions.assertThatCode(() -> new Player(playerName, 0))
                .doesNotThrowAnyException();
    }

    @DisplayName("참가자 이름이 1글자 미만 5글자 초과이면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"abc123", ""})
    void invalidNameLength(String playerName) {
        //when & then
        Assertions.assertThatThrownBy(() -> new Player(playerName, 0)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참가자의 위치를 왼쪽으로 이동시킨다.")
    @Test
    void moveLeft() {
        //given
        final Player player = new Player("a", 0);
        final Position expectedPosition = new Position(-1);

        //when
        player.moveLeft();

        //then
        Assertions.assertThat(player.getPosition()).isEqualTo(expectedPosition);
    }

    @DisplayName("참가자의 위치를 오른쪽으로 이동시킨다.")
    @Test
    void moveRight() {
        //given
        final Player player = new Player("a", 0);
        final Position expectedPosition = new Position(1);

        //when
        player.moveRight();

        //then
        Assertions.assertThat(player.getPosition()).isEqualTo(expectedPosition);
    }
}
