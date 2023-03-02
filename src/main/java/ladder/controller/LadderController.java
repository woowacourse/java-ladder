package ladder.controller;

import java.util.function.Supplier;
import ladder.dto.LadderResponse;
import ladder.dto.PlayerResultResponse;
import ladder.service.LadderService;
import ladder.view.LadderView;
import ladder.view.OutputView;

public class LadderController {
    private static final String EXIT_COMMAND = "all";

    private final LadderService ladderService;
    private final LadderView ladderView;

    public LadderController(LadderService ladderService, LadderView ladderView) {
        this.ladderService = ladderService;
        this.ladderView = ladderView;
    }

    public void run() {
        repeat(() -> ladderService.createPlayers(ladderView.readPlayerNames()));
        repeat(() -> ladderService.createPrizes(ladderView.readPrizes()));
        LadderResponse ladderResponse = repeat(() -> ladderService.playLadderGame(ladderView.readLadderHeight()));
        ladderView.printLadderResult(ladderResponse);
        repeat(this::printPlayerResult);
        ladderView.printAllPlayerResults(ladderService.findAllPlayerResults());
    }

    private void printPlayerResult() {
        String playerName = ladderView.readPlayerName();
        if (playerName.equals(EXIT_COMMAND)) {
            return;
        }
        PlayerResultResponse result = ladderService.findPlayerResultByName(playerName);
        ladderView.printPlayerResult(result);
        printPlayerResult();
    }

    private <T> T repeat(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (RuntimeException e) {
            OutputView.printError(e.getMessage());
            return repeat(supplier);
        }
    }

    private void repeat(Runnable runnable) {
        try {
            runnable.run();
        } catch (RuntimeException e) {
            OutputView.printError(e.getMessage());
            repeat(runnable);
        }
    }
}
