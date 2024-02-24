import domain.Game;
import java.util.List;
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

        outputView.printLadder(game.getPlayers(), game.getLadder());
    }
}
