package controller;

import domain.EndingSelecter;
import domain.Height;
import domain.Ladder;
import domain.LadderGameResult;
import domain.line.RandomLinesGenerator;
import domain.name.Name;
import domain.name.Names;
import domain.prize.Prizes;
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
        Prizes prizes = inputView.readPrizes();
        Height height = inputView.readHeight();

        Ladder ladder = Ladder.createFrom(new RandomLinesGenerator(), names, height, prizes);
        resultView.printLadder(ladder, names, prizes);

        LadderGameResult ladderGameResult = new LadderGameResult(names, prizes, ladder);
        printResult(ladderGameResult);
    }

    private void printResult(LadderGameResult ladderGameResult) {
        String resultName = inputView.readResultName();
        EndingSelecter endingSelecter = new EndingSelecter(resultName);
        while (endingSelecter.isNotEnd()) {
            resultView.printOneResult(ladderGameResult.getOneResult(new Name(resultName)));
            resultName = inputView.readResultName();
            endingSelecter = new EndingSelecter(resultName);
        }
        resultView.printAllResult(ladderGameResult.getAllResult());
    }
}
