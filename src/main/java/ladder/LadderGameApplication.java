package ladder;

import ladder.domain.*;
import ladder.util.InputHelper;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameApplication {
    public static void main(String[] args) {
        LadderGameData ladderGameData = generateData();
        Ladder ladder = Ladder.newLadder(ladderGameData);
        OutputView.printLadder(ladder, ladderGameData);
        RewardPersonConnector rewardPersonConnector = new RewardPersonConnector(ladder, ladderGameData);
        String requestedName;
        do {
            requestedName = InputView.findResultName(ladderGameData);
            OutputView.printLadderResult(rewardPersonConnector.getResult(requestedName));
        } while (!InputHelper.isAll(requestedName));
    }

    private static LadderGameData generateData() {
        Person person = new Person(InputView.inputNames());
        LadderRewards ladderRewards = new LadderRewards(InputView.inputResultAll(person.getCountOfPerson()));
        int height = InputView.inputHeight();

        return new LadderGameData(person, ladderRewards, height);
    }
}