import domain.Height;
import domain.PlayerNames;
import domain.ladder.Ladder;
import domain.ladder.strategy.GenerateBridgeStrategy;
import view.InputView;
import view.OutputView;

public class LadderGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final GenerateBridgeStrategy bridgeStrategy;

    public LadderGameController(InputView inputView, OutputView outputView, GenerateBridgeStrategy bridgeStrategy) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeStrategy = bridgeStrategy;
    }

    public void run() {
        PlayerNames playerNames = inputView.requestPlayerNames();
        Height height = inputView.requestLadderHeight();

        Ladder ladder = Ladder.of(playerNames, height, bridgeStrategy);
        ladder.shuffleLadder();

        printLadderGameResult(playerNames, ladder);
    }

    private void printLadderGameResult(PlayerNames playerNames, Ladder ladder) {
        outputView.printResultPrefix();
        outputView.printPlayerNames(playerNames);
        outputView.printResult(ladder);
    }
}
