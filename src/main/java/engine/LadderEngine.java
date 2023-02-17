package engine;

import common.exception.handler.IllegalArgumentExceptionHandler;
import domain.Ladder;
import domain.Line;
import domain.People;
import domain.Person;
import generator.LineGenerator;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LadderEngine {

    private final LineGenerator lineGenerator;

    public LadderEngine(LineGenerator lineGenerator) {
        this.lineGenerator = lineGenerator;
    }

    public void start() {

        People people = convertNamesToPeople(InputView.inputName());

        Ladder ladder = IllegalArgumentExceptionHandler.handleExceptionByRepeating(
                () -> {
                    int height = InputView.inputMaxLadderHeight();
                    List<Line> lines = makeLines(people, height);
                    return new Ladder(people, lines);
                }
        );

        OutputView.printLadder(ladder);
    }

    private List<Line> makeLines(final People people, final int height) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            Line line = lineGenerator.generate(people.getParticipants().size());
            lines.add(line);
        }

        return lines;
    }

    private People convertNamesToPeople(final List<String> names) {
        return new People(names.stream()
                               .map(Person::new)
                               .collect(Collectors.toList()));
    }
}
