package controller;

import domain.Height;
import domain.Ladder;
import domain.LadderCreator;
import domain.LadderGame;
import domain.LadderResult;
import domain.Names;
import domain.Prizes;
import domain.RowLineGenerator;
import view.InputView;
import view.ResultView;

public class LadderGameController {

    private final InputView inputView;
    private final InputMapper inputMapper;
    private final ResultView resultView;
    private final RowLineGenerator rowLineGenerator;

    public LadderGameController(InputView inputView, InputMapper inputMapper, ResultView resultView,
                                RowLineGenerator rowLineGenerator) {
        this.inputView = inputView;
        this.inputMapper = inputMapper;
        this.resultView = resultView;
        this.rowLineGenerator = rowLineGenerator;
    }

    public void run() {
        Names names = inputMapper.mapToNames(inputView.readNames());
        Height height = inputMapper.mapToHeight(inputView.readHeight());
        Ladder ladder = new LadderCreator().createLadder(rowLineGenerator, names.getNameCount(), height);
        Prizes prizes = inputMapper.mapToPrizes(inputView.readResults());

        resultView.printLadder(ladder, names, prizes);

        LadderGame ladderGame = new LadderGame(ladder, names, prizes);

        String driverName;
        while (!(driverName = inputView.readDriver()).equals("all")) {
            LadderResult result = ladderGame.drive(driverName);
            resultView.printResult(result);
        }

        resultView.printResults(ladderGame.driveAll());

    }
}
