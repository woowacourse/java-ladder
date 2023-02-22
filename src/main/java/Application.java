import domain.Lines;
import domain.Players;
import domain.Results;
import ui.input.InputView;
import ui.output.OutputView;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        Players players = getPlayers();
        Results results = getResults(players);
        Lines lines = getLines(players);

        OutputView.printLadderResult(players, lines, results);
        showPlayerLadderResult(players, results);
    }

    private static Players getPlayers() {
        String playersName = InputView.getPlayersName();
        return new Players(Arrays.asList(playersName.split(",")));
    }

    private static Results getResults(Players players) {
        String ladderResults = InputView.getResult();
        return new Results(players.getPlayersCount(), Arrays.asList(ladderResults.split(",")));
    }

    private static Lines getLines(Players players) {
        Lines lines = new Lines(players.getPlayersCount(), InputView.getLadderHeight());
        lines.calculateResults(players);
        return lines;
    }

    private static void showPlayerLadderResult(Players players, Results results) {
        while (true) {
            String playerName = InputView.getPlayer();
            if (playerName.equals("q")) break;
            players.validateInputPlayer(playerName);
            OutputView.printExecuteResult(players, results, playerName);
        }
    }
}
