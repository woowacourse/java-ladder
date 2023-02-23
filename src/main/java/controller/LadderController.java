package controller;

import java.util.List;

import domain.BooleanGenerator;
import domain.Ladder;
import domain.LadderGame;
import domain.LadderGenerator;
import domain.Name;
import domain.Players;
import domain.RandomBooleanGenerator;
import domain.Result;
import domain.Rewards;
import utils.Log;
import view.InputView;
import view.OutputView;

public class LadderController {

    public void run() {
        LadderGame ladderGame = generateLadderGame();

        Name name = generateName();
        while (name.isNotAll()) {
            printResult(ladderGame, name);
            name = generateName();
        }

        List<Result> results = ladderGame.getResults();
        OutputView.printResults(results);
    }

    private LadderGame generateLadderGame() {
        Players players = generatePlayers();
        int numberOfPlayer = players.getNumberOfPlayer();

        Rewards rewards = generateRewards(numberOfPlayer);
        Ladder ladder = generateLadder(numberOfPlayer);

        OutputView.printPlayers(players);
        OutputView.printLadder(ladder);

        return new LadderGame(ladder, players, rewards);
    }

    private Players generatePlayers() {
        try {
            List<String> names = InputView.readPlayers();
            return new Players(names);
        } catch (IllegalArgumentException exception) {
            Log.log(exception.getMessage());
            return generatePlayers();
        }
    }

    private Rewards generateRewards(final int playersSize) {
        try {
            List<String> names = InputView.readRewards();
            return new Rewards(names, playersSize);
        } catch (IllegalArgumentException exception) {
            Log.log(exception.getMessage());
            return generateRewards(playersSize);
        }
    }

    private Ladder generateLadder(final int personCount) {
        try {
            BooleanGenerator booleanGenerator = new RandomBooleanGenerator();
            int height = InputView.readHeight();
            LadderGenerator ladderGenerator = new LadderGenerator(booleanGenerator);
            return ladderGenerator.generateLadder(height, personCount);
        } catch (IllegalArgumentException exception) {
            Log.log(exception.getMessage());
            return generateLadder(personCount);
        }
    }

    private Name generateName() {
        try {
            String name = InputView.readName();
            return new Name(name);
        } catch (IllegalArgumentException exception) {
            Log.log(exception.getMessage());
            return generateName();
        }
    }

    private void printResult(final LadderGame ladderGame, final Name name) {
        try {
            Result result = ladderGame.getResult(name);
            OutputView.printResult(result);
        } catch (IllegalArgumentException exception) {
            Log.log(exception.getMessage());
        }
    }
}
