package controller;

import java.util.function.Supplier;

import domain.Ladder;
import domain.LadderService;
import domain.People;
import domain.Person;
import domain.RandomGenerateStrategy;
import domain.Results;
import view.InputView;
import view.OutputView;

public class LadderController {

    private final InputView inputView;
    private final OutputView outputView;
    private LadderService ladderService;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        initLadderService();
    }

    private void initLadderService() {
        People people = repeat(this::nameRequest);
        Ladder ladder = repeat(() -> ladderRequest(people));
        Results results = repeat(() -> resultsRequest(people));

        ladderService = new LadderService(ladder, people, results);
        outputView.printTotalLadderResult(people, ladder, results);
    }

    public void run() {

        while (true) {
            Person person = repeat(this::singleResultRequest);
            if (person.equals(new Person("all"))) {
                outputView.printAllResults(ladderService.getPeople(), ladderService.getAllResults());
                return;
            }
            outputView.printSingleResult(ladderService.getSingleResult(person));
        }

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

    private Ladder ladderRequest(People people) {
        return new Ladder(people, inputView.readLadderHeightAndTransform(), new RandomGenerateStrategy());
    }

    private Results resultsRequest(People people) {
        return new Results(inputView.readResults(), people);
    }

    private Person singleResultRequest() {
        return new Person(inputView.readSingleResult());
    }
}
