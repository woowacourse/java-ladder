package ladder.view;

import ladder.model.Ladder;
import ladder.model.LadderGameResult;
import ladder.model.Players;

public class OutputView {

    public static void printLadderResult(Players players, Ladder ladder, LadderGameResult ladderGameResult) {
        System.out.println("사다리 결과");
        System.out.println(players);
        System.out.print(ladder);
        System.out.println(ladderGameResult);
    }

    public static void printExecutionResult(String executionResult) {
        System.out.println("실행 결과");
        System.out.println(executionResult);
    }
}
