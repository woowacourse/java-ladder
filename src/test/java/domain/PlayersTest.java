package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlayersTest {

    private static List<String> splitComma(String input) {
        return Arrays.asList(input.split(","));
    }

    @DisplayName("사람 수는 2명 이상이어야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "ab"})
    void createPlayersFailedTest(String inputPeople) {
        List<String> names = splitComma(inputPeople);
        assertThrows(IllegalArgumentException.class, () -> new Players(names));
    }

    @DisplayName("이름들을 담은 배열을 받아 Player 객체로 변환해야 한다.")
    @Test
    void convertPlayerObject() {
        List<String> names = List.of("be", "bebe", "bebbe");
        assertAll(() -> {
            assertEquals(new Players(names).getPlayers().get(0).getName(), "be");
            assertEquals(new Players(names).getPlayers().get(1).getName(), "bebe");
            assertEquals(new Players(names).getPlayers().get(2).getName(), "bebbe");
        });
    }

    @DisplayName("존재하는 player만 입력받을 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"베카", "베일"})
    void validateInputPlayerName(String playerName) {
        // given
        Players players = new Players(List.of("베베", "카일"));

        // when, then
        assertEquals(players.contains(playerName), false);
    }

}
