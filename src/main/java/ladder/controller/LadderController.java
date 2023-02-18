package ladder.controller;

import ladder.domain.ladder.Height;
import ladder.domain.ladder.Ladder;
import ladder.domain.player.Players;
import ladder.domain.valueGenerator.ValueGenerator;
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
        Ladder ladder = Ladder.create(players.count(), heightOfLadder.getHeight(), valueGenerator);

        resultView.printLadder(players, ladder);
    }

}
