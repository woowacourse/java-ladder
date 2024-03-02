package controller;

import domain.LadderGameRecord;
import domain.SelectedPlayer;
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
        Players players = readPlayers();
        LadderGameRecord ladderGameRecord = play(players);
        printResult(players, ladderGameRecord);
    }

    private LadderGameRecord play(Players players) {
        Results results = readResultsOfSize(players.getPlayerSize());
        Height height = readHeight();

        Ladder ladder = Ladder.of(height, players.getPlayerSize(), sticksGenerator);
        outputView.printLadder(players, ladder, results);
        return LadderGameRecord.of(players, ladder, results);
    }

    private Players readPlayers() {
        try {
            List<String> names = inputView.readNames();
            return new Players(names);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return readPlayers();
        }
    }

    private Results readResultsOfSize(int playerSize) {
        try {
            List<String> results = inputView.readResults();
            return new Results(results, playerSize);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return readResultsOfSize(playerSize);
        }
    }

    private Height readHeight() {
        try {
            int height = inputView.readHeight();
            return new Height(height);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return readHeight();
        }
    }

    private SelectedPlayer readTargetPlayerIn(List<String> players) {
        try {
            String inputTargetPlayer = inputView.readTargetPlayer();
            return new SelectedPlayer(inputTargetPlayer, players);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return readTargetPlayerIn(players);
        }
    }

    private void printResult(Players players, LadderGameRecord ladderGameRecord) {
        SelectedPlayer selectedPlayer = readTargetPlayerIn(players.getPlayerNames());

        if (selectedPlayer.isAll()) {
            printAllPlayerResult(ladderGameRecord);
            return;
        }

        printOnePlayerResult(selectedPlayer.getName(), ladderGameRecord);
    }

    private void printAllPlayerResult(LadderGameRecord ladderGameRecord) {
        Map<Player, Result> allPlayerResults = ladderGameRecord.getAllPlayerResults();
        outputView.printAllPlayerResults(allPlayerResults);
    }

    private void printOnePlayerResult(String targetPlayerName, LadderGameRecord ladderGameRecord) {
        Result onePlayerResult = ladderGameRecord.getOnePlayerResult(targetPlayerName);
        outputView.printOnePlayerResult(onePlayerResult);
    }
}
