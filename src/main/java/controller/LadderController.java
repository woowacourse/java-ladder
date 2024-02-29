package controller;

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
        PlayerNames playerNames = new PlayerNames(InputView.readPlayerNames());
        Rewards rewards = new Rewards(InputView.readRewards(), playerNames.getPlayerNames().size());
        Height ladderHeight = new Height(InputView.readLadderHeight());

        int ladderWidth = playerNames.getPlayerNames().size() - 1;
        Ladder ladder = new Ladder(new RandomLegGenerateStrategy(), ladderHeight, ladderWidth);
        OutputView.printLadder(playerNames, ladder, rewards);

        LadderGame ladderGame = new LadderGame(ladder, playerNames, rewards);
        showResult(ladderGame);
    }

    private void showResult(LadderGame ladderGame) {
        String name;
        while (!(name = InputView.getWantedResultName()).equals(SHOW_RESULT_BREAK_WORD)) {
            OutputView.printPlayerResult(ladderGame.getPlayerResult(name));
        }
        OutputView.printAllPlayerResult(ladderGame.getAllPlayerResult());
    }
}
