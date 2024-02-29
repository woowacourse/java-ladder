package controller;

import domain.LadderGame;
import domain.TargetPlayer;
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

public class LadderGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final SticksGenerator sticksGenerator;

    public LadderGameController(InputView inputView, OutputView outputView, SticksGenerator sticksGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.sticksGenerator = sticksGenerator;
    }

    public void run() {
        Players players = readPlayers();
        LadderGame ladderGame = play(players);
        printResult(players, ladderGame);
    }

    private LadderGame play(Players players) {
        Results results = readResultsOfSize(players.getPlayerSize());
        Height height = readHeight();

        Ladder ladder = new Ladder(height, players.getPlayerSize(), sticksGenerator);
        outputView.printLadder(players, ladder, results);
        return new LadderGame(players, ladder, results);
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

    private TargetPlayer readTargetPlayerIn(List<String> players) {
        try {
            String inputTargetPlayer = inputView.readTargetPlayer();
            return new TargetPlayer(inputTargetPlayer, players);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return readTargetPlayerIn(players);
        }
    }

    private void printResult(Players players, LadderGame ladderGame) {
        TargetPlayer targetPlayer = readTargetPlayerIn(players.getPlayerNames());

        if (targetPlayer.isAll()) {
            printAllPlayerResult(ladderGame);
            return;
        }

        printOnePlayerResult(targetPlayer.getName(), ladderGame);
    }

    private void printAllPlayerResult(LadderGame ladderGame) {
        Map<Player, Result> allPlayerResults = ladderGame.getAllPlayerResults();
        outputView.printAllPlayerResults(allPlayerResults);
    }

    private void printOnePlayerResult(String targetPlayerName, LadderGame ladderGame) {
        Result onePlayerResult = ladderGame.getOnePlayerResult(targetPlayerName);
        outputView.printOnePlayerResult(onePlayerResult);
    }
}
