package controller;

import domain.Height;
import domain.Ladder;
import domain.LadderResult;
import domain.Prizes;
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
        Prizes prizes = inputView.readPrizes();
        Height height = inputView.readHeight();

        Ladder ladder = Ladder.createFrom(new NonContinuousLineGenerator(), names.getNameCount(), height, prizes);
        resultView.printLadder(ladder, names, prizes);

        LadderResult ladderResult = LadderResult.of(ladder, names, prizes);
        printResult(ladderResult, names);
    }

    private void printResult(LadderResult ladderResult, Names names) {
        String oneNameOrAll = "";
        while (!oneNameOrAll.equals("all")) {
            oneNameOrAll = inputView.readOneNameOrAll();
            resultView.printResult(oneNameOrAll, ladderResult.getResult(), names);
        }
    }
}
