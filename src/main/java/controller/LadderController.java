package controller;

import domain.model.Ladder;
import domain.model.People;
import handler.ExceptionHandler;
import view.InputView;
import view.ResultView;

import java.util.function.Supplier;

public class LadderController {

    private final ResultView resultView;
    private final InputView inputView;
    private final ExceptionHandler handler;
    public LadderController(ResultView resultView, InputView inputView) {
        this.resultView = resultView;
        this.inputView = inputView;
        this.handler = new ExceptionHandler();
    }

    public void make() {
        People people = runWithHandler(() -> new People(inputView.askParticipants()));
        Ladder ladder = runWithHandler(() -> new Ladder(inputView.askLadderHeight(), people.numberOfParticipants()));

        resultView.printResult(people, ladder);
    }


    public <T> T runWithHandler(Supplier<T> callback){
        return handler.handle(callback);
    }
}
