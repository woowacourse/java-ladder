import domain.LadderGame;
import domain.MatchingItems;
import domain.Players;
import domain.ladder.Height;
import domain.ladder.RandomBridgeGenerator;
import view.InputView;
import view.OutputView;

public class LadderMain {

    private static final String SELECT_ALL = "all";

    public static void main(String[] args) {
        final Players players = new Players(InputView.readNames());
        final MatchingItems matchingItems = new MatchingItems(InputView.readMatchingItems(), players.count());
        final Height height = new Height(InputView.readHeight());

        final LadderGame ladderGame = new LadderGame(players, matchingItems, height,
                RandomBridgeGenerator.getInstance());
        ladderGame.play();
        OutputView.printLadderMakingResult(
                ladderGame.getPlayerNames(), ladderGame.getLadder(), matchingItems.getItems());

        final String selectedName = InputView.selectPlayer();
        OutputView.printMatchingResult(ladderGame.matchResult(selectedName, SELECT_ALL));
    }
}
