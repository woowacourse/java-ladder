package ladder;

import ladder.domain.*;
import ladder.util.InputHelper;
import ladder.util.LadderMaker;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameApplication {
    public static void main(String[] args) {
        LadderGameData ladderGameData = generateData();
        Ladder ladder = new Ladder(LadderMaker.generateAllPoints(ladderGameData.getHeight(), ladderGameData.getPerson().getCountOfPerson()));
        OutputView.printLadder(ladder, ladderGameData);
        ResultMatcher resultMatcher = new ResultMatcher(ladder, ladderGameData);
        String requestedName;
        do {
            requestedName = InputView.findResultName(ladderGameData.getPerson());
            OutputView.printLadderResult(resultMatcher.getResult(requestedName));
        } while (!InputHelper.isAll(requestedName));
    }

    private static LadderGameData generateData() {
        Person person = new Person(InputView.inputNames());
        Result result = new Result(InputView.inputResultAll(person.getCountOfPerson()));
        int height = InputView.inputHeight();

        return new LadderGameData(person, result, height);
    }
}