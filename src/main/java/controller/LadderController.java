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
        int pointCount = calculatePointCount(playerNames);
        Ladder ladder = Ladder.of(ladderHeight, pointCount, new RandomBridgeGenerator());
        outputView.printLadder(playerNames, ladder);
        return ladder;
    }

    private int calculatePointCount(PlayerNames playerNames) {
        return playerNames.getCount() - 1;
    }

    public PlayerNames readPlayerNames() {
        return retry(() -> createPlayerNames(inputView.readPlayerNames()));
    }

    public PlayerNames createPlayerNames(final String[] splitPlayerNames) {
        List<PlayerName> playerNames = Arrays.stream(splitPlayerNames)
                .map(PlayerName::new)
                .toList();

        return new PlayerNames(playerNames);
    }

    public LadderHeight readLadderHeight() {
        return retry(() -> new LadderHeight(inputView.readLadderHeight()));
    }
}
