package controller;

import domain.Ladder;
import domain.LadderHeight;
import domain.PlayerName;
import domain.PlayerNames;
import domain.bridge.strategy.RandomBridgeGenerator;
import java.util.Arrays;
import java.util.List;
import view.InputView;
import view.OutputView;

public class LadderController extends Controller {

    public LadderController(InputView inputView, OutputView outputView) {
        super(inputView, outputView);
    }

    public Ladder createLadder() {
        PlayerNames playerNames = readPlayerNames();
        LadderHeight ladderHeight = readLadderHeight();
        Ladder ladder = Ladder.of(ladderHeight, playerNames, new RandomBridgeGenerator());
        outputView.printLadder(playerNames, ladder);
        return ladder;
    }

    private PlayerNames readPlayerNames() {
        return retry(() -> createPlayerNames(inputView.readPlayerNames()));
    }

    private PlayerNames createPlayerNames(final List<String> splitPlayerNames) {
        List<PlayerName> playerNames = splitPlayerNames.stream()
                .map(PlayerName::new)
                .toList();

        return new PlayerNames(playerNames);
    }

    private LadderHeight readLadderHeight() {
        return retry(() -> new LadderHeight(inputView.readLadderHeight()));
    }
}
