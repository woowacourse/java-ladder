package laddergame.view;

import laddergame.domain.GameResult;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.player.Players;
import laddergame.domain.result.Results;

public class OutputView {

    private OutputView() {

    }

    private static void showMessageOfExecution() {
        System.out.println("\n실행 결과");
    }

    private static void showPlayers(Players players) {
        System.out.println(players);
    }

    private static void showLadder(Ladder ladder) {
        System.out.println(ladder);
    }

    private static void showResults(Results results) {
        System.out.println(results);
    }

    public static void showAllLadder(Players players, Ladder ladder, Results results) {
        showMessageOfExecution();
        showPlayers(players);
        showLadder(ladder);
        showResults(results);
    }

    public static void showResult(String result) {
        if(result == null) {
            return;
        }
        showMessageOfExecution();
        System.out.println(result);
    }

    public static void showAllResult(GameResult gameResult) {
        System.out.println(gameResult);
    }
}
