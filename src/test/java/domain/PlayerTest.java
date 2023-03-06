package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PlayerTest {

    @Test
    @DisplayName("문자열로 된 이름 입력값이 6글자를 미만이면 player 객체가 생성")
    void makePlayerUsingLessThanSixCharactersAsAnInput() {
        String inputName = "abcde";
        int position = 0;
        assertDoesNotThrow(() -> new Player(inputName, position));

    }

    @Test
    @DisplayName("문자열로 된 이름 입력값이 5글자를 초과할 경우 입 예외 발생")
    void throwExceptionUsingMoreThanFiveCharactersAsAnInput() {
        String inputName = "abcdef";
        int position = 0;
        assertThatThrownBy(() -> new Player(inputName, position))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 사람 이름은 최대 5글자 입니다.");
    }

    @Test
    @DisplayName("Player가 오른쪽으로 이동할 경우 position 값이 1만큼 증가")
    void moveToRightDirection() {
        String name = "roy";
        int position = 0;
        Player player = new Player(name, position);

        player.moveToRight();

        assertThat(player.getPosition()).isEqualTo(position + 1);
    }

    @Test
    @DisplayName("Player가 왼쪽으로 이동할 경우 position 값이 1만큼 감소")
    void moveToLeftDirection() {
        String name = "roy";
        int position = 1;
        Player player = new Player(name, position);

        player.moveToLeft();

        assertThat(player.getPosition()).isEqualTo(position - 1);
    }
}
