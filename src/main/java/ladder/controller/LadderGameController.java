package ladder.controller;

import ladder.domain.LadderGame;
import ladder.domain.ladder.LineStrategy;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class LadderGameController {
    private LadderGame ladderGame;
    private static final String ALL_RESULT_MESSAGE = "all";

    public void playGame(LineStrategy lineStrategy) {
        makeLadderGame(lineStrategy);
        findPlayerResult();
    }

    private void makeLadderGame(LineStrategy lineStrategy) {
        List<String> names = InputView.readNames();
        List<String> items = InputView.readItems();
        int height = InputView.readLadderHeight();
        this.ladderGame = new LadderGame(names, items, height, lineStrategy);
        OutputView.printLadder(ladderGame.getPlayerNames(), ladderGame.getLines(), ladderGame.getItems(), ladderGame.getNameMaxLength());
    }

    private void findPlayerResult() {
        String playerName = InputView.readResultPlayerName();
        if(playerName.equals(ALL_RESULT_MESSAGE)) {
            OutputView.printPlayerResultAll(ladderGame.getGameResult());
            return;
        }
        String playerResult = ladderGame.getPlayerResult(playerName);
        OutputView.printPlayerResult(playerResult);
        findPlayerResult();
    }
}
