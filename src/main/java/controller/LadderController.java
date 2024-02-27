package controller;

import java.util.HashSet;
import java.util.Set;
import model.Height;
import model.Ladder;
import model.LadderResult;
import model.Player;
import model.Players;
import model.Result;
import view.InputView;
import view.OutputView;

public class LadderController {
    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Players players = new Players(inputView.readPlayersName());
        Result result = Result.of(inputView.readResult(), players.size());
        Height height = new Height(inputView.readHeight());
        Ladder ladder = Ladder.of(height, players.size());

        outputView.printLadderResult(players.getNames(), ladder.getFormattedLines(), result.getPrizeNames());
        printResult(ladder.findResult(players, result), players);
    }

    private void printResult(final LadderResult ladderResult, final Players players) {
        var playerNames = new HashSet<>(players.getPlayerNames());
        while (!playerNames.isEmpty()) {
            readNameAndPrintResult(ladderResult, playerNames);
        }
    }

    private void readNameAndPrintResult(final LadderResult ladderResult, final Set<Player> playerNames) {
        var name = inputView.readPlayerNameToCheckPrize();
        if (ladderResult.isCmdAllResult(name)) {
            outputView.printAllPlayerResult(ladderResult.getPlayersPrizeResults());
            playerNames.clear();
            return;
        }
        outputView.printOnePlayerPrize(name, ladderResult.getPrize(name));
        playerNames.remove(new Player(name));
    }
}
