package ladder.controller;

import ladder.domain.Compensation;
import ladder.domain.Ladder;
import ladder.domain.People;
import ladder.view.InputView;
import ladder.view.OutputView;

import static ladder.utils.InputUtility.retryUntilGet;

public class LadderGameController {
    private LadderGameController() {
    }

    public static void run() {
        People people = getPeople();
        Compensation compensation = getCompensation(people);
        Ladder ladder = getLadder(people);

        OutputView.printNames(people);
        OutputView.printLadder(ladder);
    }

    private static People getPeople() {
        return retryUntilGet(LadderGameController::makePeople);
    }

    private static Ladder getLadder(People people) {
        return retryUntilGet(LadderGameController::makeLadder, people);
    }

    private static Compensation getCompensation(People people) {
        return retryUntilGet(LadderGameController::makeCompensation, people);
    }

    private static People makePeople() {
        try {
            return new People(InputView.readNames());
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
        }
        return null;
    }

    private static Ladder makeLadder(People people) {
        try {
            int peopleNumber = people.getNames().size();
            return new Ladder(InputView.readHeight(), peopleNumber);
        } catch (NumberFormatException e) {
            OutputView.printMessage("사다리의 높이는 1이상 100이하의 자연수여야 합니다");
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
        }
        return null;
    }

    private static Compensation makeCompensation(People people) {
        try {
            return new Compensation(InputView.readCompensation(), people.getNames().size());
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
        }
        return null;
    }
}
