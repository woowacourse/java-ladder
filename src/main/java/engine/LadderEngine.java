package engine;

import static generator.LineGenerator.generateLine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import domain.Ladder;
import domain.Line;
import domain.Person;
import view.InputView;
import view.OutputView;

public class LadderEngine {

    public void start() {
        List<Person> people = convertNamesToPeople(InputView.inputName());

        int height = InputView.inputMaxLadderHeight();

        List<Line> lines = makeLines(people, height);

        Ladder ladder = new Ladder(people, lines);

        OutputView.printLadder(ladder);
    }

    private List<Line> makeLines(List<Person> people, int height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            Line line = generateLine(people.size());
            lines.add(line);
        }
        return lines;
    }

    private List<Person> convertNamesToPeople(List<String> names) {
        return names.stream()
                .map(Person::new)
                .collect(Collectors.toList());
    }
}
