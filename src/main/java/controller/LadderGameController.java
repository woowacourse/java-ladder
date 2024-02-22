package controller;

import domain.Height;
import domain.Ladder;
import domain.Names;
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
        Ladder ladder = Ladder.createFrom(rowLineGenerator, names.getNameCount(), height);
        resultView.printLadder(ladder, names);
    }
}
