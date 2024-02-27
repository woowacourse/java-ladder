import domain.LadderGame;
import domain.ladder.RandomBridgeGenerator;
import java.util.List;
import view.InputView;
import view.OutputView;

public class LadderMain {

    public static void main(String[] args) {
        final List<String> playerNames = InputView.readNames();
        final List<String> matchingItems = InputView.readMatchingItems();
        final int height = InputView.readHeight();

        final LadderGame ladderGame = new LadderGame(playerNames, matchingItems, height,
                RandomBridgeGenerator.getInstance());

        OutputView.printLadderMakingResult(ladderGame.getPlayerNames(), ladderGame.getLadder());
    }
}
