package engine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import common.exception.handler.IllegalArgumentExceptionHandler;
import domain.Ladder;
import domain.Line;
import domain.Participant;
import generator.LineGenerator;
import generator.RandomBridgeGenerator;
import view.InputView;
import view.OutputView;

public class LadderEngine {

    public void start() {
        List<Participant> people = IllegalArgumentExceptionHandler.handleExceptionByRepeating(() ->
                createPeopleWith(InputView.inputNames())
        );
        Ladder ladder = IllegalArgumentExceptionHandler.handleExceptionByRepeating(() -> {
            int height = InputView.inputMaxLadderHeight();
            List<Line> lines = makeLines(people, height);
            return new Ladder(people, lines);
        });
        OutputView.printLadder(ladder);
    }

    private List<Line> makeLines(final List<Participant> people, final int height) {
        List<Line> lines = new ArrayList<>();
        LineGenerator lineGenerator = new LineGenerator(new RandomBridgeGenerator());
        for (int i = 0; i < height; i++) {
            Line line = lineGenerator.generate(people.size());
            lines.add(line);
        }
        return lines;
    }

    private List<Participant> createPeopleWith(final List<String> names) {
        return names.stream()
                .map(Participant::new)
                .collect(Collectors.toList());
    }
}
