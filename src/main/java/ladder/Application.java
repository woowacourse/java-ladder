package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {
    private static Person person;
    private static Result result;
    private static Height height;
    private static LadderGame ladderGame;
    private static GameResult gameResult;

    public static void main(String[] args) {
        receiveInput();
        ladderGame = LadderGame.generateLadder(height, person);
        OutputView.printLadder(ladderGame, person, result);
        gameResult = ladderGame.generateAllResults(person, result);
        String requestedName;
        do {
            requestedName = InputView.findResultName(person);
            OutputView.printLadderResult(gameResult.getResult(requestedName));
        } while (!requestedName.equals("all"));
    }

    private static void receiveInput() {
        person = new Person(InputView.inputNames());
        result = new Result(InputView.inputResultAll(person.getCountOfPerson()));
        height = InputView.inputHeight();
    }
}