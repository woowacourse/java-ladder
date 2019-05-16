package ladder.view;

import ladder.model.Ladder;
import ladder.model.LadderGameResult;
import ladder.model.Players;

public class OutputView {

    public static void printResultOfLadder(Players players, Ladder ladder, LadderGameResult ladderGameResult) {
        System.out.println("사다리 결과");
        System.out.println(players.toString());
        System.out.print(ladder.toString());
        System.out.println(ladderGameResult.toString());
    }

    public static void printResultOfExecution(String executionResult){
        System.out.println("실행 결과");
        System.out.println(executionResult);
    }
}
