package controller;

import domain.Height;
import domain.Lines;
import domain.Names;
import domain.PointGenerator;
import domain.RandomPointGenerator;
import domain.Results;
import java.util.List;
import java.util.Map;
import view.InputView;
import view.ResultView;

public class LadderController {
    private Names names;
    private Lines lines;
    private Results results;

    public void drawLadder() {
        names = inputNames();
        results = inputResults(names.size());
        Height height = inputLadderHeight();

        PointGenerator generator = new RandomPointGenerator();
        lines = new Lines(height.getValue(), names.size(), generator);

        LadderDto ladder = new LadderDto()
                .lines(lines)
                .names(names)
                .results(results)
                .build();

        ResultView.printLadderDrawResult(ladder);
    }

    private Height inputLadderHeight() {
        int rawHeight = InputView.getHeight();
        return new Height(rawHeight);
    }

    private Results inputResults(final int nameSize) {
        List<String> rawResults = InputView.getResults();
        return new Results(rawResults, nameSize);
    }

    private Names inputNames() {
        List<String> rawNames = InputView.getNames();
        return new Names(rawNames);
    }

    public void printResult() {
        String target = InputView.findResult();
        List<String> namesAfterMove = names.afterMoveOnLines(lines);
        Map<String, String> resultsWithNames = results.matchNamesAndResults(namesAfterMove);

        if ("all".equals(target)) {
            ResultView.printMoveResult(names.getAll(), resultsWithNames);
            return;
        }
        String result = resultsWithNames.get(target);
        ResultView.printMoveResult(result);
    }
}
