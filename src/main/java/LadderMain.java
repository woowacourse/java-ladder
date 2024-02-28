import domain.LadderGame;
import domain.MatchingItems;
import domain.ladder.Ladder;
import domain.ladder.LadderFactory;
import domain.ladder.Width;
import domain.player.Players;
import domain.ladder.Height;
import domain.ladder.RandomBridgeGenerator;
import view.InputView;
import view.OutputView;

public class LadderMain {

    private static final String SELECT_ALL = "all";

    public static void main(String[] args) {
        final LadderGame ladderGame = makeLadderGame();

        ladderGame.play();
        OutputView.printLadderMakingResult(
                ladderGame.getPlayerNames(), ladderGame.getLadder(), ladderGame.getMatchingItems());

        final String selectedName = InputView.selectPlayer();
        OutputView.printMatchingResult(ladderGame.matchResult(selectedName, SELECT_ALL));
    }

    public static LadderGame makeLadderGame() {
        final Players players = Players.createInOrderPoisition(InputView.readNames());
        final MatchingItems matchingItems = new MatchingItems(InputView.readMatchingItems(), players.count());
        final Height height = new Height(InputView.readHeight());
        final Width width = Width.from(players);

        final Ladder ladder = LadderFactory.createByStrategy(RandomBridgeGenerator.getInstance(), height, width);
        return new LadderGame(players, matchingItems, ladder);
    }
}
