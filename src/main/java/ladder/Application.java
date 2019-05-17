package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderBuilder;
import ladder.domain.LadderGame;
import ladder.domain.LadderResult;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        List<String> names = InputView.inputNames();
        List<String> items = InputView.inputItems(names.size());
        int height = InputView.inputHeight();

        LadderBuilder ladderBuilder = new LadderBuilder();
        Ladder ladder = ladderBuilder.build(height, names.size());

        printLadder(names, items, ladder);
        List<Integer> result = LadderGame.play(ladder);

        List<String> result2 = LadderResult.match(items, result);

        printResult(names, result2);
    }

    private static void printResult(List<String> names, List<String> result) {
        String participant;

        do {
            participant = InputView.inputParticipant(names);
            OutputView.printResult(names, result, participant);
        } while (!participant.equals("all"));
    }

    private static void printLadder(List<String> names, List<String> items, Ladder ladder) {
        OutputView.printNames(names);
        OutputView.printLadder(ladder);
        OutputView.printItems(items);
    }
}
