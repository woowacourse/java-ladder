package laddergame.controller;

import laddergame.domain.*;
import laddergame.view.InputView;
import laddergame.view.OutputView;

import java.util.List;

public class LadderGame {
    public void play() {
        PlayerGroup players = InputView.askUserNames();
        Ladder ladder = InputView.askHeight(players.getCountOfPlayers());
        PrizeGroup prizeGroup = InputView.askPrizes(players.getCountOfPlayers());
        /*
        OutputView.printLadder(players, ladder);
        OutputView.printPrizes(prizes);

        GameProcessor processor = new GameProcessor(players);
        processor.processGame(ladder.getLines());

        keepAsk(players, prizes);*/
    }

    private String keepAsk(List<Player> players, List<Prize> prizes) {
        while (true) {
            String result = makeResults(players, prizes);
            OutputView.printResult(result);
        }
    }

    private String makeResults(List<Player> players, List<Prize> prizes) {
        try {
            String input = InputView.askResult();
            GameResult gameResult = new GameResult();
            gameResult.makeResult(players, prizes);
            return gameResult.getResult(players,input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeResults(players, prizes);
        }
    }
}
