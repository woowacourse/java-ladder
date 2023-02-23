package engine;

import common.cache.LadderResultCacheManager;
import common.exception.handler.IllegalArgumentExceptionHandler;
import domain.Bridge;
import domain.Ladder;
import domain.Line;
import domain.People;
import domain.Person;
import engine.model.ResultModel;
import generator.LineGenerator;
import view.InputView;
import view.OutputLadderView;
import view.OutputResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LadderEngine {

    private static final String END_OF_FILE = "all";

    private final LineGenerator lineGenerator;
    private final LadderResultCacheManager ladderResultCacheManager;

    public LadderEngine(final LineGenerator lineGenerator, final LadderResultCacheManager ladderResultCacheManager) {
        this.lineGenerator = lineGenerator;
        this.ladderResultCacheManager = ladderResultCacheManager;
    }

    public void start() {

        People people = makePeople();
        List<String> resultCandidates = makeResultCandidates();
        Ladder ladder = makesLadder(people, resultCandidates);

        OutputLadderView.printLadder(ladder);

        printResult(ladder);
    }

    private void printResult(final Ladder ladder) {
        while (true) {
            String name = InputView.inputShowResultPerson();

            if (name.equals(END_OF_FILE)) {
                OutputResultView.printLadderAll(ladderResultCacheManager.getLadderResultAllCache(ladder));
                break;
            }

            try {
                String ladderResult = ladderResultCacheManager.getLadderResultCache(name, ladder);
                ResultModel resultModel = new ResultModel(name, ladderResult);

                OutputResultView.printLadderSpecific(resultModel);

            } catch (IllegalArgumentException exception) {
                OutputResultView.printNotExistedParticipant();
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

    private Ladder makesLadder(final People people, final List<String> resultCandidates) {
        return IllegalArgumentExceptionHandler.handleExceptionByRepeating(
                () -> {
                    int height = InputView.inputMaxLadderHeight();
                    Line line = makeLines(people, height);
                    return new Ladder(people, line, resultCandidates);
                }
        );
    }

    private Line makeLines(final People people, final int height) {
        List<Bridge> bridges = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            Bridge bridge = lineGenerator.generate(people.getParticipantsSize());
            bridges.add(bridge);
        }

        return new Line(bridges);
    }
}
