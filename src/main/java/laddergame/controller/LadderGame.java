package laddergame.controller;

import laddergame.domain.*;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderGame {
    public void play() {
        PlayerGroup players = InputView.askUserNames();
        int width = players.getCountOfPlayers();
        Ladder ladder = new Ladder(width, InputView.askHeight());
        PrizeGroup prizeGroup = InputView.askPrizes(width);

        PlayerResult playerResult = players.makePlayerResult();
        playerResult.playLadder(ladder);
        GameResult gameResult = new GameResult(playerResult, prizeGroup);

        OutputView.printGameBoard(players, ladder, prizeGroup);
        keepAsking(gameResult);
    }

    private String keepAsking(GameResult gameResult) {
        while (true) {
            Player player = InputView.askResult();
            OutputView.printResult(gameResult, player);
        }
    }
}
