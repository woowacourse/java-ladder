package controller;

import domain.*;
import view.InputView;
import view.OutputView;
import java.util.List;

public class LadderGameController {

    private static final String END_COMMAND = "all";

    private final InputView inputView;
    private final OutputView outputView;
    private BooleanGenerator booleanGenerator;

    private boolean flag = true;

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

        LadderGameResult result = ladderGame.playGame();

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

    private void printLadderResultWithRetry(Players players, LadderGameResult result) {
        while (flag) {
            String playerName = inputView.readWantedResultPlayer();
            printLadderResult(players, result, playerName);
            isExit(playerName);
        }
    }

    private void printLadderResult(Players players, LadderGameResult result, String input) {
        List<String> playersName = players.getPlayersName();
        if (input.equals("all")) {
            outputView.printAllResult(result);
        }
        if (playersName.contains(input)) {
            Player wantedResultPlayer = players.findPlayer(input);
            outputView.printIndividualResult(result, wantedResultPlayer);
        }
    }

    private void isExit(String input) {
        if (input.equals(END_COMMAND)) {
            flag = false;
        }
    }

    private void printLadder(Players players, Ladder ladder, Prizes prizes) {
        outputView.printResult();
        outputView.printNames(players);
        outputView.printLadders(ladder, players.getPlayersName());
        outputView.printPrize(prizes, players);
    }
}
