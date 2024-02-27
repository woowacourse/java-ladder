import domain.LadderGame;
import java.util.List;
import view.InputView;
import view.OutputView;

public class LadderMain {

    public static void main(String[] args) {
        final List<String> playerNames = InputView.readNames();
        final int height = InputView.readHeight();

        final LadderGame ladderGame = new LadderGame(playerNames, height);

        OutputView.printLadderMakingResult(ladderGame.getPlayerNames(), ladderGame.getLadder());
    }
}
