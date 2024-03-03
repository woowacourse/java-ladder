package controller;

import domain.LadderGameRecord;
import domain.player.ResultViewPlayer;
import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.ladder.sticks.SticksGenerator;
import domain.player.Player;
import domain.player.Players;
import domain.result.Result;
import domain.result.Results;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class LadderGame {

    private final InputView inputView;
    private final OutputView outputView;
    private final SticksGenerator sticksGenerator;

    public LadderGame(InputView inputView, OutputView outputView, SticksGenerator sticksGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.sticksGenerator = sticksGenerator;
    }

    public void run() {
        Players players = retryUntilSuccess(this::readPlayers);
        LadderGameRecord ladderGameRecord = play(players);
        printResult(players, ladderGameRecord);
    }

    private LadderGameRecord play(Players players) {
        Results results = retryUntilSuccess(() -> readResultsOfSize(players.getPlayerSize()));
        Height height = retryUntilSuccess(this::readHeight);

        Ladder ladder = Ladder.of(height, players.getPlayerSize(), sticksGenerator);
        outputView.printLadder(players, ladder, results);
        return new LadderGameRecord(players, ladder, results);
    }

    private Players readPlayers() {
        List<String> names = inputView.readNames();
        return new Players(names);
    }

    private Results readResultsOfSize(int playerSize) {
        List<String> results = inputView.readResults();
        return new Results(results, playerSize);
    }

    private Height readHeight() {
        int height = inputView.readHeight();
        return new Height(height);
    }

    private void printResult(Players players, LadderGameRecord ladderGameRecord) {
        ResultViewPlayer resultViewPlayer = retryUntilSuccess(() -> readResultViewPlayer(players));

        if (resultViewPlayer.isAll()) {
            printAllPlayerResult(ladderGameRecord);
            return;
        }

        printOnePlayerResult(resultViewPlayer.getName(), ladderGameRecord);
    }

    private ResultViewPlayer readResultViewPlayer(Players players) {
        String inputTargetPlayer = inputView.readTargetPlayer();
        return new ResultViewPlayer(inputTargetPlayer, players);
    }

    private void printAllPlayerResult(LadderGameRecord ladderGameRecord) {
        Map<Player, Result> allPlayerResults = ladderGameRecord.getAllPlayerResults();
        outputView.printAllPlayerResults(allPlayerResults);
    }

    private void printOnePlayerResult(String targetPlayerName, LadderGameRecord ladderGameRecord) {
        Result onePlayerResult = ladderGameRecord.getOnePlayerResult(targetPlayerName);
        outputView.printOnePlayerResult(onePlayerResult);
    }

    private <T> T retryUntilSuccess(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return retryUntilSuccess(supplier);
        }
    }
}
