package ladder.controller;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class LadderGame {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RandomPointsGenerator randomPointsGenerator = new RandomPointsGenerator();

    public void run() {
        Players players = createPeople();
        Results results = createResults(players.count());
        Height height = createHeight();

        List<Line> lines = createLines(players, height);
        Ladder ladder = new Ladder(lines);

        outputView.printGame(players, ladder, results);

        Game game = new Game(players, results, ladder);
        play(game);
    }

    private void play(Game game) {
        Name name = createTarget();
        PlayResults playResult = game.play(name);
        outputView.printPlayResultNotice();
        outputView.printPlayResult(playResult);
        if (name.isAll()) {
            return;
        }
        play(game);
    }

    private Players createPeople() {
        return retryWhileException(this::readNames);
    }

    private Players readNames() {
        List<String> rawNames = inputView.readNames();
        List<Player> players = rawNames.stream()
                .map(Player::new)
                .toList();
        return new Players(players);
    }

    private Results createResults(int countStandard) {
        return retryWhileException(() -> readResults(countStandard));
    }

    private Results readResults(int countStandard) {
        List<String> rawResults = inputView.readResults();
        List<Result> results = rawResults.stream()
                .map(Result::new)
                .toList();
        return new Results(results, countStandard);
    }

    private Height createHeight() {
        return retryWhileException(this::readHeight);
    }

    private Height readHeight() {
        try {
            int height = inputView.readHeight();
            return new Height(height);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("사다리 높이는 숫자입니다.");
        }
    }

    private Name createTarget() {
        String target = retryWhileException(inputView::readTarget);
        return new Name(target);
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
