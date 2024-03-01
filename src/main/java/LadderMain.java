import domain.GameResults;
import domain.LadderGame;
import domain.Results;
import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.ladder.LadderFactory;
import domain.ladder.RandomBridgeGenerator;
import domain.ladder.Width;
import domain.player.PlayerNames;
import java.util.Objects;
import view.InputView;
import view.OutputView;

public class LadderMain {

    private static final String SELECT_ALL = "all";

    public static void main(String[] args) {
        final LadderGame ladderGame = makeLadderGame();
        OutputView.printGameBoard(ladderGame.getNames(), ladderGame.getLadder(), ladderGame.getResults());

        final GameResults gameResults = ladderGame.calculateGameResults();

        printGameResultUtilSelectAll(gameResults);
    }

    public static LadderGame makeLadderGame() {
        final PlayerNames playerNames = PlayerNames.from(InputView.readNames());
        final Results results = Results.from(InputView.readResults());
        final Height height = new Height(InputView.readHeight());
        final Width width = Width.from(playerNames);

        final Ladder ladder = LadderFactory.createByStrategy(RandomBridgeGenerator.getInstance(), height, width);
        return new LadderGame(playerNames, results, ladder);
    }

    public static void printGameResultUtilSelectAll(final GameResults gameResults) {
        String playerNameSelected = InputView.selectPlayer();
        boolean doesSelectAll = Objects.equals(playerNameSelected, SELECT_ALL);

        while (!doesSelectAll) {
            OutputView.printResult(gameResults.findBy(playerNameSelected));
            playerNameSelected = InputView.selectPlayer();
            doesSelectAll = Objects.equals(playerNameSelected, SELECT_ALL);
        }
        OutputView.printResults(gameResults);
    }
}
