import domain.Ladder;
import domain.Players;
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
        List<String> names = inputView.readNames();
        int height = inputView.readHeight();
        Players players = new Players(names);
        Ladder ladder = new Ladder(height, players.getPlayerSize());

        outputView.printLadder(players, ladder);
    }
}
