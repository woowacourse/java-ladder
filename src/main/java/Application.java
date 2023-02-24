import domain.*;
import ui.output.OutputView;

import java.util.Arrays;

import static ui.input.InputView.*;

public class Application {
    public static void main(String[] args) {
        Players players = getPlayers();
        Results results = getResults(players);
        Lines lines = getLinesResult(players);

        OutputView.printLadderResult(players, lines, results);
        lines.calculateResults(players);
        showPlayerLadderResult(players, results);
    }

    private static Players getPlayers() {
        String playersName = getPlayersName();
        return new Players(Arrays.asList(playersName.split(COMMA)));
    }

    private static Results getResults(Players players) {
        String ladderResults = getResult();
        return new Results(players.getPlayersCount(), Arrays.asList(ladderResults.split(COMMA)));
    }

    private static Lines getLinesResult(Players players) {
        return new Lines(players.getPlayersCount(), getLadderHeight());
    }

    private static void showPlayerLadderResult(Players players, Results results) {
        while (true) {
            String playerName = getPlayer();
            if (playerName.equals("q")) break;
            if (!players.isIncludePlayerName(playerName)) {
                throw new IllegalArgumentException("존재하지 않는 플레이어를 입력할 수 없습니다.");
            }
            OutputView.printExecuteResult(players, results, playerName);
        }
    }
}
