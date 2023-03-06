package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PlayersTest {

    @Test
    @DisplayName("Player 이름이 문자열 배열로 입력되었을 때 사람 수만큼 Player 객체 생성")
    void makePlayersWhichSizeIsSameWithNameArrayLength() {
        String[] names = {"roy", "poy", "soy", "koy"};

        Players players = Players.from(names);

        Assertions.assertThat(players.getNumberOfPlayers()).isEqualTo(names.length);
    }

    @Test
    @DisplayName("2명 이상의 플레이어 이름이 입력되었을 때 Players객체가 정상적으로 생성")
    void makePlayersByMoreThanOnePlayersAsParameter() {
        String[] names = {"roy", "poy", "soy", "koy"};

        assertDoesNotThrow(() -> Players.from(names));
    }

    @Test
    @DisplayName("2명 미만의 플레이어 이름이 입력되었을 때 예외 발생")
    void throwExceptionUsingLessThanTwoPlayersAsAnInput() {
        String[] name = {"roy"};

        assertThatThrownBy(() -> Players.from(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 두 명 이상 입력해야 합니다.");
    }

    @Test
    @DisplayName("중복된 플레이어 이름을 입력했을 때 예외 발생")
    void throwExceptionWhenDuplicatedNamesAreInput() {
        String[] names = {"roy", "roy"};

        assertThatThrownBy(() -> Players.from(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복된 이름을 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("결과를 보고 싶은 사람 입력값이 Player 이름과 일치하지 않을 때 예외 발생")
    void throwExceptionWhenSelectedNameDoesNotMatchWithPlayerName() {
        Players players = Players.from(new String[]{"roy", "hoy", "joy", "poy"});

        String selectedName = "pobi";

        assertThatThrownBy(() -> players.findPlayer(selectedName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 존재하지 않는 사람입니다.");
    }
}
