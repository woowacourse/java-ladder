package util.formatter;

import static org.assertj.core.api.Assertions.assertThat;

import domain.LadderGame;
import domain.player.PlayerNames;
import domain.player.Players;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.TestDataManager;
import view.util.formatter.PlayersConsoleViewFormatter;

class PlayersConsoleViewFormatterTest {

    @Test
    @DisplayName("사다리 게임 참가자 출력 형식 생성 테스트")
    void playersFormatTest() {
        PlayerNames playerNames = PlayerNames.from(List.of("pobi", "crong", "jx"));
        Players players = Players.from(playerNames);
        String expected = new StringBuilder()
                .append("pobi ").append(" ")
                .append("crong").append(" ")
                .append(" jx  ").append(" ")
                .toString();

        String formatPlayers = PlayersConsoleViewFormatter.formatPlayers(players);
        assertThat(formatPlayers).isEqualTo(expected);
    }

    @Test
    @DisplayName("사다리 게임 모든 결과 출력 형식 생성 테스트")
    void playersResultFormatTest() {
        LadderGame ladderGame = TestDataManager.getLadderGame();
        ladderGame.buildBridges();
        ladderGame.runGame();
        Players players = ladderGame.getPlayers();
        String expected = "pobi : 5000" + System.lineSeparator()
                + "crong : 꽝" + System.lineSeparator()
                + "royce : 10000" + System.lineSeparator();

        String formatPlayers = PlayersConsoleViewFormatter.formatResultPlayers(players);
        assertThat(formatPlayers).isEqualTo(expected);
    }

}
