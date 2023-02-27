import domain.CalculatedResults;
import domain.Ladder;
import domain.Lines;
import domain.Players;
import domain.RandomLadderGenerator;
import domain.Results;
import view.InputView;
import view.OutputView;

import java.util.function.Supplier;

public class Application {

    private final InputView inputView;
    private final OutputView outputView;
    private final Ladder ladder;

    private Application(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        Players players = repeat(() -> new Players(inputView.readNames()));
        Results results = repeat(() -> new Results(inputView.readResults()));
        Lines lines = repeat(() -> new RandomLadderGenerator().generate(players, inputView.readMaxHeight()));
        this.ladder = new Ladder(players, results, lines);
        outputView.printTotalLadder(ladder);
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
        CalculatedResults results;
        do {
            results = repeat(() -> {
                String input = inputView.readResult();
                return ladder.calculateResults(input);
            });
            outputView.printGameResults(results);
        } while (results.canTryAgain());
    }

    public static void main(String[] args) {
        Application application = new Application(new InputView(), new OutputView());
        application.run();
    }
}
