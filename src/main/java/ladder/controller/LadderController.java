package ladder.controller;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.domain.RandomGenerator;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    private final InputView inputView;
    private final ResultView resultView;
    private final RandomGenerator randomGenerator;
    private final ExceptionProcess exceptionProcess;

    public LadderController(InputView inputView, ResultView resultView, RandomGenerator randomGenerator) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.randomGenerator = randomGenerator;
        this.exceptionProcess = new ExceptionProcess(resultView);
    }

    public void run() {
        Players players = exceptionProcess.repeat(
                inputView::inputPlayerNames,
                Players::create);
        Height heightOfLadder = exceptionProcess.repeat(
                inputView::inputHeightOfLadder,
                input -> Height.create(input, randomGenerator));
        Ladder ladder = Ladder.create(players.count(), heightOfLadder.getHeight());

        resultView.printLadder(players, ladder);
    }

}
