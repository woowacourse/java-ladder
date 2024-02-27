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

    public Ladder createLadder() {
        PlayerNames playerNames = readPlayerNames();
        LadderResults ladderResults = readLadderResults(playerNames.getCount());
        LadderHeight ladderHeight = readLadderHeight();

        Ladder ladder = Ladder.create(ladderHeight, playerNames, ladderResults, new RandomBridgeGenerator());
        outputView.printLadder(playerNames, ladder);

        return ladder;
    }

    public void matchPlayerToResult(final Ladder ladder) {
        retry(() -> findPlayerResult(ladder));
        outputView.printEndMessage();
    }

    private void findPlayerResult(final Ladder ladder) {
        String playerName;
        while (!(playerName = inputView.readPlayerNameForGetResult()).equals(Command.FINISH.getText())) {
            outputView.printPlayerLadderResult(getPlayerLadderResult(ladder, playerName));
        }
    }

    private Map<String, String> getPlayerLadderResult(final Ladder ladder, final String playerName) {
        if (playerName.equals(Command.ALL.getText())) {
            return ladder.findAllPlayersLadderResultValue();
        }
        return ladder.findSinglePlayerLadderResultValue(playerName);
    }

    private PlayerNames readPlayerNames() {
        return retry(() -> createPlayerNames(inputView.readPlayerNames()));
    }

    private PlayerNames createPlayerNames(final String[] playerNamesInput) {
        List<PlayerName> playerNames = Arrays.stream(playerNamesInput)
                .map(PlayerName::new)
                .toList();

        return new PlayerNames(playerNames);
    }

    private LadderHeight readLadderHeight() {
        return retry(() -> new LadderHeight(inputView.readLadderHeight()));
    }

    private LadderResults readLadderResults(final int playerCount) {
        return retry(() -> new LadderResults(inputView.readLadderResults(), playerCount));
    }

    protected <R> R retry(final Supplier<R> supplier) {
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

    protected void retry(final Runnable runnable) {
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
