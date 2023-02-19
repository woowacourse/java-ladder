package engine;

import common.exception.handler.IllegalArgumentExceptionHandler;
import domain.Ladder;
import domain.Bridge;
import domain.People;
import domain.Person;
import generator.LineGenerator;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderEngine {

    private static final String END_OF_FILE = "all";

    private final LineGenerator lineGenerator;

    public LadderEngine(LineGenerator lineGenerator) {
        this.lineGenerator = lineGenerator;
    }

    public void start() {

        People people = makePeople();
        List<String> resultCandidates = makeResultCandidates();
        Ladder ladder = makesLadder(people, resultCandidates);

        OutputView.printLadder(ladder);

        Map<String, String> result = ladder.getLadderMatchingResult();

        printResult(result);
    }

    private void printResult(Map<String, String> result) {
        while (true) {
            String name = InputView.inputShowResultPerson();

            OutputView.printLadderResult(result, name);

            if (name.equals(END_OF_FILE)) {
                break;
            }
        }
    }

    private List<String> makeResultCandidates() {
        return IllegalArgumentExceptionHandler.handleExceptionByRepeating(
                InputView::inputResultCandidates
        );
    }

    private People makePeople() {
        return IllegalArgumentExceptionHandler.handleExceptionByRepeating(
                () -> convertNamesToPeople(InputView.inputName())
        );
    }

    private People convertNamesToPeople(final List<String> names) {
        return new People(names.stream()
                               .map(Person::new)
                               .collect(Collectors.toList()));
    }

    private Ladder makesLadder(People people, List<String> resultCandidates) {
        return IllegalArgumentExceptionHandler.handleExceptionByRepeating(
                () -> {
                    int height = InputView.inputMaxLadderHeight();
                    List<Bridge> bridges = makeLines(people, height);
                    return new Ladder(people, bridges, resultCandidates);
                }
        );
    }

    private List<Bridge> makeLines(final People people, final int height) {
        List<Bridge> bridges = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            Bridge bridge = lineGenerator.generate(people.getParticipantsSize());
            bridges.add(bridge);
        }

        return bridges;
    }
}
