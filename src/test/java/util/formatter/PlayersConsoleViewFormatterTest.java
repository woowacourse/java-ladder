package util.formatter;

import static org.assertj.core.api.Assertions.assertThat;

import domain.LadderGame;
import domain.player.PlayerNames;
import domain.player.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.TestDataManager;

class PlayersConsoleViewFormatterTest {

    @DisplayName("사다리 게임 참가자 출력 형식 생성 테스트")
    @Test
    void playersFormatTest() {
        PlayerNames playerNames = PlayerNames.of("pobi,crong,jx", ",");
        Players players = Players.from(playerNames);
        String expected = new StringBuilder()
                .append("pobi ").append(" ")
                .append("crong").append(" ")
                .append(" jx  ").append(" ")
                .toString();

        String formatPlayers = PlayersConsoleViewFormatter.formatPlayers(players);
        assertThat(formatPlayers).isEqualTo(expected);
    }

    @DisplayName("사다리 게임 모든 결과 출력 형식 생성 테스트")
    @Test
    void playersResultFormatTest() {
        LadderGame ladderGame = TestDataManager.getLadderGame();
        ladderGame.buildBridges();
        ladderGame.runGame();
        Players players = ladderGame.getPlayers();
        String expected = new StringBuilder()
                .append("pobi : 5000").append(System.lineSeparator())
                .append("crong : 꽝").append(System.lineSeparator())
                .append("royce : 10000").append(System.lineSeparator())
                .toString();

        String formatPlayers = PlayersConsoleViewFormatter.formatResultPlayers(players);
        assertThat(formatPlayers).isEqualTo(expected);
    }

}
