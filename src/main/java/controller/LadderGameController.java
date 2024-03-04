package controller;

import model.gameresult.GameResult;
import model.ladder.Ladder;
import model.ladder.LadderHeight;
import model.ladder.LadderResult;
import model.ladder.LadderWidth;
import model.ladder.RandomLadderGenerator;
import model.player.Players;
import model.prize.Prizes;
import view.InputView;
import view.OutputView;

public class LadderGameController {

    public void run() {
        Players players = InputView.preparePlayers();
        Prizes prizes = InputView.preparePrizes(players);
        LadderHeight ladderHeight = InputView.prepareLadderHeight();

        GameResult gameResult = executeGame(players, ladderHeight, prizes);
        searchGameResult(gameResult);
    }

    private GameResult executeGame(Players players, LadderHeight ladderHeight, Prizes prizes) {
        LadderWidth ladderWidth = LadderWidth.from(players.size());
        Ladder ladder = RandomLadderGenerator.generateLadder(ladderHeight, ladderWidth);

        OutputView.printLadderResult(players, ladder, prizes);

        LadderResult ladderResult = LadderResult.from(ladder);
        return GameResult.of(ladderResult, players, prizes);
    }

    private void searchGameResult(GameResult gameResult) {
        boolean continueSearching = true;
        while (continueSearching) {
            continueSearching = InputView.preparePlayerNameAndPrintGameResult(gameResult);
        }
    }
}
