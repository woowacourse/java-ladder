import domain.generator.RandomBooleanGenerator;
import domain.ladder.Ladder;
import domain.player.Players;
import utils.Log;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        Players players = readPlayers();

        Ladder ladder = generateLadder(players.getPlayers().size());

        showOutput(players, ladder);
    }

    private static Ladder generateLadder(int playersSize) {
        try {
            return new Ladder(playersSize, InputView.readLadderHeight(), new RandomBooleanGenerator());
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return generateLadder(playersSize);
        }
    }

    private static Players readPlayers() {
        try {
            return new Players(InputView.readNames());
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return readPlayers();
        }
    }

    private static void showOutput(Players players, Ladder ladder) {
        OutputView.showResultMessage();
        OutputView.showPlayers(players.getPlayers());
        OutputView.showLadder(ladder);
    }
}
