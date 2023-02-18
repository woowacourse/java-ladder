package laddergame.controller;

import laddergame.domain.Ladder;
import laddergame.domain.LadderGame;
import laddergame.domain.LadderHeight;
import laddergame.domain.LadderMaker;
import laddergame.domain.Players;
import laddergame.util.RandomBooleanGenerator;
import laddergame.util.RepeatValidator;
import laddergame.view.InputView;
import laddergame.view.OutputView;

import java.util.List;

public class LadderGameController {

    public void run() {
        LadderGame ladderGame = initLadderGame();
        printLadderResult(ladderGame);
    }

    private LadderGame initLadderGame() {
        Players players = RepeatValidator.readUntilValidate(this::readPlayers);
        int height = RepeatValidator.readUntilValidate(this::readLadderHeight);

        LadderMaker ladderMaker = new LadderMaker(new RandomBooleanGenerator());
        Ladder ladder = ladderMaker.make(players.size(), new LadderHeight(height));
        return new LadderGame(players, ladder);
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
