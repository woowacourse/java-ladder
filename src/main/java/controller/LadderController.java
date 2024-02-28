package controller;

import handler.ExceptionHandler;
import model.Ladder;
import model.People;
import utils.ThresholdCheckerImpl;
import view.InputView;
import view.ResultView;

public class LadderController {

    private final ResultView resultView;
    private final InputView inputView;
    private final ExceptionHandler handler;

    public LadderController() {
        this.resultView = new ResultView();
        this.inputView = new InputView();
        this.handler = new ExceptionHandler();
    }

    public void runLadderGame() {
        People people = handler.handleInputException(() -> new People(inputView.askParticipants()));
        Ladder ladder = handler.handleInputException(
                () -> new Ladder(new ThresholdCheckerImpl(), inputView.askLadderHeight(),
                        people.getParticipantsSize()));

        resultView.printResult(people, ladder);
    }

}
