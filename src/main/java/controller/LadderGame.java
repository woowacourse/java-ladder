package controller;

import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.ladder.RandomStickGenerator;
import domain.ladder.StickGenerator;
import domain.player.Players;
import domain.result.Results;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LadderGame {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        Players players = readPlayers();
        Height height = readHeight();
        Results results = readResultsOfSize(players.getPlayerSize());

        StickGenerator stickGenerator = new RandomStickGenerator();
        Ladder ladder = new Ladder(height, players.getPlayerSize(), stickGenerator);

        outputView.printLadder(players, ladder, results);
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
}
