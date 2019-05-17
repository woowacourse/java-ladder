package laddergame.view;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.player.Players;
import laddergame.domain.result.Result;
import laddergame.domain.result.Results;

public class OutputView {

    private OutputView() {

    }

    private static void showMessageOfExecution() {
        System.out.println("실행 결과");
    }

    public static void showPlayers(Players players) {
        showMessageOfExecution();
        System.out.println(players);
    }

    public static void showLadder(Ladder ladder) {
        System.out.println(ladder);
    }

    public static void showResults(Results results) {
        System.out.println(results);
    }

    public static void showResult(Result result) {
        showMessageOfExecution();
        System.out.println(result);
    }

    public static void showAllResult(Players players, Results results, Ladder ladder) {
        for (int i = 0; i < players.getTotalPlayers(); i++) {
            System.out.print(players.getNameOfIndex(i));
            System.out.println("\t:\t" + results.getResult(ladder.findResultIndex(i + 1) - 1));
        }
    }
}
