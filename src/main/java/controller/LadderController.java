package controller;

import domain.bridge.strategy.RandomBridgeGenerator;
import domain.ladder.Ladder;
import domain.ladder.LadderHeight;
import domain.ladder.LadderResults;
import domain.player.PlayerName;
import domain.player.PlayerNames;
import view.InputView;
import view.OutputView;
import view.command.Command;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

    public void matchPlayerToResult(Ladder ladder) {
        retry(() -> findPlayerResult(ladder));
        outputView.printEndMessage();
    }

    private void findPlayerResult(Ladder ladder) {
        String playerName;
        while (!(playerName = inputView.readPlayerNameForGetResult()).equals(Command.FINISH.getText())) {
            outputView.printPlayerLadderResult(getPlayerLadderResult(ladder, playerName));
        }
    }

    private Map<String, String> getPlayerLadderResult(Ladder ladder, String playerName) {
        if (playerName.equals(Command.ALL.getText())) {
            return ladder.findAllPlayersLadderResultValue();
        }
        return ladder.findSinglePlayerLadderResultValue(playerName);
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
