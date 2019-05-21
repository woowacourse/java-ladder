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

        OutputView.printPlayersAndLadder(players, ladder);
        OutputView.printPrizes(prizes);

        Players resultPlayers = ladder.makeThePlayersClimbDownTheLadder(players);
        promptUserForRequest(resultPlayers, prizes);
    }

    private static Players generatePlayers() {
        try {
            String playersNames = InputView.askPlayersNames();
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
            System.out.println("잘못된 높이입니다!");
            return generateLadder(width);
        }
    }

    private static Prizes generatePrizes(int width) {
        try {
            String prizes = InputView.askPrizes();
            return new Prizes(width, prizes);
        } catch (Exception e) {
            System.out.println("상품의 수가 맞지 않습니다!");
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
}
