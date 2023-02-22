import domain.Lines;
import domain.Player;
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

        showPlayerLadderResult(players, lines, results);
    }

    private static Players getPlayers() {
        String playersName = InputView.getPlayersName();
        return new Players(Arrays.asList(playersName.split(",")));
    }

    private static Results getResults(Players players) {
        String ladderResults = InputView.getResult();
        return new Results(players.getPlayers().size(), Arrays.asList(ladderResults.split(",")));
    }

    private static Lines getLines(Players players) {
        int ladderHeight = InputView.getLadderHeight();
        Lines lines = new Lines(players.getPlayers().size(), ladderHeight);
        lines.calculateResults(players);
        return lines;
    }

    private static void showPlayerLadderResult(Players players, Lines lines, Results results) {
        OutputView.printLadderResult(players, lines, results);
        String playerName = InputView.getPlayer();
        players.validateInputPlayer(playerName);
        OutputView.printExecuteResult(players, results, playerName);
    }
}
