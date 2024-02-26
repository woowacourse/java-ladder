package controller;

import domain.model.Ladder;
import domain.model.People;
import handler.ExceptionHandler;
import view.InputView;
import view.ResultView;

import java.util.List;
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
        Supplier<People> peopleSupplier = () -> new People(getParticipants());
        People people = runWithHandler(peopleSupplier);

        Supplier<Ladder> ladderSupplier = () -> new Ladder(getLadderHeight(), people.numberOfParticipants());
        Ladder ladder = runWithHandler(ladderSupplier);

        resultView.printResult(people, ladder);
    }

    private List<String> getParticipants() {
        return inputView.askParticipants();
    }

    private String getLadderHeight() {
        return inputView.askLadderHeight();
    }


    public <T> T runWithHandler(Supplier<T> callback){
        return handler.handle(callback);
    }
}
