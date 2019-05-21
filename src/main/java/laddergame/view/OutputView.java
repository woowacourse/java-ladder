package laddergame.view;

import laddergame.domain.NameList;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.result.GameResultFormat;

import java.util.List;

public class OutputView {

    private OutputView() {

    }

    private static void showMessageOfExecution() {
        System.out.println("실행 결과");
    }

    public static void showPlayers(NameList players) {
        showMessageOfExecution();
        System.out.println(players);
    }

    public static void showLadder(Ladder ladder) {
        System.out.println(ladder);
    }

    public static void showRewards(NameList rewards) {
        System.out.println(rewards);
    }

    public static void showAllResult(List<GameResultFormat> gameResult) {
        for (GameResultFormat gameResultFormat : gameResult) {
            showResult(gameResultFormat);
        }
    }

    public static void showResult(GameResultFormat gameResultFormat) {
        System.out.println(gameResultFormat);
    }
}
