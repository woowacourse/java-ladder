import domain.generator.RandomBooleanGenerator;
import domain.ladder.Ladder;
import domain.player.Players;
import utils.Log;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        Players players = getPlayers();

        Ladder ladder = getLadder(players.getPlayers().size());

        showOutput(players, ladder);
    }

    private static Ladder getLadder(int playersSize) {
        try {
            return new Ladder(playersSize, InputView.readLadderHeight(), new RandomBooleanGenerator());
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return getLadder(playersSize);
        }
    }

    private static Players getPlayers() {
        try {
            return new Players(InputView.readNames());
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return getPlayers();
        }
    }

    private static void showOutput(Players players, Ladder ladder) {
        OutputView.showResultMessage();
        OutputView.showPlayers(players.getPlayers());
        OutputView.showLadder(ladder);
    }
}
