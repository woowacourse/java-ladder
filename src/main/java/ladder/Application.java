package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {
    private static final String ALL = "all";

    private static Person person;
    private static Result result;
    private static int height;

    public static void main(String[] args) {
        receiveInput();
        LadderGame ladderGame = new LadderGame(LadderGame.generateAllPoints(height, person.getCountOfPerson()));
        OutputView.printLadder(ladderGame, person, result);
        ResultProcessor resultProcessor = ladderGame.generateAllResults(person, result);
        String requestedName;
        do {
            requestedName = InputView.findResultName(person);
            OutputView.printLadderResult(resultProcessor.getResult(requestedName));
        } while (!requestedName.equals(ALL));
    }

    private static void receiveInput() {
        person = new Person(InputView.inputNames());
        result = new Result(InputView.inputResultAll(person.getCountOfPerson()));
        height = InputView.inputHeight();
    }
}