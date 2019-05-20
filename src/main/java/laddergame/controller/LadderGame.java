package laddergame.controller;

import laddergame.domain.*;
import laddergame.view.InputView;
import laddergame.view.OutputView;

import java.util.List;

public class LadderGame {
    public void play() {
        PlayerGroup players = InputView.askUserNames();
        /*Ladder ladder = getLadder(players.size());
        List<Prize> prizes = getPrizes(players.size());
        OutputView.printLadder(players, ladder);
        OutputView.printPrizes(prizes);

        GameProcessor processor = new GameProcessor(players);
        processor.processGame(ladder.getLadder());

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

    private List<Prize> getPrizes(int numOfPlayers) {
        try {
            String input = InputView.askPrizes();
            return PrizesGenerator.createPrizes(input, numOfPlayers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPrizes(numOfPlayers);
        }
    }

    /*private static List<Player> getPlayers() {
        try {
            String input = InputView.askUserNames();
            return PlayersGenerator.createPlayers(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPlayers();
        }
    }*/

    private static Ladder getLadder(int width) {
        try {
            int height = InputView.askHeight();
            return new Ladder(width, height);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getLadder(width);
        }
    }
}
