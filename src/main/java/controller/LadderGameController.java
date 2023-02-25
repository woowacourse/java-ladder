package controller;

import domain.*;
import java.util.Map;
import view.InputView;
import view.OutputView;
import java.util.List;

public class LadderGameController {
    private static final String END_COMMAND = "all";

    private final InputView inputView;
    private final OutputView outputView;
    private BooleanGenerator booleanGenerator;

    public LadderGameController(InputView inputView, OutputView outputView, BooleanGenerator booleanGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.booleanGenerator = booleanGenerator;
    }

    public void run() {
        Players players = generatePlayer();
        Prizes prizes = generatePrize(players.getPlayersSize());
        Ladder ladder = generateLadder(players);
        LadderGame ladderGame = new LadderGame(players, ladder, prizes);

        Map<Player, Prize> result = ladderGame.playGame(players, ladder, prizes);

        printLadder(players, ladder, prizes);
        printLadderResultWithRetry(players, result);
    }

    private Players generatePlayer() {
        List<String> playerNames = inputView.readPlayerName();
        Players players = Players.generatePlayer(playerNames);
        return players;
    }

    private Prizes generatePrize(int playerCount) {
        List<String> prizeNames = inputView.readPrizeName();
        Prizes prizes = Prizes.generatePrizes(playerCount, prizeNames);
        return prizes;
    }

    private Ladder generateLadder(Players players) {
        int ladderHeight = inputView.readLadderHeight();
        Ladder ladder = Ladder.generateLadder(ladderHeight, players, booleanGenerator);
        return ladder;
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
