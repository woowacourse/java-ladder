import domain.GameResults;
import domain.LadderGame;
import domain.Results;
import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.ladder.LadderFactory;
import domain.ladder.RandomBridgeGenerator;
import domain.ladder.Width;
import domain.player.Names;
import java.util.Objects;
import view.InputView;
import view.OutputView;

public class LadderMain {

    private static final String SELECT_ALL = "all";

    public static void main(String[] args) {
        final LadderGame ladderGame = makeLadderGame();

        final GameResults gameResults = ladderGame.calculateGameResults();
        OutputView.printGameBoard(ladderGame.getNames(), ladderGame.getLadder(), ladderGame.getResults());

        printResultUtilSelectAll(gameResults);
    }

    public static LadderGame makeLadderGame() {
        final Names names = Names.of(InputView.readNames());
        final Results results = Results.from(InputView.readResults());
        final Height height = new Height(InputView.readHeight());
        final Width width = Width.from(names);

        final Ladder ladder = LadderFactory.createByStrategy(RandomBridgeGenerator.getInstance(), height, width);
        return new LadderGame(names, results, ladder);
    }

    public static void printResultUtilSelectAll(final GameResults gameResults) {
        String selectedName = InputView.selectPlayer();
        boolean doesSelectAll = Objects.equals(selectedName, SELECT_ALL);

        while (!doesSelectAll) {
            OutputView.printResult(gameResults.findByName(selectedName));
            selectedName = InputView.selectPlayer();
            doesSelectAll = Objects.equals(selectedName, SELECT_ALL);
        }
        OutputView.printResults(gameResults);
    }
}
