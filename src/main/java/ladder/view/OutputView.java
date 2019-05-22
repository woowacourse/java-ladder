package ladder.view;

import ladder.model.Ladder;
import ladder.model.LadderGameResults;
import ladder.model.Players;

public class OutputView {

    public static void printResultOfLadder(Players players, Ladder ladder, LadderGameResults ladderGameResults) {
        System.out.println("사다리 결과");
        System.out.println(players);
        System.out.print(ladder);
        System.out.println(ladderGameResults);
    }

    public static void printResultOfExecution(String executionResult) {
        System.out.println("실행 결과");
        System.out.println(executionResult);
    }
}
