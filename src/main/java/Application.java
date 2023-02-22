import domain.Lines;
import domain.Player;
import domain.Players;
import domain.Results;
import ui.input.InputView;
import ui.output.OutputView;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        String playersName = InputView.getPlayersName();
        Players players = new Players(Arrays.asList(playersName.split(",")));

        String ladderResults = InputView.getResult();
        Results results = new Results(players.getPlayers().size(), Arrays.asList(ladderResults.split(",")));

        int ladderHeight = InputView.getLadderHeight();
        Lines lines = new Lines(players.getPlayers().size(), ladderHeight);
        lines.calculateResults(players);

        OutputView.printLadderResult(players, lines, results);

        String playerName = InputView.getPlayer();
        players.validateInputPlayer(playerName);

        OutputView.printExecuteResult();

    }
}
