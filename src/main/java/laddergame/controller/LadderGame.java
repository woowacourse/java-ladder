package laddergame.controller;

import laddergame.domain.*;
import laddergame.view.InputView;
import laddergame.view.OutputView;

import java.util.List;

public class LadderGame {
    public void play() {
        Players players = generatePlayers();
        Ladder ladder = generateLadder(players.getPeopleCount());
        Prizes prizes = generatePrizes(players.getPeopleCount());
        //List<Prize> prizes = getPrizes(players.size());
        OutputView.printPlayersAndLadder(players, ladder);
        OutputView.printPrizes(prizes);

        /*
        GameEngine engine = new GameEngine(players, ladder);
        engine.makePlayersPlayTheLadder();
         */

        ladder.makeThePlayersClimbDownTheLadder(players);
        promptUserForRequest(players, prizes);
    }

    private static Players generatePlayers() {
        try {
            String playersNames = InputView.askPlayersNames();
            playersNames = playersNames.replaceAll(" ","");
            return new Players(playersNames);
        } catch (Exception e) {
            System.out.println("잘못된 이름이 있습니다!");
            return generatePlayers();
        }
    }

    private static Ladder generateLadder(int width) {
        try {
            String height = InputView.askHeight();
            return new Ladder(width, height);
        } catch (Exception e) {
            return generateLadder(width);
        }
    }

    private static Prizes generatePrizes(int width) {
        try {
            String prizes = InputView.askPrizes();
            return new Prizes(width, prizes);
        } catch (Exception e) {
            return generatePrizes(width);
        }
    }

    private String promptUserForRequest(Players players, Prizes prizes) {
        while (true) {
            GameResult result = generateGameResult(players, prizes);
            OutputView.printResult(result);
        }
    }

    private GameResult generateGameResult(Players players, Prizes prizes) {
        try {
            String request = InputView.askRequest();
            return new GameResult(request, players, prizes);
        } catch (Exception e) {
            System.out.println("일치하는 이름이 없습니다!");
            return generateGameResult(players, prizes);
        }
    }



    /*

    private static Ladder getLadder(int width) {
        try {
            int height = InputView.askHeight();
            return new Ladder(width, height);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return getLadder(width);
        }
    }

     */

    /*
    private static List<Player> getPlayers() {
        try {
            String input = InputView.askUserNames();
            return PlayersGenerator.createPlayers(input);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return getPlayers();
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
     */

}
