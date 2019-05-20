package ladder.view;

import ladder.model.ladder.Ladder;
import ladder.model.laddergame.LadderGame;
import ladder.model.laddergame.LadderGameResult;
import ladder.model.player.Players;

public class OutputView {

    public static void printLadderResult(LadderGame ladderGame) {
        System.out.println("사다리 결과");
        System.out.println(ladderGame);
    }

    public static void printExecutionResult(String executionResult) {
        System.out.println("실행 결과");
        System.out.println(executionResult);
    }
}
