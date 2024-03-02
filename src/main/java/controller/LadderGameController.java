package controller;

import domain.Height;
import domain.Ladder;
import domain.LadderGameResult;
import domain.LadderIndexConnection;
import domain.line.NonContinuousLineGenerator;
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

        Ladder ladder = Ladder.createFrom(new NonContinuousLineGenerator(), names, height, prizes);
        resultView.printLadder(ladder, names, prizes);

        LadderIndexConnection ladderIndexConnection = LadderIndexConnection.of(ladder);
        LadderGameResult ladderGameResult = new LadderGameResult(names, prizes, ladderIndexConnection);
        printResult(ladderGameResult);
    }

    private void printResult(LadderGameResult ladderGameResult) {
        String oneNameOrAll = inputView.readOneNameOrAll();
        while (!oneNameOrAll.equalsIgnoreCase("all")) {
            resultView.printOneResult(ladderGameResult.getOneResult(new Name(oneNameOrAll)));
            oneNameOrAll = inputView.readOneNameOrAll();
        }
        resultView.printAllResult(ladderGameResult.getAllResult());
    }
}
