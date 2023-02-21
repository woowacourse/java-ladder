import domain.ladder.Ladder;
import domain.ladder.LadderGame;
import domain.player.Players;
import utils.Log;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        LadderGame ladderGame = createLadderGame();

        Ladder ladder = createLadder(ladderGame);

        showOutput(ladderGame.getPlayers(), ladder);
    }

    private static LadderGame createLadderGame() {
        try {
            List<String> names = InputView.readNames();
            return new LadderGame(names);
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return createLadderGame();
        }
    }

    private static Ladder createLadder(LadderGame ladderGame) {
        try {
            int height = InputView.readLadderHeight();
            return ladderGame.createLadder(height);
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return createLadder(ladderGame);
        }
    }

    private static void showOutput(Players players, Ladder ladder) {
        OutputView.showResultMessage();
        OutputView.showPlayers(players.getPlayers());
        OutputView.showLadder(ladder);
    }
}
