package controller;

import domain.*;
import java.util.Map;
import view.InputView;
import view.OutputView;
import java.util.List;

public class Controller {
    private static final String END_COMMAND = "all";

    private InputView inputView;
    private OutputView outputView;
    private BooleanGenerator booleanGenerator;

    public Controller(InputView inputView, OutputView outputView, BooleanGenerator booleanGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.booleanGenerator = booleanGenerator;
    }

    public void run() {
        List<String> playerNames = inputView.readPlayerName();
        Players players = Players.generatePlayer(playerNames);

        List<String> prizeNames = inputView.readPrizeName();
        Prizes prizes = Prizes.generatePrizes(players.getPlayersSize(), prizeNames);

        int ladderHeight = inputView.readLadderHeight();
        Ladder ladder = Ladder.generateLadder(ladderHeight, players, booleanGenerator);

        LadderGame ladderGame = new LadderGame(players, ladder, prizes);

        printLadder(players, ladder, prizes);

        Map<Player, Prize> result = ladderGame.playGame(players, ladder, prizes);
        printLadderResultWithRetry(players, result);
    }

    private void printLadderResultWithRetry(Players players, Map<Player, Prize> result) {
        String playerName = inputView.readWantedResultPlayer();

        while (!playerName.equals(END_COMMAND)) {
            Player wantedResultPlayer = players.findPlayer(playerName);
            outputView.printIndividualResult(result, wantedResultPlayer);
            playerName = inputView.readWantedResultPlayer();
        }

        outputView.printAllResult(result);
    }

    private void printLadder(Players players, Ladder ladder, Prizes prizes) {
        outputView.printResult();
        outputView.printNames(players);
        outputView.printLadders(ladder, players.getPlayersName());
        outputView.printPrize(prizes, players);
    }
}
