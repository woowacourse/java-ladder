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
        Supplier<People> peopleSupplier = () -> {
            List<String> participants = inputView.askParticipants();
            return new People(participants);
        };
        People people = registerWithRetry(peopleSupplier);

        Supplier<Ladder> ladderSupplier = () -> {
            String ladder=inputView.askLadderHeight();
            return new Ladder(ladder, people.getNumberOfParticipants());
        };
        Ladder ladder = registerWithRetry(ladderSupplier);

        resultView.printResult(people, ladder);
    }

    public <T> T registerWithRetry(Supplier<T> callback) {
        return handler.handle(callback);
    }
}
