package ladder.controller;

import ladder.domain.LadderGame;
import ladder.view.ResultView;

public class ResultController {
    private final ResultView resultView;

    public ResultController(ResultView resultView) {
        this.resultView = resultView;
    }

    public void printLadder(LadderGame ladderGame) {
        resultView.printLadderResultHeader();
        resultView.printNames(ladderGame.getPlayerNames());
        resultView.printLadder(ladderGame.getLadder());
        resultView.printNames(ladderGame.getPrizeNames());
    }

    public void printErrorMessage(String errorMessage) {
        resultView.printErrorMessage(errorMessage);
    }

    public void printEndMessage() {
        resultView.printEndMessage();
    }

    public void printPrizeNameByPlayerName(LadderGame ladderGame, String playerName) {
        String prizeName = ladderGame.getPrizeNameByPlayerName(playerName);
        resultView.printPrizeName(prizeName);
    }

    public void printGameResult(LadderGame ladderGame) {
        resultView.printGameResult(ladderGame.getGameResult());
    }
}
