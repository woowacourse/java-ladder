package controller;

import domain.*;
import view.InputView;
import view.ResultView;

public class LadderGameController {

    private final InputView inputView;
    private final InputMapper inputMapper;
    private final ResultView resultView;

    public LadderGameController(InputView inputView, InputMapper inputMapper, ResultView resultView) {
        this.inputView = inputView;
        this.inputMapper = inputMapper;
        this.resultView = resultView;
    }

    public void run() {
        Names names = inputMapper.mapToNames(inputView.readNames());
        Height height = inputMapper.mapToHeight(inputView.readHeight());

        Ladder ladder = Ladder.createFrom(new NonContinuousLineGenerator(), names.getNameCount(), height);

        resultView.printLadder(ladder, names);
    }
}
