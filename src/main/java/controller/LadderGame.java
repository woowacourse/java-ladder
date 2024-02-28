package controller;

import domain.Ladder;
import domain.Lines;
import domain.Mover;
import domain.Names;
import domain.Results;
import java.util.List;
import view.InputView;
import view.ResultView;

public class LadderGame {
    public void climbLadder(final Ladder ladder) {
        Lines lines = ladder.lines();
        Names names = ladder.names();

        Mover mover = new Mover(lines, names);
        List<String> namesAfterMove = mover.getMoveResult();

        printResult(ladder, namesAfterMove);
    }

    private void printResult(final Ladder ladder, final List<String> namesAfterMove) {
        String target = InputView.findResult();
        Results results = ladder.results();

        if (target.equals("all")) {
            Names names = ladder.names();
            ResultView.printMoveResult(names.getAll(), results.matchNamesWithResults(namesAfterMove));
            return;
        }
        String result = results.resultOf(namesAfterMove.indexOf(target));

        ResultView.printMoveResult(result);
    }
}
