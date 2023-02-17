package laddergame.controller;

import laddergame.domain.LadderGame;
import laddergame.domain.Players;
import laddergame.util.RepeatValidator;
import laddergame.view.InputView;
import laddergame.view.OutputView;

import java.util.List;

public class LadderGameController {

    public void run() {
        Players players = RepeatValidator.readUntilValidate(this::readPlayers);
        int height = RepeatValidator.readUntilValidate(this::readLadderHeight);
        LadderGame ladderGame = new LadderGame(players, height);

        printLadderResult(ladderGame);
    }

    private Players readPlayers() {
        OutputView.printPlayerNamesRequestMsg();
        List<String> playerNames = InputView.inputPlayerNames();
        return new Players(playerNames);
    }

    private int readLadderHeight() {
        OutputView.printLadderHeightRequestMsg();
        int height = InputView.inputLadderHeight();
        return height;
    }

    private void printLadderResult(LadderGame ladderGame) {
        OutputView.printResultInfoMsg();
        OutputView.printPlayerNames(ladderGame.getPlayerNames());
        OutputView.printLadderMap(ladderGame.getLadderMap());
    }
}
