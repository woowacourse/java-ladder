package laddergame.view;

import laddergame.domain.gameresult.GameResult;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.player.Players;
import laddergame.domain.result.Result;
import laddergame.domain.result.Results;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class OutputView {

    private OutputView() {

    }

    private static void showMessageOfExecution() {
        System.out.println("\n실행 결과");
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
