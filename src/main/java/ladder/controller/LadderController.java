package ladder.controller;

import ladder.domain.ladder.*;
import ladder.domain.player.Name;
import ladder.domain.player.Players;
import ladder.domain.result.PlayResults;
import ladder.domain.result.Results;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class LadderController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RandomPointsGenerator randomPointsGenerator = new RandomPointsGenerator();

    public void run() {
        Players players = createPlayers();
        Results results = createResults(players.count());
        Height height = createHeight();

        List<Line> lines = createLines(players, height);
        Ladder ladder = new Ladder(lines);

        outputView.printGame(players, ladder, results);

        LadderGame ladderGame = new LadderGame(players, results, ladder);
        play(ladderGame);
    }

    private void play(LadderGame ladderGame) {
        Name name = createName();
        showPlay(ladderGame, name);
        if (name.isAll()) {
            return;
        }
        play(ladderGame);
    }

    private void showPlay(LadderGame ladderGame, Name name) {
        try {
            PlayResults playResult = ladderGame.play(name);
            outputView.printPlayResult(playResult);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
    }

    private Players createPlayers() {
        return retryWhileException(this::readPlayers);
    }

    private Players readPlayers() {
        List<String> players = inputView.readPlayers();
        return new Players(players);
    }

    private Results createResults(int countStandard) {
        return retryWhileException(() -> readResults(countStandard));
    }

    private Results readResults(int countStandard) {
        List<String> results = inputView.readResults();
        return new Results(results, countStandard);
    }

    private Height createHeight() {
        return retryWhileException(this::readHeight);
    }

    private Height readHeight() {
        int height = inputView.readHeight();
        return new Height(height);
    }

    private Name createName() {
        String name = retryWhileException(inputView::readName);
        return new Name(name);
    }

    private <T> T retryWhileException(Supplier<T> callback) {
        try {
            return callback.get();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return retryWhileException(callback);
        }
    }

    private List<Line> createLines(Players players, Height height) {
        List<Line> lines = new ArrayList<>();
        int size = players.count();
        while (!height.equals(lines.size())) {
            List<Point> points = randomPointsGenerator.generate(size);
            lines.add(new Line(points));
        }
        return lines;
    }
}
