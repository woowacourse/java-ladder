package laddergame.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("플레이어들")
public class PlayersTest {
    @Test
    @DisplayName("플레이어가 제대로 생성되는지 테스트한다.")
    public void createPlayersTest() {
        //given
        final String playerName1 = "choco";
        final String playerName2 = "lemon";

        //when
        final Players players = Players.from(List.of(playerName1, playerName2));

        //then
        assertEquals(players.getPlayers().size(), 2);
        assertEquals(players.getPlayers().get(0).getName(), playerName1);
        assertEquals(players.getPlayers().get(1).getName(), playerName2);
    }

    @Test
    @DisplayName("플레이어 이름에 중복이 있을 경우 예외가 발생한다.")
    public void nameDuplicateException() {
        //given
        final String name = "name";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> Players.from(List.of(name, name)));

    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    @DisplayName("입력이 없을 경우 예외가 발생한다.")
    public void nameIsNullException(final String name) {
        //given & when & then
        assertThrows(IllegalArgumentException.class, () -> Players.from(List.of(name)));
    }
}
