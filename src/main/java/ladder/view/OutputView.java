package ladder.view;

import ladder.domain.LadderBoard;
import ladder.domain.LadderMachingPair;

import java.util.List;

public class OutputView {

    public static void printLadderBoard(LadderBoard ladderBoard)
    {
        System.out.println("사다리 결과\n");
        System.out.println(ladderBoard.toString());
    }


    public static void printLadderMachingResults(List<LadderMachingPair> pairs) {
        for (LadderMachingPair pair : pairs) {
            System.out.println(pair);
        }
    }
}
