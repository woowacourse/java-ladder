package ladder.controller;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.domain.ValueGenerator;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    private final InputView inputView;
    private final ResultView resultView;
    private final ValueGenerator valueGenerator;
    private final ExceptionProcess exceptionProcess;

    public LadderController(InputView inputView, ResultView resultView, ValueGenerator valueGenerator) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.valueGenerator = valueGenerator;
        this.exceptionProcess = new ExceptionProcess(resultView);
    }

    public void run() {
        Players players = exceptionProcess.repeat(
                inputView::inputPlayerNames,
                Players::create);
        Height heightOfLadder = exceptionProcess.repeat(
                inputView::inputHeightOfLadder,
                input -> Height.create(input, valueGenerator));
        Ladder ladder = Ladder.create(players.count(), heightOfLadder.getHeight());

        resultView.printLadder(players, ladder);
    }

}
