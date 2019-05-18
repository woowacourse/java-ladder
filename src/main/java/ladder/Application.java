package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Application application = new Application();
        application.play();
    }

    private void play() {
        List<String> names = InputView.inputNames();
        List<String> items = InputView.inputItems(names.size());
        int height = InputView.inputHeight();

        Ladder ladder = new LadderGenerator().generate(height, names.size());
        printLadder(names, items, ladder);

        List<String> finalResult = getResult(items, ladder);
        printResult(names, finalResult);
    }

    private void printLadder(List<String> names, List<String> items, Ladder ladder) {
        OutputView.printNames(names);
        OutputView.printLadderBody(ladder);
        OutputView.printItems(items);
    }

    private List<String> getResult(List<String> items, Ladder ladder) {
        List<Integer> result = ladder.play();
        return LadderResult.generate(result, items);
    }

    private void printResult(List<String> names, List<String> finalResult) {
        String participant;
        do {
            participant = InputView.inputParticipant(names);
            OutputView.printResult(participant, finalResult, names);
        } while (!participant.equals("all"));
    }
}
