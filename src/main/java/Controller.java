import java.util.List;
import java.util.Map;
import domain.Game;
import domain.GameResult;
import view.InputView;
import view.OutputView;

class Controller {

    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<String> playerNames = inputView.readNames();
        List<String> gameResults = inputView.readGameResults();
        int height = inputView.readHeight();
        Game game = new Game(playerNames, gameResults, height);

        outputView.printLadder(game);

        while (true) {
            String targetPlayer = inputView.readNameForResult();

            if (targetPlayer.equals("all")) {
                Map<String, GameResult> result = game.showResultAll();
                outputView.printResultAll(result);
            } else {
                GameResult result = game.showResult(targetPlayer);
                outputView.printResult(result);
            }
        }
    }
}
