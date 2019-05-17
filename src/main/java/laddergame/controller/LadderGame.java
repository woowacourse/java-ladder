package laddergame.controller;

import laddergame.domain.*;
import laddergame.view.InputView;
import laddergame.view.OutputView;

import java.util.List;

public class LadderGame {
    public void play() {
        //인풋받기
        List<Player> players = getPlayers();
        Ladder ladder = getLadder(players.size());
        List<Prize> prizes = getPrizes(players.size());
        OutputView.printLadder(players, ladder);
        OutputView.printPrizes(prizes);

        //게임실행
        GameProcessor processor = new GameProcessor(players);
        processor.processGame(ladder.getLadderMap());

        //결과보여주기
        //결과를 보고 싶은 사람은? 이름또는 all

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
