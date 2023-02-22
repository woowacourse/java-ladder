package controller;

import java.util.function.Supplier;

import domain.Ladder;
import domain.LadderService;
import domain.People;
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
        People people = repeat(() -> new People(inputView.readNames()));
        Results results = repeat(() -> new Results(inputView.readResults(), people));
        Ladder ladder = repeat(() -> new Ladder(
                people,
                inputView.readMaxHeight(),
                new RandomGenerateStrategy()));

        ladderService = new LadderService(people, results, ladder);
        outputView.printTotalLadder(people, results, ladder);
    }

    public void run() {
        Results results;
        do {
            results = repeat(this::resultRequest);
            outputView.printGameResults(ladderService.getPeople(), results);
        } while (results.canTryAgain());
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

    private Results resultRequest() {
        String input = inputView.readResult();
        return ladderService.calculateAndGetResults(input);
    }
}
