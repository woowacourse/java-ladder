import domain.Ladder;
import domain.LadderGame;
import domain.People;
import domain.RandomLadderGenerator;
import domain.Results;
import domain.ResultsMap;
import view.InputView;
import view.OutputView;

import java.util.function.Supplier;

public class Application {
    private final InputView inputView;
    private final OutputView outputView;
    private final LadderGame ladderGame;

    private Application(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.ladderGame = initLadderGame();
    }

    private LadderGame initLadderGame() {
        People people = repeat(() -> new People(inputView.readNames()));
        Results results = repeat(() -> new Results(inputView.readResults(), people));
        Ladder ladder = repeat(() -> new RandomLadderGenerator().generate(people, inputView.readMaxHeight()));

        outputView.printTotalLadder(people, results, ladder);
        return new LadderGame(people, results, ladder);
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

    private void run() {
        ResultsMap results;
        do {
            results = repeat(() -> {
                String input = inputView.readResult();
                return ladderGame.getResults(input);
            });
            outputView.printGameResults(results);
        } while (results.canTryAgain());
    }


    public static void main(String[] args) {
        Application application = new Application(new InputView(), new OutputView());
        application.run();
    }
}
