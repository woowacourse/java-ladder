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

        Players players = Players.of(names);

        Assertions.assertThat(players.getNumberOfPlayers()).isEqualTo(names.length);
    }

    @Test
    @DisplayName("2명 이상의 플레이어 이름이 입력되었을 때 Players객체가 정상적으로 생성")
    void makePlayersByMoreThanOnePlayersAsParameter() {
        String[] names = {"roy", "poy", "soy", "koy"};

        assertDoesNotThrow(() -> Players.of(names));
    }

    @Test
    @DisplayName("2명 미만의 플레이어 이름이 입려되었을 때 예외 발생")
    void makePayersByLessThanTwoPlayersAsParameter() {
        String[] name = {"roy"};

        assertThatThrownBy(() -> Players.of(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 두 명 이상 입력해야 합니다.");
    }
}
