package engine;

import common.exception.handler.IllegalArgumentExceptionHandler;
import domain.Ladder;
import domain.Line;
import domain.Person;
import domain.RandomBridgeGenerator;
import generator.LineGenerator;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LadderEngine {

    public void start() {

        List<Person> people = convertNamesToPeople(InputView.inputName());

        Ladder ladder = IllegalArgumentExceptionHandler.handleExceptionByRepeating(
                () -> {
                    int height = InputView.inputMaxLadderHeight();
                    List<Line> lines = makeLines(people, height);
                    return new Ladder(people, lines);
                }
        );

        OutputView.printLadder(ladder);
    }

    private List<Line> makeLines(final List<Person> people, final int height) {
        List<Line> lines = new ArrayList<>();
        LineGenerator lineGenerator = new LineGenerator(new RandomBridgeGenerator());
        for (int i = 0; i < height; i++) {
            Line line = lineGenerator.generate(people.size());
            lines.add(line);
        }
        return lines;
    }

    private List<Person> convertNamesToPeople(final List<String> names) {
        return names.stream()
                .map(Person::new)
                .collect(Collectors.toList());
    }
}
