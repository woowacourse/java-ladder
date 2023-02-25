package laddergame.controller;

import laddergame.dto.GameResult;
import laddergame.domain.Ladder;
import laddergame.domain.LadderGame;
import laddergame.domain.LadderMaker;
import laddergame.domain.Players;
import laddergame.domain.Prizes;
import laddergame.util.RandomBooleanGenerator;
import laddergame.util.RepeatValidator;
import laddergame.vo.LadderHeight;
import laddergame.view.InputView;
import laddergame.view.OutputView;

import java.util.List;

public class LadderGameController {

    private static final String ALL_PLAYER_SIGN = "all";

    public void run() {
        LadderGame ladderGame = initLadderGame();
        printGeneratedLadderResult(ladderGame);

        printResult(ladderGame);
    }


    private LadderGame initLadderGame() {
        Players players = RepeatValidator.readUntilValidate(this::readPlayers);
        return RepeatValidator.readUntilValidate(() -> {
            Prizes prizes = RepeatValidator.readUntilValidate(this::readPrizes);
            int height = RepeatValidator.readUntilValidate(this::readLadderHeight);
            LadderMaker ladderMaker = new LadderMaker(new RandomBooleanGenerator());
            Ladder ladder = ladderMaker.make(players.size(), new LadderHeight(height));
            return new LadderGame(players, ladder, prizes);
        });
    }

    private Players readPlayers() {
        OutputView.printPlayerNamesRequestMsg();
        List<String> playerNames = InputView.inputPlayerNames();
        return new Players(playerNames);
    }

    private Prizes readPrizes() {
        OutputView.printLadderPrizeRequestMsg();
        List<String> prizeValues = InputView.inputLadderPrize();
        return new Prizes(prizeValues);
    }

    private int readLadderHeight() {
        OutputView.printLadderHeightRequestMsg();
        int height = InputView.inputLadderHeight();
        return height;
    }


    private void printGeneratedLadderResult(LadderGame ladderGame) {
        OutputView.printGeneratedLadderInfoMsg();
        OutputView.printLadderLabel(ladderGame.getPlayerNames());
        OutputView.printLadderMap(ladderGame.getLadderMap());
        OutputView.printLadderLabel(ladderGame.getPrizeValues());
    }


    private void printResult(LadderGame ladderGame) {
        List<GameResult> results;
        do {
            results = getResults(ladderGame);
            OutputView.printResults(results);
        } while (!ladderGame.isAllResults(results));
    }

    private List<GameResult> getResults(LadderGame ladderGame) {
        return RepeatValidator.readUntilValidate(() -> {
            String name = readResultShowPlayerName();
            return getResultsByInput(ladderGame, name);
        });
    }

    private List<GameResult> getResultsByInput(LadderGame ladderGame, String name) {
        if (name.equals(ALL_PLAYER_SIGN)) {
            return ladderGame.getAllResults();
        }
        return List.of(ladderGame.getResult(name));
    }

    private String readResultShowPlayerName() {
        OutputView.printResultShowPlayerRequestMsg();
        String name = InputView.inputResultShowPlayerName();
        return name;
    }
}
