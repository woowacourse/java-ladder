package controller;

import common.exception.model.IOException;
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
import java.util.function.Supplier;

public class LadderController {
    public static final int READ_LIMIT = 10;
    public static final String READ_LIMIT_OVER = String.format("입력 횟수 제한(%d)를 초과하였습니다", READ_LIMIT);

    private final InputView inputView;
    private final OutputView outputView;
    private int retryCount;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.retryCount = 0;
    }

    public Ladder createLadder(final LadderHeight ladderHeight, final PlayerNames playerNames, final LadderResults results) {
        Ladder ladder = Ladder.create(ladderHeight, playerNames.getCount(), new RandomBridgeGenerator());
        outputView.printGeneratedLadder(ladder, playerNames, results);

        return ladder;
    }

    public PlayerNames readPlayerNames() {
        return retry(() -> createPlayerNames(inputView.readPlayerNames()));
    }

    private PlayerNames createPlayerNames(final String[] playerNamesInput) {
        List<PlayerName> playerNames = Arrays.stream(playerNamesInput)
                .map(PlayerName::new)
                .toList();

        return new PlayerNames(playerNames);
    }

    public LadderHeight readLadderHeight() {
        return retry(() -> new LadderHeight(inputView.readLadderHeight()));
    }

    public LadderResults readLadderResults(final int playerCount) {
        return retry(() -> new LadderResults(inputView.readLadderResults(), playerCount));
    }

    public void matchPlayerToResult(final Ladder ladder, final PlayerNames playerNames, final LadderResults results) {
        retry(() -> findPlayerResult(ladder, playerNames, results));
        outputView.printEndMessage();
    }

    private void findPlayerResult(final Ladder ladder, final PlayerNames playerNames, final LadderResults results) {
        String inputPlayerName = inputView.readPlayerNameForGetResult();

        while (!Command.isFinishCommand(inputPlayerName)) {
            outputView.printPlayerLadderResult(getPlayerLadderResult(inputPlayerName, ladder, playerNames, results));
            inputPlayerName = inputView.readPlayerNameForGetResult();
        }
    }

    private Map<String, String> getPlayerLadderResult(final String inputPlayerName, final Ladder ladder,
                                                      final PlayerNames playerNames, final LadderResults results) {
        if (Command.isAllCommand(inputPlayerName)) {
            return ladder.findAllPlayersLadderResultValue(playerNames, results);
        }
        return ladder.findSinglePlayerLadderResultValue(inputPlayerName, playerNames, results);
    }

    <R> R retry(final Supplier<R> supplier) {
        validateRetryCountLimit();
        try {
            R value = supplier.get();
            retryCount = 0;
            return value;
        } catch (Exception exception) {
            outputView.printErrorMessage(exception.getMessage());
            return retry(supplier);
        }
    }

    void retry(final Runnable runnable) {
        validateRetryCountLimit();
        try {
            runnable.run();
            retryCount = 0;
        } catch (Exception exception) {
            outputView.printErrorMessage(exception.getMessage());
            retry(runnable);
        }
    }

    private void validateRetryCountLimit() {
        if (retryCount++ == READ_LIMIT) {
            throw new IOException(READ_LIMIT_OVER);
        }
    }
}
