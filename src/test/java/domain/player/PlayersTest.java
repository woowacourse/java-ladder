package domain.player;

import domain.ladder.Line;
import domain.booleangenerator.TestBooleanGenerator;
import domain.player.Player;
import domain.player.Players;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class PlayersTest {

    @DisplayName("사다리 게임 참여자의 이름이 하나라도 잘못 입력된 경우 예외를 발생시킨다.")
    @Test
    void createPlayersTest1() {
        List<String> names = List.of("odo", "odo27", "kong", "konghana");
        assertThatThrownBy(() -> new Players(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사람 이름은 1글자에서 5글자 사이이어야 합니다.");
    }

    @DisplayName("사다리 게임 참여자의 이름이 정상적으로 입력된 경우 참여자들을 생성한다.")
    @Test
    void createPlayersTest2() {
        List<String> names = List.of("odo", "odo27", "kong", "ko ng", "  ko    ");
        assertThatCode(() -> new Players(names))
                .doesNotThrowAnyException();
    }

    @DisplayName("사다리 게임 참여자의 이름에 중복이 있는 경우에는 예외를 발생시킨다.")
    @Test
    void createPlayersTest3() {
        List<String> names = List.of("kong", "odo", "gray", "kong");
        assertThatThrownBy(() -> new Players(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 게임 참여자의 이름은 중복이 없어야합니다.");
    }

    @DisplayName("사다리 게임 참여자의 이름에 공백을 제외한 뒤 중복이 있는 경우에는 예외를 발생시킨다.")
    @Test
    void createPlayersTest4() {
        List<String> names = List.of("kong", "odo", "gray", " kong ");
        assertThatThrownBy(() -> new Players(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 게임 참여자의 이름은 중복이 없어야합니다.");
    }

    @DisplayName("사다리 한 줄에 대한 정보가 주어지면 사다리 게임 참여자의 위치를 옮길 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"true:1:0", "false:0:1"}, delimiter = ':')
    void playerMoveTest(boolean generateValue, int expectedOdoPosition, int expectedKongPosition) {
        List<String> names = List.of("odo", "kong");
        Players players = new Players(names);
        Line line = Line.of(2, new TestBooleanGenerator(Lists.newArrayList(generateValue)));
        players.move(line);
        Player odo = players.getPlayers().get(0);
        Player kong = players.getPlayers().get(1);

        assertThat(odo.getPosition()).isEqualTo(expectedOdoPosition);
        assertThat(kong.getPosition()).isEqualTo(expectedKongPosition);
    }
}
