package ladder.view;

import ladder.domain.Line;

import java.util.List;

public class OutputView {
    private static final String LADDER_RESULT_MESSAGE = "사다리 결과";
    public static final String EXECUTION_RESULT_MESSAGE = "실행 결과";

    public static void printLadder(List<Line> ladder, String names, String resultCandidate) {
        System.out.println(LADDER_RESULT_MESSAGE);
        System.out.println(names);
        for (Line line : ladder) {
            System.out.println(line.makeLine());
        }
        System.out.println(resultCandidate);
    }

    public static void printLadderResult(String ladderResult) {
        System.out.println("\n" + EXECUTION_RESULT_MESSAGE);
        System.out.println(ladderResult + "\n");
    }
}
