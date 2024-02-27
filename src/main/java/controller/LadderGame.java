package controller;

import domain.Lines;
import domain.Mover;
import domain.Names;
import domain.Results;
import java.util.List;
import view.InputView;
import view.ResultView;

public class LadderGame {
    public void climbLadder(final LadderComponents ladderComponents) {
        Lines lines = ladderComponents.getLines();
        Names names = ladderComponents.getNames();

        Mover mover = new Mover(lines, names);
        List<String> namesAfterMove = mover.getMoveResult();

        printResult(ladderComponents, names, namesAfterMove);
    }

    private static void printResult(LadderComponents ladderComponents, Names names, List<String> namesAfterMove) {
        String target = InputView.findResult();
        Results results = ladderComponents.getResults();
        if (target.equals("all")) {
            ResultView.printMoveResult(names.getAll(), results.matchNamesWithResults(namesAfterMove));
            return;
        }
        String result = results.resultOf(namesAfterMove.indexOf(target));

        ResultView.printMoveResult(result);
    }
}
