package controller;

import domain.ladder.Ladder;
import domain.ladder.LadderHeight;
import domain.ladder.LadderResults;
import domain.player.PlayerName;
import domain.player.PlayerNames;
import domain.bridge.strategy.RandomBridgeGenerator;
import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.List;

public class LadderController extends RetryableController {

    public LadderController(InputView inputView, OutputView outputView) {
        super(inputView, outputView);
    }

    public Ladder createLadder() {
        PlayerNames playerNames = readPlayerNames();
        LadderResults ladderResults = readLadderResults(playerNames.getCount());
        LadderHeight ladderHeight = readLadderHeight();

        Ladder ladder = Ladder.create(ladderHeight, playerNames, ladderResults, new RandomBridgeGenerator());
        outputView.printLadder(playerNames, ladder);

        return ladder;
    }

    private PlayerNames readPlayerNames() {
        return retry(() -> createPlayerNames(inputView.readPlayerNames()));
    }

    private PlayerNames createPlayerNames(String[] playerNamesInput) {
        List<PlayerName> playerNames = Arrays.stream(playerNamesInput)
                .map(PlayerName::new)
                .toList();

        return new PlayerNames(playerNames);
    }

    private LadderHeight readLadderHeight() {
        return retry(() -> new LadderHeight(inputView.readLadderHeight()));
    }
    private LadderResults readLadderResults(int playerCount) {
        return retry(() -> new LadderResults(inputView.readLadderResults(), playerCount));
    }
}
