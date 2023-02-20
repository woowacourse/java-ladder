package ladder.controller;

import ladder.domain.Height;
import ladder.domain.Names;
import ladder.service.LadderGame;
import ladder.util.BooleanGenerator;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderController {
    private final InputView inputView;
    private final ResultView resultView;
    private final BooleanGenerator generator;

    public LadderController(BooleanGenerator generator) {
        this.inputView = new InputView();
        this.resultView = new ResultView();
        this.generator = generator;
    }

    public void execute() {
        LadderGame ladderGame = new LadderGame(createNames(), createHeight(), generator);

        ladderGame.run();

        resultView.printResult(ladderGame.getParticipants(), ladderGame.getLadder());
    }

    private Names createNames() {
        try {
            return new Names(readNames());
        } catch (IllegalArgumentException e) {
            resultView.printErrorMessage(e.getMessage());
            return createNames();
        }
    }

    private Height createHeight() {
        try {
            return new Height(readLadderHeight());
        } catch (IllegalArgumentException e) {
            resultView.printErrorMessage(e.getMessage());
            return createHeight();
        }
    }

    private List<String> readNames() {
        return inputView.requestNames();
    }

    private int readLadderHeight() {
        return inputView.requestLadderHeight();
    }

}
