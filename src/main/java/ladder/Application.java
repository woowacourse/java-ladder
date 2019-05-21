package ladder;

import ladder.domain.*;
import ladder.util.InputHelper;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LadderGameData ladderGameData = generateData();
        LadderGame ladderGame = new LadderGame(LadderGame.generateAllPoints(ladderGameData.getHeight(), ladderGameData.getPerson().getCountOfPerson()));
        OutputView.printLadder(ladderGame, ladderGameData);
        ResultProcessor resultProcessor = ladderGame.generateAllResults(ladderGameData);
        String requestedName;
        do {
            requestedName = InputView.findResultName(ladderGameData.getPerson());
            OutputView.printLadderResult(resultProcessor.getResult(requestedName));
        } while (!InputHelper.isAll(requestedName));
    }

    private static LadderGameData generateData() {
        Person person = new Person(InputView.inputNames());
        Result result = new Result(InputView.inputResultAll(person.getCountOfPerson()));
        int height = InputView.inputHeight();

        return new LadderGameData(person, result, height);
    }
}