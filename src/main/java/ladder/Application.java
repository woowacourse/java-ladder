package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class Application {
    private static final String ALL_PARTICIPANT = "all";

    public static void main(String[] args) {
        List<String> names = InputView.inputNames();
        List<String> items = InputView.inputItems(names.size());
        LadderHeight height = InputView.inputHeight();

        LadderBuilder ladderBuilder = new LadderBuilder();
        Ladder ladder = ladderBuilder.build(height, names.size(), new RandomValueBuildStrategy());

        printLadder(names, items, ladder);

        LadderResult ladderResult = ladder.play();
        List<String> result = ladderResult.match(items);

        String participant;

        do {
            participant = InputView.inputParticipant(names);
            OutputView.printResult(names, result, participant);
        } while (!participant.equals(ALL_PARTICIPANT));
    }

    private static void printLadder(List<String> names, List<String> items, Ladder ladder) {
        OutputView.printNames(names);
        OutputView.printLadder(ladder);
        OutputView.printItems(items);
    }
}
