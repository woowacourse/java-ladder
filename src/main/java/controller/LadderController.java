package controller;

import domain.Ladder;
import domain.People;
import domain.Person;
import domain.RandomGenerateStrategy;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import view.InputView;
import view.OutputView;

public class LadderController {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        People people = repeat(this::nameRequest);
        Ladder ladder = repeat(() -> ladderRequest(people.getCount()));

        outputView.printNames(people.getNames());
        outputView.printLadder(ladder);
    }

    private <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException exception) {
            outputView.printError(exception);
            return repeat(inputReader);
        } catch (Exception exception) {
            outputView.printCriticalError(exception);
            return repeat(inputReader);
        }
    }

    private People nameRequest() {
        return new People(inputView.readNames());
    }

    private Ladder ladderRequest(int peopleCount) {
        return new Ladder(peopleCount,
            inputView.readLadderHeightAndTransform(),
            new RandomGenerateStrategy());
    }
}
