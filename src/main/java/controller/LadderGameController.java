package controller;

import domain.LadderGame;
import domain.TargetPlayer;
import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.ladder.stick.RandomStickGenerator;
import domain.ladder.sticks.NotRepeatedSticksGenerator;
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

    public LadderGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        Players players = readPlayers();
        Results results = readResultsOfSize(players.getPlayerSize());
        Height height = readHeight();

        NotRepeatedSticksGenerator sticksGenerator = new NotRepeatedSticksGenerator(new RandomStickGenerator());
        Ladder ladder = new Ladder(height, players.getPlayerSize(), sticksGenerator);
        outputView.printLadder(players, ladder, results);

        TargetPlayer targetPlayer = readTargetPlayerIn(players.getPlayerNames());
        LadderGame ladderGame = new LadderGame(players, ladder, results);

        Map<Player, Result> allPlayerResults = ladderGame.getAllPlayerResults();
        Result onePlayerResult = ladderGame.getOnePlayerResult(targetPlayer.getName());

        if (targetPlayer.isAll()) {
            outputView.printAllPlayerResults(allPlayerResults);
        } else {
            outputView.printOnePlayerResult(onePlayerResult);
        }
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
}
