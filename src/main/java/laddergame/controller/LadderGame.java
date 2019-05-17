package laddergame.controller;

import laddergame.domain.*;
import laddergame.view.InputView;
import laddergame.view.OutputView;

import java.util.List;

public class LadderGame {
    public void play() {
        List<Player> players = getPlayers();
        Ladder ladder = getLadder(players.size());
        List<Prize> prizes = getPrizes(players.size());
        OutputView.printLadder(players, ladder);
        OutputView.printPrizes(prizes);

        GameProcessor processor = new GameProcessor(players);
        processor.processGame(ladder.getLadderMap());

        keepAsk(players, prizes);
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
        } catch (Exception e) {
            e.printStackTrace();
            return makeResults(players, prizes);
        }
    }

    private List<Prize> getPrizes(int numOfPlayers) {
        try {
            String input = InputView.askPrizes();
            return PrizesGenerator.createPrizes(input, numOfPlayers);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return getPrizes(numOfPlayers);
        }
    }

    private static List<Player> getPlayers() {
        try {
            String input = InputView.askUserNames();
            return PlayersGenerator.createPlayers(input);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return getPlayers();
        }
    }

    private static Ladder getLadder(int width) {
        try {
            int height = InputView.askHeight();
            return new Ladder(width, height);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return getLadder(width);
        }
    }
}
