package controller;

import domain.TargetPlayer;
import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.ladder.stick.RandomStickGenerator;
import domain.ladder.sticks.NotRepeatedSticksGenerator;
import domain.player.Players;
import domain.result.Results;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

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

        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < players.getPlayerSize(); i++) {
            resultList.add(ladder.climb(i));
        }

        TargetPlayer targetPlayer = readTargetPlayerIn(players.getPlayerNames());

        outputView.printLadder(players, ladder, results);
        System.out.println();
        if (targetPlayer.getName().equals("all")) {
            for (int i = 0; i < players.getPlayerSize(); i++) {
                System.out.printf("%s : %s%n", players.getPlayers().get(i).getName(),
                        results.getResults().get(resultList.get(i)).getValue());
            }
        } else {
            int idx = players.getPlayerNames().indexOf(targetPlayer.getName());
            String value = results.getResults().get(idx).getValue();
            System.out.println(value);
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
