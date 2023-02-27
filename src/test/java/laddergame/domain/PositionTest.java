package laddergame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import laddergame.domain.game.player.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Position은")
class PositionTest {
    @DisplayName("생성된다.")
    @Test
    void create() {
        //given
        //when
        //then
        assertDoesNotThrow(() -> new Position(1));
    }

    @DisplayName("위치 값은 음수일 수 없다.")
    @Test
    void throwExceptionWhenValueIsNegative() {
        //given
        //when
        //then
        assertThatThrownBy(() -> new Position(-1));
    }

    @DisplayName("값이 같으면 동등하다")
    @Test
    void equals() {
        //given
        Position position = new Position(1);
        //when
        //then
        assertThat(position).isEqualTo(new Position(1));
    }

    @DisplayName("값을 가져올 수 있다.")
    @Test
    void getValue() {
        //given
        Position position = new Position(1);
        //when
        int value = position.getValue();
        //then
        assertThat(value).isEqualTo(1);
    }
}