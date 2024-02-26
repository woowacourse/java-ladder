package controller;

import domain.Height;
import domain.Ladder;
import domain.LadderResult;
import domain.NonDecidedResults;
import domain.line.NonContinuousLineGenerator;
import domain.name.Names;
import view.InputView;
import view.ResultView;

public class LadderGameController {

    private final InputView inputView;
    private final ResultView resultView;

    public LadderGameController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        Names names = inputView.readNames();
        NonDecidedResults nonDecidedResults = inputView.readNonDecidedResults(names);
        Height height = inputView.readHeight();

        Ladder ladder = Ladder.createFrom(new NonContinuousLineGenerator(), names.getNameCount(), height);
        LadderResult ladderResult = LadderResult.of(ladder, names, nonDecidedResults);

        resultView.printLadder(ladder, names);
    }
}
