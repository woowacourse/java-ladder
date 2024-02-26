import domain.LadderGame;
import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.player.Names;
import domain.ladder.bridgeConstructstrategy.RandomBridgeConstructStrategy;
import domain.result.Results;
import view.InputView;
import view.OutputView;

public class LadderGameController {

    private LadderGameController() {
    }

    public static void run() {
        LadderGame ladderGame = createLadderGame();
        printLadderGame(ladderGame);
    }

    private static void printLadderGame(LadderGame ladderGame) {
        OutputView.printNames(ladderGame.getNames());
        OutputView.printLadder(ladderGame.getLadder());
        OutputView.printResults(ladderGame.getResult());
    }

    private static LadderGame createLadderGame() {
        try {
            Names names = readNames();
            Results results = readResults();
            Height height = readHeight();
            return new LadderGame(names, results, new Ladder(new RandomBridgeConstructStrategy(), names, height));
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return createLadderGame();
        }
    }
    private static Names readNames() {
        try {
            Names names = new Names(InputView.readPersonNames());
            OutputView.printNewLine();
            return names;
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return readNames();
        }
    }

    private static Results readResults() {
        try {
            Results results = new Results(InputView.readLadderResult());
            OutputView.printNewLine();
            return results;
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return readResults();
        }
    }

    private static Height readHeight() {
        try {
            Height height = new Height(InputView.readHeight());
            OutputView.printNewLine();
            return height;
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return readHeight();
        }
    }
}
