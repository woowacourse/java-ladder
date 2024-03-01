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

    public LadderGame() {
    }

    public void run() {
        People people = createNames();
        Results results = createResults(people.count());
        Height height = createHeight();

        List<Line> lines = createLines(people, height);
        Ladder ladder = new Ladder(lines);

        outputView.printPeople(people);
        outputView.printLadder(ladder);
        outputView.printResults(results);

        Game game = new Game(people, results, ladder);
        play(game);
    }

    private void play(Game game) {
        Name target = createTarget();
        PlayResults playResult = game.play(target);
        outputView.printPlayResultNotice();
        outputView.printPlayResult(playResult);
        if (target.isAll()) {
            return;
        }
        play(game);
    }

    private People createNames() {
        return retryWhileException(this::readNames);
    }

    private People readNames() {
        List<String> rawNames = inputView.readNames();
        List<Name> names = rawNames.stream()
                .map(Name::new)
                .toList();
        return new People(names);
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

    private List<Line> createLines(People people, Height height) {
        List<Line> lines = new ArrayList<>();
        int size = people.count();
        while (!height.equals(lines.size())) {
            List<Point> points = randomPointsGenerator.generate(size);
            lines.add(new Line(points));
        }
        return lines;
    }
}
