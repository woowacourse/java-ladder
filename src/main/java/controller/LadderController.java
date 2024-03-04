package controller;

import static message.ErrorMessage.INVALID_LADDER_HEIGHT_LANGUAGE_EXCEPTION;

import domain.Height;
import domain.Ladder;
import domain.LadderGame;
import domain.PlayerNames;
import domain.RandomLegGenerateStrategy;
import domain.Rewards;
import view.InputView;
import view.OutputView;

public class LadderController {
    private static final String SHOW_RESULT_BREAK_WORD = "all";

    public void run() {
        PlayerNames playerNames = readPlayerNames();
        Rewards rewards = readRewards(playerNames.getPlayerNames().size());
        Height ladderHeight = readHeight();

        int ladderWidth = playerNames.getPlayerNames().size() - 1;
        Ladder ladder = new Ladder(new RandomLegGenerateStrategy(), ladderHeight, ladderWidth);
        OutputView.printLadderGame(playerNames, ladder, rewards);

        LadderGame ladderGame = new LadderGame(ladder, playerNames, rewards);
        printResult(ladderGame);
    }

    private PlayerNames readPlayerNames() {
        try {
            return new PlayerNames(InputView.readPlayerNames());
        } catch (Exception e) {
            OutputView.printErrorMessage(e.getMessage());
            System.exit(0);
        }
        return null;
    }

    private Rewards readRewards(int playerCount) {
        try {
            return new Rewards(InputView.readRewards(), playerCount);
        } catch (Exception e) {
            OutputView.printErrorMessage(e.getMessage());
            System.exit(0);
        }
        return null;
    }

    private Height readHeight() {
        try {
            return new Height(InputView.readLadderHeight());
        } catch (NumberFormatException e) {
            OutputView.printErrorMessage(INVALID_LADDER_HEIGHT_LANGUAGE_EXCEPTION.getMessage());
            System.exit(0);
        } catch (Exception e) {
            OutputView.printErrorMessage(e.getMessage());
            System.exit(0);
        }
        return null;
    }

    private void printResult(LadderGame ladderGame) {
        String name;
        while (!(name = InputView.getWantedResultName()).equals(SHOW_RESULT_BREAK_WORD)) {
            OutputView.printPlayerResult(ladderGame.getPlayerResult(name));
        }
        OutputView.printAllPlayerResult(ladderGame.getAllPlayerResult());
    }
}
