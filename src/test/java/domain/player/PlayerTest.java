package domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {

    @DisplayName("앞 뒤 공백을 제외한 이름의 길이가 1글자부터 5글자 사이인 경우 플레이어가 올바르게 생성된다.")
    @ParameterizedTest
    @CsvSource(value = {"  kong:4", "kong  :4", "ko ng:5"}, delimiter = ':')
    void validateTest_name1(String name, int length) {
        Player player = new Player(name, 1);
        assertThat(player.getName().length()).isEqualTo(length);
    }

    @DisplayName("사람 이름은 1글자에서 5글자 사이이다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "kongha", "  ", "ko   ng"})
    void validateTest_name2(String name) {
        assertThatThrownBy(() -> new Player(name, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사람 이름은 1글자에서 5글자 사이이어야 합니다.");
    }

    @DisplayName("사람 이름이 1글자부터 5글자 사이로 입력되고, 0 이상의 위치 정보가 입력되는 경우에는 플레이어가 생성된다.")
    @ParameterizedTest
    @CsvSource(value = {"odo:1", "kong:0"}, delimiter = ':')
    void validateTest_name3(String name, int position) {
        assertThatCode(() -> new Player(name, position))
                .doesNotThrowAnyException();
    }

    @DisplayName("0 미만의 위치 정보가 입력되면 플레이어는 생성되지 않는다.")
    @ParameterizedTest
    @CsvSource(value = {"odo:-1", "kong:-3"}, delimiter = ':')
    void validateTest_position(String name, int position) {
        assertThatThrownBy(() -> new Player(name, position))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사람의 위치는 자연수여야합니다.");
    }

    @DisplayName("사다리의 연결 구조에 따라 플레이어의 위치 정보가 양 옆으로 움직일 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"odo:1:RIGHT:2", "kong:3:STAY:3", "kong:1:LEFT:0"}, delimiter = ':')
    void validateTest_move1(String name, int position, MoveType moveType, int expected) {
        Player player = new Player(name, position);
        player.move(moveType);
        assertThat(player.getPosition()).isEqualTo(expected);
    }

    @DisplayName("플레이어는 음수의 위치 정보를 가질 수 없다.")
    @ParameterizedTest
    @CsvSource(value = {"odo:0:LEFT"}, delimiter = ':')
    void validateTest_move3(String name, int position, MoveType moveType) {
        Player player = new Player(name, position);
        assertThatThrownBy(() -> player.move(moveType))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사람의 위치는 자연수여야합니다.");
    }

    @DisplayName("플레이어의 이름이 동일한 경우에는 동일한 플레이어이다.")
    @Test
    void validateTest_equals() {
        String name = "kong";
        Player player1 = new Player(name, 0);
        Player player2 = new Player(name, 0);
        assertThat(player1).isEqualTo(player2);
    }
}
