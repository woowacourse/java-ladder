import domain.Height;
import domain.Ladder;
import domain.Players;
import domain.Prizes;
import domain.generator.BridgeGenerator;
import java.util.List;
import view.InputView;
import view.OutputView;

public class LadderGame {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGenerator bridgeGenerator;

    public LadderGame(InputView inputView, OutputView outputView, BridgeGenerator bridgeGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeGenerator = bridgeGenerator;
    }

    public void run() {
        List<String> inputNames = inputView.readPlayerNames();
        Players players = new Players(inputNames);
        List<String> inputResults = inputView.readResults();
        Prizes prizes = new Prizes(players, inputResults);
        int inputHeight = inputView.readHeight();
        Height height = new Height(inputHeight);

        Ladder ladder = new Ladder(players, height, bridgeGenerator);

        outputView.printLadderGame(ladder, players.getNames(), prizes.getPrizes());
    }
}
