package laddergame.controller;

import laddergame.domain.*;
import laddergame.view.InputView;
import laddergame.view.OutputView;

import java.util.Collections;
import java.util.List;

public class LadderGame {
    public void play() {
        PlayerGroup players = InputView.askUserNames();
        Ladder ladder = InputView.askHeight(players.getCountOfPlayers());
        PrizeGroup prizeGroup = InputView.askPrizes(players.getCountOfPlayers());

        OutputView.printGameBoard(players, ladder, prizeGroup);

        PlayerGroup resultPlayers = players.clone();
        ladder.playLadder(resultPlayers);
        GameResult gameResult = new GameResult(resultPlayers, prizeGroup);

        keepAsk(gameResult);
    }

    private String keepAsk(GameResult gameResult) {
        while (true) {
            Player player = InputView.askResult();
            OutputView.printResult(gameResult, player);
        }
    }
}
